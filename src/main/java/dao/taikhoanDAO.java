package dao;

import connection.MyConnection;
import model.taikhoan;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class taikhoanDAO {
    public boolean checktaikhoan ( String username, String password) {
        String sql = String.format("select * from `taikhoan` where username= '%s' and password = '%s'", username, password);
        try{
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);


            if(rs.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
