package org.study.poi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by ArnoldLee on 2019/5/4.
 */
public class BatchExportTest {



    public static void main(String[] args) {

    }


    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.
                getConnection("jdbc:h2:/Users/ArnoldLee/source-code/h2/database/test", "sa", "");
        return conn;
    }




}
