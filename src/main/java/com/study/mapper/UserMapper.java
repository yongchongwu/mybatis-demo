package com.study.mapper;

import com.study.model.User;
import java.util.List;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

  public int add(User user);

  public int update(User user);

  public void delete(Integer id);

  public User findById(Integer id);

  public List<User> findAll();

  @Select("SELECT a.*,b.id as blog_id,b.user_id,b.blog_name,b.remark FROM t_user a,t_blog b WHERE b.user_id=a.user_id and a.user_name=#{name}")
  @ResultMap("userResultMap")
  public List<User> findByName(String name);


  @Select("SELECT a.*,b.id as blog_id,b.user_id,b.blog_name,b.remark FROM t_user a,t_blog b WHERE b.user_id=a.user_id and b.blog_name=#{blogName}")
  @Results(id = "userBlogResultMap", value = {
      @Result(property = "id", column = "user_id", id = true),
      @Result(property = "name", column = "user_name"),
      @Result(property = "password", column = "user_password"),
      @Result(property = "email", column = "user_email"),
      @Result(property = "phone", column = "user_phone"),
      @Result(property = "address", column = "user_address")
  })
  public List<User> findByBlogName(String blogName);

}
