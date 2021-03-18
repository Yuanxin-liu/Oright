package com.example.oright.dao;

import com.example.oright.bean.Concern;
import com.example.oright.bean.Favourite;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConcernDao {
    @Insert("insert into concern(cid,fans_id,author_id) values(#{cid},#{fans_id},#{author_id})")
    public void insertC(@Param("cid") int cid, @Param("fans_id") int fans_id, @Param("author_id") int author_id);

    @Select("select * from concern")
    public List<Concern> getAllC();

    @Select("select * from concern where fans_id=#{fans_id}")
    public List<Concern> getAllCByFansId(@Param("fans_id") int fans_id);

    @Select("select * from concern where author_id=#{author_id}")
    public List<Concern> getAllCByAuthorId(@Param("author_id") int author_id);

    @Delete("delete from concern where fans_id=#{fans_id} and author_id=#{author_id}")
    public void deleteC(@Param("fans_id") int fans_id,@Param("author_id") int author_id);




}
