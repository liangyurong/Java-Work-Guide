
### like模糊查询

select * from student where 1=1 and my_email like %my_email%

### 对应的xml

<if>里面的字段对应的是java

```xml
    <select id="selectStudentLikeMyEmail" resultMap="BaseResultMap" parameterType="string">
        select * from student where 1=1
        <if test="myEmail!=null"> and my_email like  "%"#{MyEmail}"%" </if>
    </select>
```
