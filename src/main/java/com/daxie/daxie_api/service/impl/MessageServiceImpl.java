package com.daxie.daxie_api.service.impl;

import com.daxie.daxie_api.dao.MessageMapper;
import com.daxie.daxie_api.model.Message;
import com.daxie.daxie_api.service.MessageService;
import com.daxie.daxie_api.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by 代码生成器 on 2019/09/09.
 */
@Service
@Transactional
public class MessageServiceImpl extends AbstractService<Message> implements MessageService {
    @Resource
    private MessageMapper messageMapper;
    @Override
    public List<Message> selectMessage(String mobile, int messagestatus){
        List<Message> list=messageMapper.selectMessage(mobile,messagestatus);
        return  list;
    }

    @Override
    public List<Message> selectTime(){
        List<Message> list=messageMapper.selectTime();
        return    list;
    }
}
