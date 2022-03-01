

### 需要构建的东西

<HDSB0101018 code="民族代码"  codesystem="GB/T 3304"> 民族 </HDSB0101018>

### 类

```java
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "value"
})
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@XmlRootElement(name = "HDSB0101018") // 
public class HDSB0101018 {

    @XmlValue // XmlValue是用于映射直接应用XML元素的文本内容
    protected String value; // 这里填写的是“民族”

    @XmlAttribute(name = "code") // @XmlAttribute用于映射XML元素属性的，默认的属性名称与Java类的属性名称一致
    protected String code;

    @XmlAttribute(name = "codesystem")
    protected String codesystem="GB/T 3304";

}

```
