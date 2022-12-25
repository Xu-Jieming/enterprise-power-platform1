package com.epp.mapper;

import com.epp.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;



@Mapper
public interface LoginMapper {

    @Select("select admin_id,admin_name,tel,email,account,role from admin where account = #{account} and password = #{password}")
    public Admin adminLogin(@Param("account") String account, @Param("password") String password);


}
