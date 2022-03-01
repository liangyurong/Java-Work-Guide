
### 使用warpper

```java

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.lyr.demo.entity.Student;
import com.lyr.demo.mapper.StudentMapper;
import com.lyr.demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TestWrapper {

    @Autowired
    private StudentMapper stuDao;

    /**
     * 使用mapper.selectList()
     * 找到任意条数据都可以使用该方法
     */
    @GetMapping("/testa/{name}")
    @ResponseBody
    public List<Student> testSelectByWarpper(@PathVariable("name") String name){
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        wrapper.eq("name",name);
        List<Student> students = stuDao.selectList(wrapper);
        return students;
    }

    /**
     * stuDao.selectOne()方法
     *   1、当只确定能找到 最多一个 的结果时，可以使用该方法。
     *   2、当能够知道两个及其以上的结果时，请不要使用selectOne方法，因为会报错：Expected one result (or null) to be returned by selectOne(), but found: 2",
     */
    @GetMapping("/testb/{name}")
    @ResponseBody
    public Student testb(@PathVariable("name") String name){
        Result result = new Result();
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        wrapper.eq("name",name);
        Student student = stuDao.selectOne(wrapper);
        return student;
    }

    /**
     * updateWrapper
     */
    @GetMapping("/testUpdate/{id}")
    @ResponseBody
    @Transactional
    public String testUpdate(@PathVariable("id") String id){
        // 根据id找到学生
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        wrapper.eq("id",id);
        Student student = stuDao.selectOne(wrapper);
        // 更新学生的信息
        UpdateWrapper<Student> updateWrapper = new UpdateWrapper<>();
        student.setName("hhhh");
        student.setMyEmail("hhhh@qq.com");
        updateWrapper.eq("id",id); // 必须
        int update = stuDao.update(student, updateWrapper);
        if(update>0){
            return "更新成功";
        }else{
            return "更新失败";
        }
    }
}

```
