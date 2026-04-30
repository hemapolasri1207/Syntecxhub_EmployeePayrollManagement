import java.sql.*;

public class DBConnection1 {
    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/payroll_db",
            "root",
            "root123"
        );
    }
}