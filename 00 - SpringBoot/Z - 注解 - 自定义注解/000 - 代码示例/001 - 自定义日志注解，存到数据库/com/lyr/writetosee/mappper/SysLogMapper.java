package com.lyr.writetosee.mappper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyr.writetosee.entity.SysLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface SysLogMapper extends BaseMapper<SysLog> {

}

