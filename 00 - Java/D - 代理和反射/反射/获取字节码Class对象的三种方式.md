## 获取字节码Class对象的三种方式

1、Class.forName()，主动将字节码文件加入内存

    多用于配置文件，字节码文件路径写在配置文件中

2、通过类名的class属性获取

    多用于参数的传递，比如参数是 Class User.class

3、通过对象的getClass()方法获取

    多用于对象的字节码获取

### code

```jshelllanguage
package com.demo.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectTest {
    public static void main(String[] args) throws Exception {

        Class cls1 = get1();
        Class cls2 = get2();
        Class cls3 = get3();

        System.out.println(cls1); // class com.demo.reflect.ReflectUser
        System.out.println(cls2); // class com.demo.reflect.ReflectUser
        System.out.println(cls3); // class com.demo.reflect.ReflectUser
    
        // 同一个字节码文件（ReflectUser.class）在一次程序运行中，只会被加载一次
        System.out.println(cls1==cls2); // true
        System.out.println(cls1==cls3); // true
        System.out.println(cls2==cls3); // true
    
    }


    // Class.forName()，主动将字节码文件加入内存
    public static Class get1() throws Exception {
        // 全类名
        String classPath = "com.demo.reflect.ReflectUser";
        // 主动将字节码文件加载进内存
        Class<?> clazz = Class.forName(classPath);
        return clazz;
    }

    // 通过类名的class属性获取
    public static Class get2() {
        Class<ReflectUser> clazz = ReflectUser.class;
        return clazz;
    }

    // 通过对象的getClass()方法获取
    public static Class get3()  {
        ReflectUser user = new ReflectUser();
        Class clazz = user.getClass();
        return clazz;
    }
    
}


class ReflectUser{
    private String name ;
    private int age ;

    public ReflectUser() {
        this.name = "yurong333";
         this.age=123;
    }

    public ReflectUser(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 成员方法
    public void eat(){
        System.out.println("eat.........");
    }

    // 成员方法
    public void sleep(){
        System.out.println("sleep.........");
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


}

```
















