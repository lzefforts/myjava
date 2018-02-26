package org.study.mysql;

/**
 * Created by ArnoldLee on 17/12/6.
 */
public class MysqlTest {

    public static void main(String[] args) {
        String sql = "insert into user(name,age) values (?,?)";
        MysqlConnection mysqlConnection = new MysqlConnection(sql);

    }
}
