package com.example.oright.dao;

import com.example.oright.bean.Author;
import com.example.oright.bean.Firm;
import org.apache.ibatis.annotations.*;

import java.util.List;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FirmDao {
    @Insert("insert into firm(id,username,password,email,phone) values(#{id},#{username}, #{password}, #{email}, #{phone})")
    public void insertFirm(@Param("id") int id, @Param("username") String username, @Param("password") String password, @Param("email") String email, @Param("phone") String phone);


    @Select("select id from firm where username=#{username}")
    public int getFirmIdByName(@Param("username") String username);


    @Select("select * from firm")
    public List<Firm> getAllFirm();

    @Select("select * from firm where username=#{username}")
    public Firm getFirmByName(@Param("username") String username);

    @Select("select * from firm where id=#{id}")
    public Firm getFirmById(@Param("id") int id);

    @Update("update firm set email=#{email},phone=#{phone} where username=#{username} and password=#{password}")
    public void updateFirm(@Param("username") String username,@Param("password") String password,@Param("phone") String phone,@Param("email") String email);


}
