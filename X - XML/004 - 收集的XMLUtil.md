
### 收集的XMLUtil

1、xml的String字符串转为JSONObject

2、


### 源码

```jshelllanguage
package io.renren.common.utils;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.Attribute;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

/**
 * 封装了XML转换成object，object转换成XML的代码
 * Created by lyz on 2021/1/25.
 */
@Slf4j
public class XMLUtil {

    /**
     * 将对象直接转换成String类型的 XML输出
     *
     * @param obj
     * @return
     */
    public static String convertToXml(Object obj) {
        // 创建输出流
        StringWriter sw = new StringWriter();
        try {
            // 利用jdk中自带的转换类实现
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            // 格式化xml输出的格式
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            // 将对象转换成输出流形式的xml
            marshaller.marshal(obj, sw);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        log.info(sw.toString());
        return sw.toString();
    }


    /**
     * 将对象直接转换成String类型的 XML输出
     *
     * @param obj 对象
     * @param b   是否去掉 生成的xml 头部信息
     * @return
     */
    public static String convertToXml(Object obj,String methodName, Boolean b) {
        // 创建输出流
        StringWriter sw = new StringWriter();
        try {
            // 利用jdk中自带的转换类实现
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            // 格式化xml输出的格式
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            // 将对象转换成输出流形式的xml
            marshaller.marshal(obj, sw);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        //  log.info(sw.toString());
        String str = sw.toString();
        str = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:wom=\"http://woman.maternal.ws.webservice.publichealth.cybermax.com/\"><soapenv:Header/><soapenv:Body><wom:"+methodName+"><arg0><![CDATA[" + str + "]]>\n" +
                "</arg0></wom:"+methodName+"></soapenv:Body></soapenv:Envelope>";
        if (b) {
            return str.replace("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>", "");
        }
        return str;
    }


    /**
     * 将对象直接转换成String类型的 XML输出
     *
     * @param obj 对象
     * @param b   是否去掉 生成的xml 头部信息
     * @return
     */
    public static String convertToXml(Object obj, Boolean b) {
        // 创建输出流
        StringWriter sw = new StringWriter();
        try {
            // 利用jdk中自带的转换类实现
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            // 格式化xml输出的格式
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            // 将对象转换成输出流形式的xml
            marshaller.marshal(obj, sw);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        //  log.info(sw.toString());
        if (b) {
            return sw.toString().replace("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>", "");
        }
        return sw.toString();
    }

    /**
     * 将对象根据路径转换成xml文件
     *
     * @param obj
     * @param path
     */
    public static String convertToXml(Object obj, String path) {
        FileWriter fw = null;
        try {
            // 利用jdk中自带的转换类实现
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            // 格式化xml输出的格式
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            // 将对象转换成输出流形式的xml
            // 创建输出流
            fw = new FileWriter(path);
            marshaller.marshal(obj, fw);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fw.toString();
    }

    /**
     * 将String类型的xml转换成对象
     *
     * @param clazz
     * @param xmlStr
     * @return
     */
    public static Object convertXmlStrToObject(Class clazz, String xmlStr) {
        Object xmlObject = null;
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            // 进行将Xml转成对象的核心接口
            Unmarshaller unmarshaller = context.createUnmarshaller();
            StringReader sr = new StringReader(xmlStr);
            xmlObject = unmarshaller.unmarshal(sr);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return xmlObject;
    }

    /**
     * 将file类型的xml转换成对象
     *
     * @param clazz
     * @param xmlPath
     * @return
     */
    public static Object convertXmlFileToObject(Class clazz, String xmlPath) {
        Object xmlObject = null;
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            FileReader fr = null;
            fr = new FileReader(xmlPath);
            xmlObject = unmarshaller.unmarshal(fr);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return xmlObject;
    }


    public static JSONObject xml2Json(String xmlStr) throws JDOMException, IOException {
        byte[] xml = xmlStr.getBytes(StandardCharsets.UTF_8);
        JSONObject jsonObject = new JSONObject();
        //将字符串转换为输入流
        InputStream is = new ByteArrayInputStream(xml);
        //用sax解析，解析一行丢一行
        SAXBuilder saxBuilder = new SAXBuilder();
        //获得xml文档
        Document document = saxBuilder.build(is);
        //获得根元素，例如xml
        Element rootElement = document.getRootElement();
        //调用具体解析方法
        jsonObject.put(rootElement.getName(), iterateElement(rootElement));
        return jsonObject;
    }

    private static JSONObject iterateElement(Element rootElement) {
        //获得所有子元素的集合
        List note = rootElement.getChildren();
        Element et;
        JSONObject jsonObject = new JSONObject();
        List list;
        for (int i = 0; i < note.size(); i++) {
            list = new LinkedList();
            et = (Element) note.get(i);
            //此处是从>解析到<，如果有嵌套的子节点，则递归遍历
            if (et.getTextTrim().equals("")) {
                if (et.getChildren().size() == 0) continue;
                //有这个键，则用最新的值替换
                if (jsonObject.containsKey(et.getName())) {
                    list = (List) jsonObject.get(et.getName());
                }
                list.add(iterateElement(et));
                jsonObject.put(et.getName(), list);
            } else {
                if (jsonObject.containsKey(et.getName())) {
                    list = (List) jsonObject.get(et.getName());
                }
                //获得值，例如<a>1</a>,得到1
                list.add(et.getTextTrim());
                jsonObject.put(et.getName(), list);
            }
        }
        return jsonObject;
    }


    /**
     * String 转 org.dom4j.Document
     *
     * @param xml
     * @return
     * @throws DocumentException
     */
    public static org.dom4j.Document strToDocument(String xml) throws DocumentException {
        return DocumentHelper.parseText(xml);
    }

    /**
     * org.dom4j.Document 转  com.alibaba.fastjson.JSONObject
     *
     * @param xml
     * @return
     * @throws DocumentException
     */
    public static JSONObject documentToJSONObject(String xml) throws DocumentException {
        return elementToJSONObject(strToDocument(xml).getRootElement());
    }

    /**
     * org.dom4j.Element 转  com.alibaba.fastjson.JSONObject
     *
     * @param node
     * @return
     */
    public static JSONObject elementToJSONObject(org.dom4j.Element node) {
        JSONObject result = new JSONObject();
        // 当前节点的名称、文本内容和属性
        List<Attribute> listAttr = node.attributes();// 当前节点的所有属性的list
        for (Attribute attr : listAttr) {// 遍历当前节点的所有属性
            result.put(attr.getName(), attr.getValue());
        }
        // 递归遍历当前节点所有的子节点
        List<org.dom4j.Element> listElement = node.elements();// 所有一级子节点的list
        if (!listElement.isEmpty()) {
            for (org.dom4j.Element e : listElement) {// 遍历所有一级子节点
                if (e.attributes().isEmpty() && e.elements().isEmpty()) // 判断一级节点是否有属性和子节点
                    result.put(e.getName(), e.getTextTrim());// 沒有则将当前节点作为上级节点的属性对待
                else {
                    if (!result.containsKey(e.getName())) // 判断父节点是否存在该一级节点名称的属性
                        result.put(e.getName(), new JSONArray());// 没有则创建
                    ((JSONArray) result.get(e.getName())).add(elementToJSONObject(e));// 将该一级节点放入该节点名称的属性对应的值中
                }
            }
        }
        return result;
    }



}


```
