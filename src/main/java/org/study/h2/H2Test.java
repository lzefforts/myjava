package org.study.h2;

import org.study.thread.ThreadPool;

import java.sql.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * h2数据库连接测试
 * @author ArnoldLee
 * @date 2019/5/4
 */
public class H2Test {

    private static AtomicInteger beginSize = new AtomicInteger(1);


    public static void main(String[] args) throws Exception {
        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.
                getConnection("jdbc:h2:/Users/ArnoldLee/source-code/h2/database/test", "sa", "");

//        dropTable(conn);
//        createTable(conn);
        batchInsert(conn);
//        queryCount(conn);

        conn.close();
    }


    public static void dropTable(Connection conn) throws SQLException {
        String sql = "drop table person";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.execute();
    }

    public static void createTable(Connection conn) throws SQLException {
        String sql = "create table person(id bigint(20) not null AUTO_INCREMENT,name varchar(20),age int(8),school varchar(50),PRIMARY KEY(id))";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.execute();
    }

    public static void batchInsert(Connection conn) throws Exception {
        String sql = "insert into person (name,age,school) values (?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);

        CountDownLatch countDownLatch = new CountDownLatch(10);
        long beginTime = System.currentTimeMillis();

        for(;beginSize.get()<=10;beginSize.incrementAndGet()){
            ThreadPool.getInstance().getThreadPoolExecutor().execute(new BatchInsertRun(countDownLatch,stmt,beginSize));
        }

        countDownLatch.await();
        long endTime = System.currentTimeMillis();
        System.out.println("finished!cost time is "+(endTime-beginTime));
    }

    public static void queryCount(Connection conn) throws SQLException {
        String sql = "SELECT count(1) FROM person ";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()) {
            System.out.println("total count:"+rs.getInt(1));
        }
    }


    public static class BatchInsertRun implements Runnable{

        private CountDownLatch countDownLatch;
        private PreparedStatement stmt;
        private AtomicInteger begin;

        public BatchInsertRun(CountDownLatch countDownLatch, PreparedStatement stmt, AtomicInteger begin) {
            this.countDownLatch = countDownLatch;
            this.stmt = stmt;
            this.begin = begin;
        }

        @Override
        public void run() {
            int batchSize = 5000;
            int beginRowNum = (begin.get()-1)*batchSize;
            int endRowNum = begin.get()*batchSize;

            for(int i=beginRowNum;i<endRowNum;i++){
                try {

//                    stmt.setLong(1,Long.valueOf(i+100));
//                    stmt.setString(2,"张三"+i);
//                    stmt.setInt(3,28);
//                    stmt.setString(4,"北京市朝阳区电子IT产业园"+(i+1)+"号楼");

                    stmt.setString(1,"张三"+i);
                    stmt.setInt(2,28);
                    stmt.setString(3,"北京市朝阳区电子IT产业园"+(i+1)+"号楼");

                    stmt.execute();
                    System.out.println("single row executed!");
                    countDownLatch.countDown();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
