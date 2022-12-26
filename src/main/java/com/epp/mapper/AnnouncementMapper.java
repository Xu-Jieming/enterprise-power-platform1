package com.epp.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.pojo.Announcement;

import java.util.List;

import org.apache.ibatis.annotations.*;



@Mapper
public interface AnnouncementMapper {
    //long countByExample(AnnouncementExample example);

    //int deleteByExample(AnnouncementExample example);

    @Delete("delete from announcement" +
            " where announcement_id = #{announcementId,jdbcType=INTEGER}")
    int deleteByPrimaryKey(Integer announcementId);

    @Insert("insert into announcement (comment,created)" +
            "values (#{comment,jdbcType=VARCHAR},#{created,jdbcType=DATE})")
    int insert(Announcement record);

    //int insertSelective(Announcement record);

    //List<Announcement> selectByExample(AnnouncementExample example);

    @Select("select * from announcement" +
            " where announcement_id = #{announcementId,jdbcType=INTEGER}")
    Announcement selectByPrimaryKey(Integer announcementId);


    @Select("select * from announcement")
    List<Announcement> selectAll();

    @Select("select * from announcement")
    IPage<Announcement> selectAll(Page page);


    ////int updateByExampleSelective(@Param("record") Announcement record,@Param("example") AnnouncementExample example);

    //int updateByExample(@Param("record") Announcement record,@Param("example") AnnouncementExample example);

    //int updateByPrimaryKeySelective(Announcement record);

    @Update("update announcement" +
            "set comment = #{comment,jdbcType=VARCHAR}," +
            "created = #{created,jdbcType=DATE}" +
            " where announcement_id = #{announcementId,jdbcType=INTEGER}")
    int updateByPrimaryKey(Announcement record);
}