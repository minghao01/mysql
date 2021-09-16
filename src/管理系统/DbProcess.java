package 管理系统;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DbProcess{
    static Connection connection = null;
    static ResultSet rs=null ;

    //static ResultSet rw = null;

    //mysql数据库url

    //sqlserver数据库url
    //String urlSqlServer = "jdbc:sqlserver://localhost:1433;integratedSecurity=true;DatabaseName=InfoDb";

    public DbProcess() {
        try {
            //mysql数据库设置驱动程序类型
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("mysql数据库驱动加载成功");

            //sqlserver数据库设置驱动程序类型
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //System.out.println("sqlserver数据库驱动加载成功");

        }
        catch(java.lang.ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void connect(){
        String user = "root";
        String url = "jdbc:mysql://localhost:3306/hmh_system?serverTimezone=GMT";
        String passsword = "hmh010329";;
        try{
            //mysql数据库
            connection = DriverManager.getConnection(url,user,passsword);

            //sqlserver数据库
            //connection = DriverManager.getConnection(urlSqlServer);


            if(connection!=null){
                System.out.println("数据库连接成功");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void disconnect(){
        try{

            if(connection != null){
                connection.close();
                connection = null;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }



    public static  ResultSet executeQuery(String sql) {

        try {
            System.out.println("executeQuery(). sql = " + sql);

            PreparedStatement pstm = connection.prepareStatement(sql); //PreparedStatement:用于执行sql语句的对象
            //用connection的PreparedStatement(sql)方法获取

            rs = pstm.executeQuery();

            //	ResultSet rw=rs;
            //while(rs.next()){
            //System.out.println(rs.getString("pNo"));
            //	}
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }

        return rs;
    }



    //插入
    //executeUpdate 的返回值是一个整数，指示受影响的行数（即更新计数）。
    //executeUpdate用于执行 INSERT、UPDATE 或 DELETE 语句
    //以及 SQL DDL（数据定义语言）语句，例如 CREATE TABLE 和 DROP TABLE。

    //执行增、删、改语句的方法
    public static int executeUpdate(String sql) {
        int count = 0;
        connect();
        try {
            Statement stmt = connection.createStatement();
            count = stmt.executeUpdate(sql);
        }
        catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
        disconnect();
        return count;
    }
}
