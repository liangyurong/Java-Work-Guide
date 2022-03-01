

```java

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 可以看到此类中，编码设置了；对源头地址直接采用 get 的方法不需要每次都重新修改了；
 * 请求方法接受 POST、GET、OPTIONS 和 DELETE；请求中也允许了各种类型奇奇怪怪的请求头，应有尽有；
 * 最后还设置了允许携带 Cookie 信息，允许同步 Session 信息等。
 * 方法的参数是 HttpServlet 中的 Response 和 Request，对 Response 进行处理后返回。
 * 基本上以后遇到什么需要跨域的处理，直接在需要的地方调用这个方法即可，比我之前百度到的什么配置全局拦截器好用多了。
 */
public class CorsUtil {

    private static final String OPTIONS_FOR_REQUEST = "OPTIONS";

    public static void setResponseHeader(HttpServletRequest request,HttpServletResponse response) {
        // 设置编码格式
        response.setContentType("text/html;charset=UTF-8");
        // 允许哪些Origin发起跨域请求,nginx下正常
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        // 允许请求的方法
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        // 多少秒内，不需要再发送预检验请求，可以缓存该结果
        response.setHeader("Access-Control-Max-Age", "86400");
        // 表明它允许跨域请求包含xxx头
        response.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With," +
                "If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type," +
                "X-E4M-With,userId,token, Accept, Authorization");
        // 允许浏览器携带用户身份信息（cookie）
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("XDomainRequestAllowed", "1");
        // 允许OPTIONS请求直接通过
        if (OPTIONS_FOR_REQUEST.equals((request).getMethod().toUpperCase())) {
            response.setStatus(HttpServletResponse.SC_OK);
        }
    }
}

```
