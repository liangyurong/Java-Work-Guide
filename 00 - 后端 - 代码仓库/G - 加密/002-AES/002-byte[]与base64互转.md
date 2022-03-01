## byte[]与base64互转

```jshelllanguage

import javax.xml.bind.DatatypeConverter;
import java.util.Base64;

    /**
     * byte[]数组 转 Base64字符串
     */
    private static String byte2Str(byte[] bytes){
        return DatatypeConverter.printBase64Binary(bytes);
    }
    
    /**
     * Base64字符串 转 byte[]数组
     */
    private static byte[] str2Byte(String str){
        return Base64.getDecoder().decode(str);
    }
```
