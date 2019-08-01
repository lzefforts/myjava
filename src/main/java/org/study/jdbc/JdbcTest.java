package org.study.jdbc;

import java.sql.*;

/**
 * Created by ArnoldLee on 2019/3/19.
 */
public class JdbcTest {

    public static void main(String[] args) throws SQLException {
        String url = System.getProperty("jdbc.drivers");
        System.out.printf("\nurl:%s",url);

        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");


            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/myshool?characterEncoding=utf-8&useSSL=false&serverTimezone=Hongkong","root","root");
            String sql="select * from student where name= ? ";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,"小明");
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getString("id")+" " +resultSet.getString("name"));
            }
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
