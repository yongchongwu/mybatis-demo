package com.study;

import com.study.mapper.UserMapper;
import com.study.model.User;
import com.study.util.DBUtil;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

public class App {

  public static void main(String[] args) {
    SqlSession session = DBUtil.openSqlSession();
    try {

      UserMapper userMapper = session.getMapper(UserMapper.class);

      //增加
      /*User user = new User();
      user.setName("张三");
      user.setEmail("zhangsan@demo.com");
      user.setPassword("123456");
      user.setPhone("12345678911");
      user.setAddress("贵州贵阳");
      int result=userMapper.add(user);
      session.commit();
      if(result>0) {
        System.out.println("增加成功, result:" + result);
        System.out.println(user);
      }*/

      //查看与修改
      /*User user = userMapper.findById(1);
      System.out.println(user);
      user.setName("张三");
      int result=userMapper.update(user);
      session.commit();
      if(result>0) {
        System.out.println("修改成功, result:" + result);
        System.out.println(user);
      }*/

      //删除
      /*userMapper.delete(1);
      session.commit();
      System.out.println("删除成功");*/

      //返回所有
      /*List<User> userList = userMapper.findAll();
      for (User user:userList){
        System.out.println(user);
      }*/
      //查找1
      /*List<User> userList = userMapper.findByName("张三");
      for (User user:userList){
        System.out.println(user);
      }*/
      //查找2
      List<User> userList = userMapper.findByBlogName("人民的名义");
      for (User user:userList){
        System.out.println(user);
      }

    } finally {
      session.close();
    }
  }
}
