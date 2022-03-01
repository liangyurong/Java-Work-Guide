
### 实体类Customer
```java
package com.jpa.specifications.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "cst_customer")
public class Customer {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private Integer custId;

    @Column(name="cust_name")
    private String custName;

    @Column(name="cust_source")
    private String custSource;

    @Column(name="cust_industry")
    private String custIndustry;

    @Column(name="cust_level")
    private String custLevel;

    @Column(name="cust_address")
    private String custAddress;

    @Column(name="cust_phone")
    private String custPhone;
}
```

### dao层
```java
package com.jpa.specifications.repostory;

import com.jpa.specifications.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CustomerRepository extends JpaRepository<Customer, Integer>, JpaSpecificationExecutor<Customer> {
}
```

### 测试代码
```java
package com.jpa.specifications;

import com.jpa.specifications.domain.Customer;
import com.jpa.specifications.repostory.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import javax.persistence.criteria.*;
import java.util.List;

@SpringBootTest
public class SpecificationsTest {

    @Autowired
    CustomerRepository repository;

    /**
     * 根据名字查询
     *
     * 单条件查询
     */
    @Test
    public void test() {
        //匿名内部类的一个写法
        /**
         * 自定义查询条件
         *  1.实现Specification接口,需要提供泛型
         *  2.实现toPredicate方法（构造查询条件）
         *  3.需要借助方法的两个参数：root与criteriaBuilder
         *      1.root：获取需要查询的对象的属性
         *      2.criteriaBuilder：构造查询条件，内部封装了很多的查询条件（模糊匹配，精准匹配。。。）
         */
        Specification<Customer> spec = new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                //1.获取比较的属性
                Path<Object> custNamePath = root.get("custName");
                //2.构造查询条件，select * from cst_customer where cust_name = 'yurong333'
                /**
                 * 第一个参数：需要比较的属性，也就是上面的Path对象，这里的Path对象是custNamePath
                 * 第二个参数：当前需要比较的取值
                 */
                Predicate predicate = cb.equal(custNamePath, "yurong333");//进行精准匹配（需要比较的属性，比需要较的属性的值）
                return predicate;
            }
        };
        Customer c = repository.findOne(spec).get();
        System.out.println(c);
    }


    /**
     * 多条件查询
     * <p>
     * 根据客户名称和客户行业来查询
     */
    @Test
    public void testFindByNameAndIndustry() {
        /**
         * root：获取属性
         *  1.客户姓名,custName
         *  2.客户行业,custIndustry
         *
         * cb：构造查询
         *  1.构造客户名的精准查询
         *  2.构造客户行业的精准查询
         *  3.联系两个查询
         */
        Specification<Customer> spec = new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery cq, CriteriaBuilder cb) {
                //获取Path对象
                Path<Object> path1 = root.get("custName");
                Path<Object> path2 = root.get("custIndustry");
                //构造客户名的精准查询
                Predicate p1 = cb.equal(path1, "yurong333");
                //构造客户行业的精准查询
                Predicate p2 = cb.equal(path2, "python");
                //与操作
                Predicate and = cb.and(p1, p2);
                return and;
            }
        };
        Customer c = repository.findOne(spec).get();
        System.out.println(c);
    }


    /**
     * 根据客户名称的模糊匹配进行查找
     */
    @Test
    public void testFindByName() {
        Specification<Customer> spec = new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery cq, CriteriaBuilder cb) {
                //获取Path对象
                Path<Object> path = root.get("custName");
                //构造客户名的精准查询
                Predicate like = cb.like(path.as(String.class),"yurong%");
                return like;
            }
        };
        /**
         * 使用排序进行输出查询结果
         *
         * 创建排序对象，需要调用构造方法实例化sort对象
         *  1.第一个参数：升序，倒序
         *      1.sort.Direction.ASC:升序
         *      2.sort.Direction.DESC:倒序
         *  2.第二个参数：排序的属性名称
         */
        //已经无法使用的方法：Sort sort = new Sort(Sort.Direction.DESC, "CustPhone");

        //使用Sort.by()进行排序
        Sort sort = Sort.by(Sort.Direction.DESC, "CustPhone");//CustPhone是实例类属性名称，不是数据库的
        List<Customer> list = repository.findAll(spec,sort);
        for(Customer c:list){
            System.out.println(c);
        }
    }


    /**
     * 使用动态查询完成分页查询
     *
     * 查出客户名称含有“yurong”的记录，并且分页
     *
     *  1.第一个参数specification：查询条件
     *  2.第二个参数pageable：分页参数，
     *
     *  findAll(specification,pageable),返回Page(SpringData JPA为我们封装好的pageBean对象)
     *      1.通过这个pageBean对象的方法可以获取数据列表，总条数
     */
    @Test
    public void testPagination(){
        //这个是lambda表达式的表示方法
        Specification<Customer> spec = (Specification<Customer>) (root, cq, cb) -> {
            //获取Path对象
            Path<Object> path = root.get("custName");
            //构造客户名的精准查询
            Predicate like = cb.like(path.as(String.class),"yurong%");
            return like;
        };

        /**
         * 第一个参数：当前查询的页数，从0开始
         * 第二个参数：每页查询的数量
         */
        PageRequest pageRequest = PageRequest.of(0, 3);//从第一页（0）开始查，每页查询3条(每页放3条查询记录)
        //分页查询
        Page<Customer> page = repository.findAll(spec, pageRequest);
        System.out.println(page.getTotalElements()); //查询到的总记录条数
        System.out.println(page.getTotalPages());    //总共的页面数
        List<Customer> list = page.getContent();
        for(Customer c:list){
            System.out.println(c);
        }
    }
}

