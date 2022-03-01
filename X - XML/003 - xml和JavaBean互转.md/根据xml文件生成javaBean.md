## 根据xml文件生成javaBean


### 1、新建person.xml文件。粘贴下面内容

```text
<?xml version="1.0" encoding="UTF-8" ?>
    <person>
           <name>yurong333</name>
           <age>25</age>
    </person>
```

### 2、在同级目录，添加trang.jar

下载路径：https://pan.baidu.com/s/1L_K8pnLH2s45qUs5PHWuMw?pwd=hr8v 提取码: hr8v

### 3、打开cmd，执行命令，生成person.xsd文件

java -jar trang.jar person.xml person.xsd

### 4、执行命令，生成java文件

xjc person.xsd -p person.java

#### 生成的Person.java

```java
//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.01.19 时间 03:38:53 PM CST 
//


package person.java;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "name",
    "age"
})
@XmlRootElement(name = "person")
public class Person {
    
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String name;
	
    @XmlElement(required = true)
    protected BigInteger age;
    
    /**
     * 获取name属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * 设置name属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * 获取age属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAge() {
        return age;
    }

    /**
     * 设置age属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAge(BigInteger value) {
        this.age = value;
    }

}

```

### 5、其他格式复杂的xml文件也可以转成JavaBean

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Document type="Request Save" versionNumber="" value="1.0">
    <realmCode code="44.CN"/>
    <code code="44.A01.09.215" codeSystem="44.CN.01" codeSystemName="广东省妇幼卫生信息交互共享文档分类编码系统"/>
    <title>请求推送孕期档案信息</title>
    <component>
        <OperationType value="New"/>
        <recordNumber value="5" type="INT"/>
        <record>
            <HDSB0101001>女方姓名</HDSB0101001>
            <HDSB0101004  code="女方证件类型代码" codesystem="CV02.01.101">女方证件类型</HDSB0101004>
        </record>
    </component>
</Document>
```






