import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {

    private String name;
    private Integer age;
    private List<String> books;

    @Override
    public String toString() {
        return this.getName()+" "+this.getAge()+" "+this.getBooks();
    }

}
