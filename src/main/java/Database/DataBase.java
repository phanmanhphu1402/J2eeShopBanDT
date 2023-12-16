package Database;

import java.sql.*;

public class DataBase {

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=DoAnJ2EE;encrypt=false";
            String username = "sa";
            String password = "123456aA@$";
            conn = DriverManager.getConnection(dbUrl, username, password);
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage()); // In thông báo lên console
            e.printStackTrace(); // In stack trace lên console để xem chi tiết lỗi
        }
        return conn;
    }

    public static void closeConnection(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
