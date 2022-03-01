待解决 xml

## jdk自带的javax.xml.bind.JAXBContext

默认情况下java的Date类型会自动转换成XMLGregorianCalendar，在一些特殊情况下我们希望使用java的Date类型来进行数据传递。此时我们可以使用XmlAdapter 定制日期类型。

### 知识

@XmlRootElement：根节点

@XmlAttribute：该属性作为xml的attribute

@XmlElement：该属性作为xml的element，且可以增加属性(name="NewElementName")，那么生成的xml串的elment的标签是NewElementName


### 示例

```jshelllanguage
package io.renren.modules.aiyimei.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.renren.common.config.JaxbDateSerializer;
import io.renren.common.constant.WandaGlobalProperties;
import io.renren.common.utils.TokenThreeUtils;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

/**
 * jdk自带的javax.xml.bind.JAXBContext将对象和xml字符串进行相互转换
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "interdictionCheckResultData")
@XmlAccessorType(XmlAccessType.FIELD)
public class InterdictionCheckResultData {

    // 0插入   1修改
    private Integer hisState;

    //检测日期
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    private Date icrHivDate;

    public static InterdictionCheckResultData init4Report(Integer hisState) {
        InterdictionCheckResultData resultData = new InterdictionCheckResultData();
        resultData.setHisState(hisState);
        return resultData;
    }
}


```

