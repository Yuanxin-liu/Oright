package com.example.oright.dao;

import com.example.oright.bean.Author;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorDao {

    @Insert("insert into author(id,username,password,email,phone) values(#{id},#{username}, #{password}, #{email}, #{phone})")
    public void insertA(@Param("id") int id,@Param("username") String username, @Param("password") String password, @Param("email") String email, @Param("phone") String phone);


    @Select("select * from author")
    public List<Author> getAllA();

    @Select("select * from author where id=#{id}")
    public Author getAuthorById(@Param("id") int id);

    @Select("select * from author where username=#{username} and password=#{password}")
    public Author getAuthorByNamePwd(@Param("username") String username,@Param("password") String password);

    @Select("select id from author where username=#{username} and password=#{password}")
    public int getIdByNamePwd(@Param("username") String username,@Param("password") String password);

    @Select("select id from author where username=#{username}")
    public int getIdByName(@Param("username") String username);


    @Select("select username from author where id=#{id}")
    public String getNameById(@Param("id") int id);

    @Update("update author set email=#{email},phone=#{phone} where username=#{username} and password=#{password}")
    public void updateAuthor(@Param("username") String username,@Param("password") String password,@Param("phone") String phone,@Param("email") String email);

}
