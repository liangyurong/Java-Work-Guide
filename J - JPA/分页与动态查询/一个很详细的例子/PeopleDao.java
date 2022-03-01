package com.lyr.demo.dao;

import com.lyr.demo.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 *   PagingAndSortingRepository<People,String> 分页
 *
 *   JpaSpecificationExecutor 自定义查询条件
 */
@Repository
public interface PeopleDao extends JpaRepository<People,String>, PagingAndSortingRepository<People,String>, JpaSpecificationExecutor {

}
