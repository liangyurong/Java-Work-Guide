package com.lyr.writetosee.aspect;


import com.alibaba.fastjson.JSONObject;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.Date;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import com.lyr.writetosee.annotation.AutoLog;
import com.lyr.writetosee.constant.CommonConstant;
import com.lyr.writetosee.entity.SysLog;
import com.lyr.writetosee.service.ISysLogService;
import com.lyr.writetosee.util.IPUtils;
import com.lyr.writetosee.util.SpringContextUtils;
//import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


/**
 * 系统日志，切面处理类
 *
 * @Author scott
 * @email jeecgos@163.com
 * @Date 2018年1月14日
 */
@Aspect
@Component
public class AutoLogAspect {

    @Autowired
    private ISysLogService sysLogService;


    /**
     * 切面，监控@Autolog注解
     */
    @Pointcut("@annotation(com.lyr.writetosee.annotation.AutoLog)")
    public void logPointCut() {

    }

    /**
     * 环绕通知，可以用来在调用一个具体方法前和调用后来完成一些具体的任务。
     * @param point
     * @return
     * @throws Throwable
     */
    @Around(value = "logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();

        // 执行方法
        Object result = point.proceed();

        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;

        // 保存日志（日志不在保存在某个盘的txt文件中，而是直接保存在数据库）
        saveSysLog(point, time);

        return result;
    }

    private void saveSysLog(ProceedingJoinPoint joinPoint, long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        // 新建一个SysLog对象
        SysLog sysLog = new SysLog();

        // 通过反射？
        AutoLog syslog = method.getAnnotation(AutoLog.class);

        if (syslog != null) {
            //注解上的描述,操作日志内容
            sysLog.setLogContent(syslog.value());
            sysLog.setLogType(syslog.logType());

        }

        // 请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLog.setMethod(className + "." + methodName + "()");

        // 设置操作类型
        if (sysLog.getLogType() == CommonConstant.LOG_TYPE_2) {
            sysLog.setOperateType(getOperateType(methodName, syslog.operateType()));
        }

        // 获取request
        HttpServletRequest request = SpringContextUtils.getHttpServletRequest();

        // 请求的参数
        sysLog.setRequestParam(getReqestParams(request, joinPoint));

        // 设置IP地址
        sysLog.setIp(IPUtils.getIpAddr(request));

        // 获取登录用户信息(需要的时候再写上去。这里是用了shiro的安全验证框架)
//        LoginUser sysUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
//        if (sysUser != null) {
//            sysLog.setUserid(sysUser.getUsername());
//            sysLog.setUsername(sysUser.getRealname());
//        }

        // 耗时
        sysLog.setCostTime(time);
        sysLog.setCreateTime(new Date());

        // 保存系统日志
        sysLogService.save(sysLog);

    }

    private void saveSysLog(JoinPoint joinPoint, long time, String operateResult) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        SysLog sysLog = new SysLog();
        AutoLog syslog = method.getAnnotation(AutoLog.class);
        if (syslog != null) {
            //注解上的描述,操作日志内容
            sysLog.setLogContent(syslog.value());
            sysLog.setLogType(syslog.logType());

        }

        //请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLog.setMethod(className + "." + methodName + "()");

        //设置操作类型
        if (sysLog.getLogType() == CommonConstant.LOG_TYPE_2) {
            sysLog.setOperateType(getOperateType(methodName, syslog.operateType()));
        }

        //获取request
        HttpServletRequest request = SpringContextUtils.getHttpServletRequest();
        //请求的参数
        sysLog.setRequestParam(getReqestParams(request, joinPoint));

        //设置IP地址
        sysLog.setIp(IPUtils.getIpAddr(request));

        //获取登录用户信息
//        LoginUser sysUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
//        if (sysUser != null) {
//            sysLog.setUserid(sysUser.getUsername());
//            sysLog.setUsername(sysUser.getRealname());
//
//        }

        //耗时
        sysLog.setCostTime(time);
        sysLog.setCreateTime(new Date());
        sysLog.setOperateResult(operateResult);

        // 保存系统日志
        // additionalLogService.save(sysLog);

    }


    // 异常通知 记录在微信建档端 与访问记录分开(院方本地)
    @AfterThrowing(value = "@annotation(com.lyr.writetosee.annotation.AutoLog)", throwing = "e")
    public void exceptionAdvice(JoinPoint joinPoint, Throwable e) {
        long beginTime = System.currentTimeMillis();
        // 执行方法

        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;

        // 保存日志
        saveSysLog(joinPoint, time, exception(e));

    }

    /**
     * 将异常信息转化成字符串
     */
    private static String exception(Throwable t) {
        if (t == null) {
            return null;
        }
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            t.printStackTrace(new PrintStream(baos));
            return baos.toString();
        } catch (IOException e) {
            e.getMessage();
        }
        return null;
    }

    /**
     * 获取操作类型
     *
     * 这里有统一规定操作的前缀
     */
    private int getOperateType(String methodName, int operateType) {
        if (operateType > 0) {
            return operateType;
        }
        if (methodName.startsWith("list")) {
            return CommonConstant.OPERATE_TYPE_1;
        }
        if (methodName.startsWith("add")) {
            return CommonConstant.OPERATE_TYPE_2;
        }
        if (methodName.startsWith("edit")) {
            return CommonConstant.OPERATE_TYPE_3;
        }
        if (methodName.startsWith("delete")) {
            return CommonConstant.OPERATE_TYPE_4;
        }
        if (methodName.startsWith("import")) {
            return CommonConstant.OPERATE_TYPE_5;
        }
        if (methodName.startsWith("export")) {
            return CommonConstant.OPERATE_TYPE_6;
        }
        return CommonConstant.OPERATE_TYPE_1;
    }

    /**
     * @param request: request
     * @param joinPoint: joinPoint
     * @Description: 获取请求参数
     * @author: scott
     * @date: 2020/4/16 0:10
     * @Return: java.lang.String
     */
    private String getReqestParams(HttpServletRequest request, JoinPoint joinPoint) {
        String httpMethod = request.getMethod();
        String params = "";
        if ("POST".equals(httpMethod) || "PUT".equals(httpMethod) || "PATCH".equals(httpMethod)) {
            Object[] paramsArray = joinPoint.getArgs();
            // java.lang.IllegalStateException: It is illegal to call this method if the current request is not in asynchronous mode (i.e. isAsyncStarted() returns false)
            //  https://my.oschina.net/mengzhang6/blog/2395893
            Object[] arguments = new Object[paramsArray.length];
            for (int i = 0; i < paramsArray.length; i++) {
                if (paramsArray[i] instanceof ServletRequest
                        || paramsArray[i] instanceof ServletResponse
                        || paramsArray[i] instanceof MultipartFile) {
                    //ServletRequest不能序列化，从入参里排除，否则报异常：java.lang.IllegalStateException: It is illegal to call this method if the current request is not in asynchronous mode (i.e. isAsyncStarted() returns false)
                    //ServletResponse不能序列化 从入参里排除，否则报异常：java.lang.IllegalStateException: getOutputStream() has already been called for this response
                    continue;
                }
                arguments[i] = paramsArray[i];
            }

            params = JSONObject.toJSONString(arguments);
        } else {
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Method method = signature.getMethod();
            // 请求的方法参数值
            Object[] args = joinPoint.getArgs();
            // 请求的方法参数名称
            LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
            String[] paramNames = u.getParameterNames(method);
            if (args != null && paramNames != null) {
                for (int i = 0; i < args.length; i++) {
                    params += "  " + paramNames[i] + ": " + args[i];
                }
            }
        }
        return params;
    }
}
