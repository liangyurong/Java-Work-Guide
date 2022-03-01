package com.lyr.demo.service;

import com.lyr.demo.entity.People;

import java.util.List;

public interface PeopleService {

    List<People> getPeopleByPageAndSize(Integer page,Integer size);

    List<People> getPeopleByPageAndSizeAndName(Integer page,Integer size,String name);

    List<People> getPeopleByPageAndSizeAndNameAndMyEmail(Integer page,Integer size,String name,String myEmail);

    List<People> getPeopleByPageAndSizeAndNameAndMyEmailAndAddress(Integer page,Integer size,String name,String myEmail,String address);

}
