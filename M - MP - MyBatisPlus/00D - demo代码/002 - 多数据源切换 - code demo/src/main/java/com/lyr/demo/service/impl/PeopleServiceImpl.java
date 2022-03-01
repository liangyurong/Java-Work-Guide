package com.lyr.demo.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyr.demo.dao.PeopleDao;
import com.lyr.demo.entity.People;
import com.lyr.demo.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PeopleServiceImpl extends ServiceImpl<PeopleDao, People> implements PeopleService {

    @Autowired
    private PeopleDao peopleDao;

    @DS("db2")
    @Override
    public Optional<People> findPeopleById(String id) {
        People people = peopleDao.findPersonById(id);
        return Optional.ofNullable(people);
    }
}

