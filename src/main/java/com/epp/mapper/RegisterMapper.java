package com.epp.mapper;


import com.epp.pojo.Enterprise;
import com.epp.pojo.Register;
import org.apache.ibatis.annotations.*;

@Mapper
public interface RegisterMapper {

    /**
     * 查询用户名是否存在，若存在，不允许注册
     * 注解@Param(value) 若value与可变参数相同，注解可省略
     * 注解@Results  列名和字段名相同，注解可省略
     * @param enterpriseName
     * @return
     */

    @Select(value = "select e.account,e.password from enterprise e where e.enterprise_name=#{enterpriseName}")
    @Results
            ({@Result(property = "enterpriseName",column = "enterprise_name"),
                    @Result(property = "password",column = "password")})
    Enterprise findEnterpriseByName(@Param("enterpriseName") String enterpriseName);




    /**
     * 注册  插入一条enterprise记录
     * @param register
     * @return
     */
    @Insert("insert into enterprise ( enterprise_name,account ,password)values(#{enterpriseName},#{account},#{password})")
    //加入该注解可以保存对象后，查看对象插入id
    //@Options(useGeneratedKeys = true,keyProperty = "enterpriseId",keyColumn = "enterprise_id")
    void regist(Register register);

}
