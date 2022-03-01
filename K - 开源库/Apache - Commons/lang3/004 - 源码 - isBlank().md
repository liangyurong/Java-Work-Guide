### isBlank()源码

```jshelllanguage
    public static boolean isBlank(CharSequence cs) {
        // 标记字符长度
        int strLen;
        // 字符串不存在或者长度为0
        if (cs != null && (strLen = cs.length()) != 0) {
            for(int i = 0; i < strLen; ++i) {
                // 判断空格，回车，换行等，如果有一个不是上述字符，就返回false 
                if (!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }
            return true;
        } else {
            // 为null或者字符串长度为0
            return true;
        }
    }
```

### Character.isWhitespace()源码

```jshelllanguage
    public static boolean isWhitespace(char ch) {
        return isWhitespace((int)ch);
    }
    
    public static boolean isWhitespace(int codePoint) {
        return CharacterData.of(codePoint).isWhitespace(codePoint);
    }
    
    boolean isWhitespace(int ch) {
            int props = getProperties(ch);
            return ((props & 0x00007000) == 0x00004000);
    }
```
