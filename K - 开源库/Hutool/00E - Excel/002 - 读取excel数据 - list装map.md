### 源码

```java
import java.io.File;
import java.util.List;
import java.util.Map;

import cn.hutool.core.io.FileUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import org.junit.Test;

public class TestHutool {

  @Test
  public void testExcel() {
    // excel文件路径
    String filePath = "C:/Users/lyr/Desktop/basic_ino.xlsx";

    // 建立File对象
    File file = FileUtil.file(filePath);

    // 从文件中读取Excel为ExcelReader
    ExcelReader reader = ExcelUtil.getReader(file);

    // 读取为Map列表，默认第一行为标题行，Map中的key为标题，value为标题对应的单元格值
      List<Map<String,Object>> read = reader.readAll();

    // 循环取出list中的每个元素
    read.forEach(base -> {
          System.out.println(base);
    }); 

  }
}

```

### 结果说明

结果说明：list装载的是map，map装的是key=value.

没有标题,第一个map就是值， 

```text
{id=1, name=1, age=1}
{id=2, name=2, age=2}
{id=3, name=3, age=3}
```
