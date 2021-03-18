package com.example.oright.dao;

import com.example.oright.bean.Passage;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassageDao {

    @Insert("insert into passage(pid,aid,content,title,time,type,theme) values(#{pid},#{aid}, #{content},#{title},#{time},#{type},#{theme})")
    public void insertContent(@Param("pid") int pid, @Param("aid") int aid,@Param("content") String content,@Param("title") String title,@Param("time") String time,@Param("type") String type,@Param("theme") String theme);

    @Select("select * from passage")
    public List<Passage> getAllPsg();

    @Select("select * from passage where content like #{content} or theme like #{content} or title like #{content} or type like #{content}")
    public List<Passage> getAllPsgSearch(@Param("content") String content);

    @Select("select * from passage where aid=#{aid}")
    public List<Passage> getAllPsgByAid(@Param("aid") int aid);

    @Delete("delete from passage where pid=#{pid}")
    public void deleteP(@Param("pid") int pid);

}
