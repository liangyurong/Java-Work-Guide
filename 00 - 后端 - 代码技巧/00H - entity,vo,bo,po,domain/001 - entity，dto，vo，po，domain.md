## entity

一般指的是视图，也就是和数据库对应的表，entity的每一个字段都与数据库字段对应

## dto 数据库传输对象

用来转换从 entity 到 vo，或者从 vo 到 entity 的中间的东西

## vo  view Object视图层对象

VO对应于页面上需要显示的数据（表单）

里面的每一个字段和前端对应（隐形数据比如id可以不对应）

## po

po是Persistent Object 

### 阿里规约

DO （ Data Object ）：此对象与数据库表结构一一对应，通过 DAO 层向上传输数据源对象。

DTO （ Data Transfer Object ）：数据传输对象，Service 或 Manager 向外传输的对象。

VO （ View Object ）：显示层对象，通常是 Web 向模板渲染引擎层传输的对象。

POJO 专指只有 setter/getter/toString 的 简单类，entity 属于 DO(Data Object)


### 他人说法

参数我们都是叫＊ Param，VO 是给前端返回的数据，DTO 仅使用于 service 层

后端给前端vo。前端给后端dto？

vo 在表结构基础字段上增减个性化的返回给前端，dto 在表结构基础字段上增减个性化的用于入参

### 他人说法

我们是 Controller 接收 XXRequest 类 （原始写法，就是request.getName("")）

然后在 Controller 转成 XXDTO 给 Service

Service 传 DTO 给 Mapper

Service 返回 VO 给 controller

controller 最终返回 XXResponse（是不是使用Result类去封装了？）




















