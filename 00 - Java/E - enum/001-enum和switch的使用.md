### 目的

根据字符串，得到对应的编码code。

### enum类

```java
public enum Week {

    MONDAY(0,"星期一"),
    TUESDAY(1,"星期二"),
    WEDNESDAY(2,"星期三"),
    THURSDAY(3,"星期四"),
    FRIDAY(4,"星期五"),
    SATURDAY(5,"星期六"),
    SUNDAY(6,"星期日");

    private int code;
    private String type;

    Week(int code,String type){
        this.code=code;
        this.type=type;
    }

    public int getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

        /**
         * @param code
         * @return 根据code返回对应的实体类
         */
        public static Week getByCode(int code){
            for(Week en:Week.values()){
                if(code == en.getCode()){
                    return en;
                }
            }
            return null;
        }

    /**
     * @param type
     * @return 根据type返回对应的Week
     */
    public static Week getWeekByType(String type){
        for(Week week:Week.values()){
            if(type.equals(week.getType())){
                return week;
            }
        }
        return null;
    }

}

```

### switch

```java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @GetMapping("/test/{type}")
    public void test(@PathVariable String type) {

        // 一般我们可以在前端拿到type，于是我们可以根据type获取到一个enum实体类，然后在switch中进行比较

        Week week = Week.getWeekByType(type);
        switch (week){
            case MONDAY:
                System.out.println(week.getCode()+"今天周1，上班"); //可以替换成周一要执行的业务。
                break;
            case TUESDAY:
                System.out.println(week.getCode()+"今天周2，认真工作");//可以替换成周二要执行的业务。
                break;
            case WEDNESDAY:
                System.out.println(week.getCode()+"今天周3，摸鱼");
                break;
            case THURSDAY:
                System.out.println(week.getCode()+"今天周4，用尽了洪荒之力");
                break;
            case FRIDAY:
                System.out.println(week.getCode()+"今天周5，放假");
                break;
            case SATURDAY:
                System.out.println(week.getCode()+"今天周6，睡懒觉");
                break;
            case SUNDAY:
                System.out.println(week.getCode()+"今天周7，做家务");
                break;
            default:
                break;
        }

    }
}
```

### 参考链接

[001-恕我直言，我怀疑你没怎么用过枚举](https://segmentfault.com/a/1190000022040425)
