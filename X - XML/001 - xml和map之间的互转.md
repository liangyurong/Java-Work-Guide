## 依赖

```text
        <!--解析xml:由于微信开发文档中，对于消息的接收发送都是基础xml数据的（太坑了），所以我们需要对XML进行解析转换-->
        <dependency>
            <groupId>dom4j</groupId>
            <artifactId>dom4j</artifactId>
            <version>1.6.1</version>
        </dependency>
        
        <!--解析xml:由于微信开发文档中，对于消息的接收发送都是基础xml数据的（太坑了），所以我们需要对XML进行解析转换-->
        <dependency>
            <groupId>jdom</groupId>
            <artifactId>jdom</artifactId>
            <version>1.1</version>
        </dependency>
        
        <!--转换xml类:由于微信开发文档中，对于消息的接收发送都是基础xml数据的（太坑了），所以我们需要对XML进行解析转换-->
        <dependency>
            <groupId>com.thoughtworks.xstream</groupId>
            <artifactId>xstream</artifactId>
            <version>1.4.5</version>
        </dependency>
```

## 源码

```java
package com.sdyb.orderwechatpay.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Test {

    public static void main(String[] args) throws DocumentException, TransformerException, ParserConfigurationException {
        String xmlStr = "<xml><appid>wx2715b11e11c650f6</appid><attach><![CDATA[attach]]></attach><body><![CDATA[order-good]]></body><mch_id>1233737702</mch_id><nonce_str>5ff00d3ef2cc4f97</nonce_str><notify_url>http://134.175.207.83:8078/wxpay/notify</notify_url><openid>123</openid><out_trade_no>2107033441499</out_trade_no><sign>DAEA432EAE1FA09BC8928EE8F0ABCD93</sign><sign_type>MD5</sign_type><spbill_create_ip>113.110.224.233</spbill_create_ip><total_fee>1</total_fee><trade_type>JSAPI</trade_type></xml>";
        System.out.println(xml2Map(xmlStr));
        System.out.println(map2Xml(xml2Map(xmlStr)));
    }

    public static Map<String,Object> xml2Map(String xml) throws DocumentException {
        Document doc = DocumentHelper.parseText(xml);
        Element books = doc.getRootElement();
        Iterator Elements = books.elementIterator();
        Map<String,Object> map = new HashMap<>();
        while (Elements.hasNext()) {
            Element user = (Element) Elements.next();
            map.put(user.getName(), user.getText());
        }
        return map;

    }

    public static String map2Xml(Map<String,Object> data) throws TransformerException, ParserConfigurationException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder= documentBuilderFactory.newDocumentBuilder();
        org.w3c.dom.Document document = documentBuilder.newDocument();
        org.w3c.dom.Element root = document.createElement("xml");
        document.appendChild(root);
        for (String key: data.keySet()) {
            String value =(String) data.get(key);
            if (value == null) {
                value = "";
            }
            value = value.trim();
            org.w3c.dom.Element filed = document.createElement(key);
            filed.appendChild(document.createTextNode(value));
            root.appendChild(filed);
        }
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        DOMSource source = new DOMSource(document);
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        transformer.transform(source, result);
        String output = writer.getBuffer().toString(); //.replaceAll("\n|\r", "");
        try {
            writer.close();
        }
        catch (Exception ex) {
        }
        return output;

    }

}

```
