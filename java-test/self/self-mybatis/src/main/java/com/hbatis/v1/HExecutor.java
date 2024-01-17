package com.hbatis.v1;

import com.hbatis.v1.mapper.Blog;

import java.sql.*;

public class HExecutor {


  public <T> T query(String sql,Object paramater){

    Connection connection=null;
    Statement statement=null;
    Blog blog = new Blog();

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/manage_public", "manage", "manage");
      statement = connection.createStatement();
      String format = String.format(sql, paramater);
      System.out.println(format+"|");
      ResultSet rs = statement.executeQuery(format);

      while(rs.next()){
        Integer bid = rs.getInt("bid");
        String name = rs.getString("name");
        Integer authorId = rs.getInt("author_id");
        blog.setAuthorId(authorId);
        blog.setBid(bid);
        blog.setName(name);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }finally {
      try {
        if (statement != null) statement.close();
      } catch (SQLException se2) {
      }
      try {
        if (connection != null) connection.close();
      } catch (SQLException se) {
        se.printStackTrace();
      }
    }

    System.out.println(blog);
    return (T)blog;
  }

}
