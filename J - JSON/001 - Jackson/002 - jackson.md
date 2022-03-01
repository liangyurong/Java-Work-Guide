

### jackson注解

- @JsonProperty(access = JsonProperty.Access.READ_ONLY)

支持序列化，不支持反序列化。

- @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)

支持反序列化，不支持序列化。

- @JsonIgnore

如果命名不规范，该注解不起作用。用于成员变量上。

作用：在生成json的时候不生成该属性。
