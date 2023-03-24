package dao;

import connection.MyConnection;
import model.nhanvien;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.Statement;

public class luongDAO {
    final double phanTramThue = 0.15d;
    long tienLuongNhan;
    double tienLuongThucTe, thueThuNhap;
    /*Scanner in = new Scanner(System.in);
     //tính thuế thu nhập = 15% lương được nhận
    thueThuNhap = tienLuongNhan * 0.15;

    //tiền lương thực tế sau khi đóng thuế = tiền lương nhận - thuế thu nhập
    tienLuongThucTe = tienLuongNhan - thueThuNhap;

    public static int luongDuocNhan(nhanvien nv){
        nhanvien nv = get;
        if(nv == null){
            throw new RuntimeException("Nhân viên không tồn tại!");
        }
        final String sql = String.format( "delete from `nhanvien` where `MaNV` = '%s'", MaNV);
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Xoá thất bại");
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

}
