## MapUtils

```jshelllanguage
import org.apache.commons.lang3.StringUtils;
import java.util.Map;

public class MapUtils {
    public static boolean valueIsNotEmpty(Map<String,Object> map, String keyName){
        return map.containsKey(keyName) && (map.get(keyName)!=null && StringUtils.isNotBlank(map.get(keyName).toString()));
    }
}
```
