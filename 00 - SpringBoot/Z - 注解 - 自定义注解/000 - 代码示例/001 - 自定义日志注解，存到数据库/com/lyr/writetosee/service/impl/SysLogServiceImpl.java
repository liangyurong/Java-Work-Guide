package com.lyr.writetosee.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyr.writetosee.entity.SysLog;
import com.lyr.writetosee.mappper.SysLogMapper;
import com.lyr.writetosee.service.ISysLogService;
import org.springframework.stereotype.Service;

@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements ISysLogService {

}
