package com.daxie.daxie_api.dao;

import com.daxie.daxie_api.core.Mapper;
import com.daxie.daxie_api.model.Userbaby;
import org.apache.ibatis.annotations.Param;

public interface UserbabyMapper extends Mapper<Userbaby> {

    Userbaby selectUserByid(@Param("userid") Integer userid);
}