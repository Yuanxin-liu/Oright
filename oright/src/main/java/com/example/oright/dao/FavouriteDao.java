package com.example.oright.dao;

import com.example.oright.bean.Favourite;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavouriteDao {
    @Insert("insert into favourite(fid,pid,aid) values(#{fid},#{pid},#{aid})")
    public void insertF(@Param("fid") int fid,@Param("pid") int pid, @Param("aid") int aid);

    @Select("select * from favourite")
    public List<Favourite> getAllF();

    @Select("select * from favourite where aid=#{aid}")
    public List<Favourite> getAllFByAid(@Param("aid") int aid);

    @Select("select fid from favourite where pid=#{pid} and aid=#{aid}")
    public int getFidByAidPid(@Param("pid") int pid, @Param("aid") int aid);

    @Delete("delete from favourite where fid=#{fid}")
    public void deleteF(@Param("fid") int fid);
}
