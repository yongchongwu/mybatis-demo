package com.study.util;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBUtil {

  private final static String CONFIG_FILE="mybatis-config.xml";

  private static SqlSessionFactory sqlSessionFactory;

  public static SqlSessionFactory getSqlSessionFactory()  {
    if (sqlSessionFactory == null ) {
      InputStream inputStream = null;
      try {
        inputStream = Resources.getResourceAsStream(CONFIG_FILE);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
      } catch (IOException e) {
        throw new RuntimeException(e.getMessage(), e);
      }
    }
    return sqlSessionFactory;
  }

  public static SqlSession openSqlSession() {
    return getSqlSessionFactory().openSession();
  }

}
