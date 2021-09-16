import java.sql.*;

public class mysql {
    public static void main(String[] args) {

        String user = "root";
       String url = "jdbc:mysql://localhost:3306/hmh_system?serverTimezone=GMT";
       String passsword = "hmh010329";;
        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            //获取数据库连接
            Connection con=DriverManager.getConnection(url,user,passsword);
            //获取SQL语句执行者
            PreparedStatement pstmt=con.prepareStatement("select * from personnel");
            //执行SQL语句
            ResultSet rs = pstmt.executeQuery();
            //处理结果集
            while (rs.next())
            {
                int EMP_NO = rs.getInt("EMP_NO");
                String EMP_NAME = rs.getString("EMP_NAME");
                int DEPT_ID = rs.getInt("DEPT_ID");
                String EMP_GENDER = rs.getString("EMP_GENDER");
                int EMP_TELENO = rs.getInt("EMP_TELENO");
                String EMP_EMAIL= rs.getString("EMP_EMAIL");
                System.out.println(EMP_NO+EMP_NAME+DEPT_ID+EMP_GENDER+EMP_TELENO+EMP_EMAIL);

            }
            //释放资源
            con.close();
            pstmt.close();
            rs.close();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

}
