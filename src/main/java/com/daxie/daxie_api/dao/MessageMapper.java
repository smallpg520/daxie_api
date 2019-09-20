package com.daxie.daxie_api.dao;

import com.daxie.daxie_api.core.Mapper;
import com.daxie.daxie_api.model.Message;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MessageMapper extends Mapper<Message> {
   public List<Message> selectMessage(@Param("mobile") String mobile, @Param("messagestatus") int messagestatus);

   public List<Message> selectTime();
}