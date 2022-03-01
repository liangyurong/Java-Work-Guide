
### 源码

```java
import java.io.File;
import java.util.List;
import cn.hutool.core.io.FileUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.sdyb.mp.dto.PersonDto;
import org.junit.Test;
public class TestHutool {

  @Test
  public void testExcel() {
    // excel文件路径
    String filePath = "C:/Users/lyr/Desktop/basic_info.xlsx";

    // 建立File对象
    File file = FileUtil.file(filePath);

    // 从文件中读取Excel为ExcelReader
    ExcelReader reader = ExcelUtil.getReader(file);

    // 读取为Bean列表，Bean中的字段名为标题，字段值为标题对应的单元格值。
    // 标题字段需要对应实体的字段
      List<PersonDto> read = reader.readAll(PersonDto.class);

    // 循环取出list中的每个元素
    // 若某行的数据为空，则会输出null
    read.forEach(
        base -> {
          System.out.println(base.getId()+" "+base.getName()+" "+base.getAge()); 
    });
  }
}
```

### 结果

```text
1 1 1
2 2 2
3 3 3
```
