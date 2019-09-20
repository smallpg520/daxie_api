package com.daxie.daxie_api.service;
import com.daxie.daxie_api.model.Message;
import com.daxie.daxie_api.core.Service;

import java.util.List;


/**
 * Created by 代码生成器 on 2019/09/09.
 */
public interface MessageService extends Service<Message> {

    List<Message> selectMessage(String mobile, int messagestatus);

    List<Message> selectTime();
}
