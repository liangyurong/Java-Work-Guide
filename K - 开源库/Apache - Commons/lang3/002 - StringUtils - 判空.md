
### 一、基础

工具类org.apache.commons.lang3.StringUtils是JDK提供的操作String类型数据常用工具类。

重点：StringUtils主要是操作String类型。

### 二、依赖

不是这个：import org.springframework.util.StringUtils;

而是这个:import org.apache.commons.lang3.StringUtils;
```xml
<dependency>
    <groupId>commons-lang</groupId>
    <artifactId>commons-lang</artifactId>
    <version>2.6</version>
</dependency>
```

### 三、常用方法

- contains()
- isBlank(String str)
- isEmpty(String str)

### 四、isBlank(String str)与isEmpty(String str)的区别

区别只是在于，对于空格字符串的判断。

```jshelllanguage
  public static void main(String[] args) {

    // isBlank
    System.out.println(StringUtils.isBlank(""));   // true
    System.out.println(StringUtils.isBlank(" "));  // true
    System.out.println(StringUtils.isBlank(null)); // true

    // isEmpty
    System.out.println(StringUtils.isEmpty(""));   // true
    System.out.println(StringUtils.isEmpty(" "));  // false。有空格。
    System.out.println(StringUtils.isEmpty(null)); // true


  }
```

### 源码分析 - isBlank(String str)： 如果字符串有长度且里面的字符不是空白字符，则返回fasle，其余情况返回true。
```text
public static boolean isBlank(String str) {
    int strLen;
    if (str != null && (strLen = str.length()) != 0) {
        for(int i = 0; i < strLen; ++i) {
            //isWhitespace() 方法用于判断指定字符是否为空白字符，空白符包含：空格、tab 键、换行符。
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    } else {
        return true;
    }
}
```

### 源码分析 - isEmpty(String str)
```text
public static boolean isEmpty(String str) {
    return str == null || str.length() == 0;
}
```

源码分析 - Contains()
```text
public static boolean contains(String str, String searchStr) {
    if (str != null && searchStr != null) {
        return str.indexOf(searchStr) >= 0;
    } else {
        return false;
    }
}
```

