## @XmlSeeAlso

XmlSeeAlso用于指定相关的Class，使其在创建JAXBContext时能够自动被JAXBContext识别。

如下示例在创建JAXBContext时只需要传入Root类，其中动态引入到的User类型的对象也能被JAXBContext识别，因为Root类上已经通过@XmlSeeAlso引入了User类。































