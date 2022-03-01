package com.lyr.demo.service.impl;

import com.lyr.demo.dao.PeopleDao;
import com.lyr.demo.entity.People;
import com.lyr.demo.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.criteria.*;
import java.util.LinkedList;
import java.util.List;

@Service
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    private PeopleDao pDao;

    @Override
    public List<People> getPeopleByPageAndSize(Integer page, Integer size) {

        if(page <= 0 || size <= 0){
            return new LinkedList<>();
        }

        page=page-1; // 默认从0开始(传递的page为1，则底层需要减1)

        // 无自定义查询条件,因此不用Specification

        //pageable pageable= PageRequest.of(page,size,Sort.by("id").descending());   // 根据id降序排序（数据库怎么排序，倒序给出排序结果）
        Pageable pageable= PageRequest.of(page,size,Sort.by("id").ascending());      // 根据id升序排序（数据库怎么排序，就怎么给出排序结果）

        Page<People> all = pDao.findAll(pageable); //数据库操作获取查询结果
        List<People> list = all.getContent();      //将查询结果转换为List
        return list;
    }

    // 单条件
    @Override
    public List<People> getPeopleByPageAndSizeAndName(Integer page,Integer size,String name) {
        if(page <= 0 || size <= 0){
            return new LinkedList<>();
        }

        page=page-1; // 默认从0开始(传递的page为1，则底层需要减1)

        // 自定义查询条件：单条件
        Specification<People> spec= (Specification<People>) (root, cq, cb) -> {
            // Predicate equal = cb.equal(root.get("name"), name);// 相当于 where name = 我传递的字段
            Predicate equal = cb.like(root.get("name"),"%" + name.trim() + "%");// 相当于 where name like 我传递的字段
            return equal;
        };

//        等同上面的
//        Specification<People> spec=new Specification<People>() {
//            @Override
//            public Predicate toPredicate(Root<People> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
//                // 目前只是定义了一个条件，如果需要定义多个条件呢？
//                Path<People> path = root.get("name");
//                // Predicate equal = cb.equal(path, name);// 相当于 where name = 我传递的字段
//                Predicate equal = cb.like(root.get("name"),"%" + name.trim() + "%");// 相当于 where name like 我传递的字段
//                return equal;
//            }
//        };

        //pageable pageable= PageRequest.of(page,size,Sort.by("id").descending());   // 根据id降序排序（数据库怎么排序，倒序给出排序结果）
        Pageable pageable= PageRequest.of(page,size,Sort.by("id").ascending());      // 根据id升序排序（数据库怎么排序，就怎么给出排序结果）

        Page<People> all = pDao.findAll(spec,pageable); //数据库操作获取查询结果
        List<People> list = all.getContent();//将查询结果转换为List
        return list;
    }

    // 双条件
    @Override
    public List<People> getPeopleByPageAndSizeAndNameAndMyEmail(Integer page,Integer size,String name,String myEmail) {
        if(page <= 0 || size <= 0){
            return new LinkedList<>();
        }

        page=page-1; // 默认从0开始(传递的page为1，则底层需要减1)

        // 双条件：都是equal
        Specification<People> spec= (Specification<People>) (root, cq, cb) -> {
            Predicate p1 = cb.equal(root.get("name"), name);
            Predicate p2 = cb.equal(root.get("myEmail"), myEmail);
            return cb.and(p1, p2);
        };

        // 双条件：都是like
//        Specification<People> spec= (Specification<People>) (root, cq, cb) -> {
//            Predicate p1 = cb.like(root.get("name"),"%" + name.trim() + "%");
//            Predicate p2 = cb.like(root.get("myEmail"),"%" + myEmail.trim() + "%");
//            return cb.and(p1, p2);
//        };

        // 双条件：一个equal，一个like
//        Specification<People> spec= (Specification<People>) (root, cq, cb) -> {
//            Predicate p1 = cb.equal(root.get("name"), name);
//            Predicate p2 = cb.like(root.get("myEmail"),"%" + myEmail.trim() + "%");
//            return cb.and(p1, p2);
//        };

        Pageable pageable= PageRequest.of(page,size,Sort.by("id").ascending());      // 根据id升序排序（数据库怎么排序，就怎么给出排序结果）

        Page<People> all = pDao.findAll(spec,pageable); //数据库操作获取查询结果
        List<People> list = all.getContent();//将查询结果转换为List
        return list;
    }

    // 三条件
    @Override
    public List<People> getPeopleByPageAndSizeAndNameAndMyEmailAndAddress(Integer page,Integer size,String name, String myEmail, String address) {
        if(page <= 0 || size <= 0){
            return new LinkedList<>();
        }

        page=page-1; // 默认从0开始(传递的page为1，则底层需要减1)

        // 三条件：都是equal
        Specification<People> spec= (Specification<People>) (root, cq, cb) -> {
            Predicate p1 = cb.equal(root.get("name"), name);
            Predicate p2 = cb.equal(root.get("myEmail"), myEmail);
            Predicate p3 = cb.equal(root.get("address"), address);
            return cb.and(p1, p2,p3);
        };
        Pageable pageable= PageRequest.of(page,size,Sort.by("id").ascending());      // 根据id升序排序（数据库怎么排序，就怎么给出排序结果）

        Page<People> all = pDao.findAll(spec,pageable); //数据库操作获取查询结果
        List<People> list = all.getContent();//将查询结果转换为List
        return list;
    }
}
