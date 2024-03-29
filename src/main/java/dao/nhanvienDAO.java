package dao;

import connection.MyConnection;
import model.nhanvien;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class nhanvienDAO {
    public static List<nhanvien> getAll() {
        final String sql = "select * from`nhanvien`";
        List<nhanvien> nhanvienList = new ArrayList<>();

        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                nhanvien nv = new nhanvien();
                nv.setMaNV(rs.getString("MaNV"));
                nv.setHoTen(rs.getString("HoTen"));
                nv.setEmail(rs.getString("Email"));
                nv.setNgayvaolam(rs.getString("Ngayvaolam"));
                nv.setNgaySinh(rs.getString("NgaySinh"));
                nv.setSdt(rs.getString("Sdt"));
                nv.setChucvu(rs.getString("Chucvu"));
                nv.setLuongCV(rs.getInt("LuongCV"));
                nv.setMaPB(rs.getString("MaPB"));
                nv.setNguoiQL(rs.getString("NguoiQL"));
                nv.setBacLuong(rs.getInt("BacLuong"));
                nhanvienList.add(nv);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nhanvienList;
    }

    public static nhanvien getById(String MaNV) {
        final String sql = String.format("select * from `nhanvien` where MaNV = '%s'", MaNV);
        nhanvien nv = null;
        try{
        Connection conn = MyConnection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        if (rs.next()) {
            nv = new nhanvien();
            nv.setMaNV(rs.getString("MaNV"));
            nv.setHoTen(rs.getString("HoTen"));
            nv.setEmail(rs.getString("Email"));
            nv.setNgayvaolam(rs.getString("Ngayvaolam"));
            nv.setNgaySinh(rs.getString("NgaySinh"));
            nv.setSdt(rs.getString("Sdt"));
            nv.setChucvu(rs.getString("Chucvu"));
            nv.setLuongCV(rs.getInt("LuongCV"));
            nv.setMaPB(rs.getString("MaPB"));
            nv.setNguoiQL(rs.getString("NguoiQL"));
            nv.setBacLuong(rs.getInt("BacLuong"));
        }
        rs.close();
        stmt.close();
        conn.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
        return nv;
    }

    public static void insert(nhanvien nv){
        final String sql = String.format("insert into `nhanvien` values ('%s','%s','%s','%s','%s','%s','%s','%d','%s','%s','%d')",
                nv.getMaNV(), nv.getHoTen(), nv.getEmail(), nv.getNgayvaolam(), nv.getNgaySinh(), nv.getSdt(),nv.getChucvu(),nv.getLuongCV(),nv.getMaPB(),nv.getNguoiQL(),nv.getBacLuong()
        );
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Thêm thất bại");
            }

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void update(nhanvien nv, String ma){
        nhanvien tmp = getById(ma);
        if(tmp == null){
            System.out.println("Không tồn tại nhân viên có ma =" + ma);
            return;
        }

        final String sql = String.format("update`nhanvien` set `HoTen`='%s',`Email`='%s',`Ngayvaolam`='%s',`Sdt`='%s',`Chucvu`='%s',`LuongCV`='%d',`MaPB`='%s',`NguoiQL`='%s',`BacLuong`='%d' where `MaNV`='%s'",
                 nv.getHoTen(),nv.getEmail(),nv.getNgayvaolam(), nv.getSdt(),nv.getChucvu(),nv.getLuongCV(),nv.getMaPB(),nv.getNguoiQL(),nv.getBacLuong(),ma
        );
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Cập nhật thất bại");
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        }

        public static void delete(String MaNV){
        nhanvien nv = getById(MaNV);
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
        }

}
