## ResultType和ResultMap

相同点

    resultType和resultMap都是映射结果集到Javabean用的

不同点

    resultType属于自动映射到javabean，而resultMap是手动映射到Javabean的，其中简单的映射关系可以使用resultType，复杂映射关系的推荐使用resultMap。
    
    使用resultMap需要先在mapper.xml中定义resultMap。而resultType则无需定义。

### 一、ResultType

使用resultType，要求属性名必须和列名一致

#### 1.1 返回类型是String

    <select id="getNameByCode" resultType="string">
        SELECT name FROM `area_info_tab` where code = #{code}
    </select>

### 二、ResultMap

当返回类型直接是一个ResultMap的时候也是非常有用的，这主要用在进行复杂联合查询上，因为进行简单查询是没有什么必要的。

先看看一个返回类型为ResultMap的简单查询，再看看复杂查询的用法。

#### 2.1 使用resultMap需要先在mapper.xml中定义resultMap

```xml
    <!-- 通用查询映射结果 -->
    <resultMap id="BaseResultMap" type="com.sdyb.aiyimei.entity.Student">
        <id column="id" property="id" />
        <result column="name" property="name" />
        <result column="my_email" property="myEmail" />
    </resultMap>
```










