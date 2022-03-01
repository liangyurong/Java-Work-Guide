

```java
import cn.hutool.json.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JsonTool1 {

  public static void main(String[] args) {

      List<StuA> stuAList = new ArrayList<>();
      stuAList.add(new StuA("4",4));
      stuAList.add(new StuA("1",1));
      stuAList.add(new StuA("2",2));
      stuAList.add(new StuA("5",5));
      stuAList.add(new StuA("3",3));

      // 将A的所有元素复制给B
      List<StuB> stuBList = stuAList.stream().map(
              en -> new StuB(
                      en.getName(),
                      en.getAge(),
                     null
              )).collect(Collectors.toList());

    for (int i = 0; i < stuBList.size(); i++) {
      System.out.println(stuBList.get(i));
    }
  }

}

@Data
@AllArgsConstructor
class StuA{
    private String name;
    private int age;
}

@Data
@AllArgsConstructor
class StuB{
    private String name;
    private int age;
    List<String> addressList;
}



```
