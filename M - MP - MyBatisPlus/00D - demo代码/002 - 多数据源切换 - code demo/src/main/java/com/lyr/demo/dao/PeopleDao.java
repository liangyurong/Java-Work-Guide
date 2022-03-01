package com.lyr.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyr.demo.entity.People;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@Mapper
public interface PeopleDao extends BaseMapper<People> {

    People findPersonById(String id);

}
