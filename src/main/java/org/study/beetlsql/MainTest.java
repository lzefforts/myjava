package org.study.beetlsql;

import org.beetl.sql.core.*;
import org.beetl.sql.core.db.DBStyle;
import org.beetl.sql.core.db.MySqlStyle;
import org.beetl.sql.ext.DebugInterceptor;

import java.util.List;

/**
 * Created by ArnoldLee on 17/1/23.
 */
public class MainTest {

    private static String driver = "com.mysql.jdbc.Driver";

    private static String url = "jdbc:mysql://127.0.0.1:3306/blackduck";

    private static String userName = "root";

    private static String password = "1111111a";


    public static void main(String[] args) {
        ConnectionSource source = ConnectionSourceHelper.getSimple(driver,url,userName, password);
        DBStyle mysql = new MySqlStyle();
        // sql语句放在classpagth的/sql 目录下
        SQLLoader loader = new ClasspathLoader("/sql");
        // 数据库命名跟java命名一样，所以采用DefaultNameConversion，还有一个是UnderlinedNameConversion，下划线风格的
        //所以采用
        DefaultNameConversion nc = new DefaultNameConversion();
        // 最后，创建一个SQLManager,DebugInterceptor 不是必须的，但可以通过它查看sql执行情况
        SQLManager sqlManager = new SQLManager(mysql,loader,source,nc,new Interceptor[]{new DebugInterceptor()});

//        //使用内置的生成的sql 新增用户，如果需要获取主键，可以传入KeyHolder
//        User user = new User();
//        user.setAge(19);
//        user.setName("xiandafu");
//        sqlManager.insert(user);

        //使用内置sql查询用户
        int id = 1;
        User user = sqlManager.unique(User.class,id);

        //模板更新,仅仅根据id更新值不为null的列
        User newUser = new User();
        newUser.setId(1);
        newUser.setAge(20);
        sqlManager.updateTemplateById(newUser);

        //模板查询
        User query = new User();
        query.setName("xiandafu");
        List<User> list = sqlManager.template(query);


        //使用user.md 文件里的select语句，参考下一节。
        User query2 = new User();
        query.setName("xiandafu");
        List<User> list2 = sqlManager.select("user.select",User.class,query2);

        for(User user1 : list2){
            System.out.println(user1.getName());
        }
    }
}
