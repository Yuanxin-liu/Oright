package com.example.oright.dao;

import com.example.oright.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    @Update("update user set password=#{password} where username=#{username}")
    public void updateUserpwd(@Param("username") String username,@Param("password") String password);


    @Select("select * from user where username=#{username}")
    public  User getUserByName(@Param("username") String username);


    @Select("select * from user where username=#{username} and role=#{role}")
    public User getUserByNameRole(@Param("username") String username,@Param("role") String role);

}
