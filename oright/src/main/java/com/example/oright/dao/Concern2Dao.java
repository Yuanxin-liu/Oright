package com.example.oright.dao;

import com.example.oright.bean.Concern;
import com.example.oright.bean.Concern2;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Concern2Dao {
    @Insert("insert into concern2(cid,fans_id,author_id) values(#{cid},#{fans_id},#{author_id})")
    public void insertC(@Param("cid") int cid, @Param("fans_id") int fans_id, @Param("author_id") int author_id);

    @Select("select * from concern2")
    public List<Concern2> getAllC();

    @Select("select * from concern2 where fans_id=#{fans_id}")
    public List<Concern2> getAllCByFansId(@Param("fans_id") int fans_id);

    @Select("select * from concern2 where author_id=#{author_id}")
    public List<Concern2> getAllCByAuthorId(@Param("author_id") int author_id);

    @Delete("delete from concern2 where fans_id=#{fans_id} and author_id=#{author_id}")
    public void deleteC(@Param("fans_id") int fans_id,@Param("author_id") int author_id);


}
