package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class MyConnection {
    // Tao ket noi den CSDL

    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "123456789";
    public static final String DB_CONNECTION_URL = "jdbc:mysql://localhost:3306/quan_ly_nhan_su_nhom6";


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_CONNECTION_URL, DB_USER, DB_PASSWORD);
    }

}

