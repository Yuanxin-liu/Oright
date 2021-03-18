package com.example.oright.dao;

import com.example.oright.bean.Favourite;
import com.example.oright.bean.Favourite2;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Favourite2Dao {
    @Insert("insert into favourite2(fid,pid,firm_id) values(#{fid},#{pid},#{firm_id})")
    public void insertF(@Param("fid") int fid,@Param("pid") int pid, @Param("firm_id") int firm_id);

    @Select("select * from favourite2")
    public List<Favourite2> getAllF();

    @Select("select * from favourite2 where firm_id=#{firm_id}")
    public List<Favourite2> getAllFByAid(@Param("firm_id") int firm_id);

    @Select("select fid from favourite2 where pid=#{pid} and firm_id=#{firm_id}")
    public int getFidByAidPid(@Param("pid") int pid, @Param("firm_id") int firm_id);

    @Delete("delete from favourite2 where fid=#{fid}")
    public void deleteF(@Param("fid") int fid);

}
