package dao;
import connection.MyConnection;
import model.nhanvien;
import model.phongban;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.List;

public class phongbanDAO {
    public static List<phongban> getAll(){
        final String sql = "select * from `phongban`";

        List<phongban> phongbanList = new ArrayList<>();

        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                phongban p = new phongban();
                p.setMaPB(rs.getString("MaPB"));
                p.setTenPB(rs.getString("TenPB"));
                p.setDiachiPB(rs.getString("DiachiPB"));
                phongbanList.add(p);
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return phongbanList;
    }

    public phongban getById( String MaPB){
        final String sql = "select * from `phongban` where `MaPB`=" + MaPB;
        phongban p = null;

        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                p = new phongban();
                p.setMaPB(rs.getString("MaPB"));
                p.setTenPB(rs.getString("TenPB"));
                p.setDiachiPB(rs.getString("DiachiPB"));
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return p;
    }

    public List<nhanvien> getAllnhanvienByphongban (String MaPB){
        phongban p = getById(MaPB);
        if( p == null){
            throw new RuntimeException("Phòng ban không tồn tại!");
        }
        //SQL
        final String sql= "select * from `nhanvien` where `MaPB` = " + MaPB;

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
                nv.setLuongCV(rs.getFloat("LuongCV"));
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

    public void insert (phongban phongban){
        final String sql= String.format("insert into `phongban` values (`%s`,`%s`,`%s`,`%s`)",
                phongban.getMaPB(), phongban.getTenPB(), phongban.getDiachiPB(), phongban.getSdtPB());
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

    public void update(phongban phongban, String MaPB){
        phongban p = getById(MaPB);
        if( p == null){
            throw new RuntimeException("phòng ban không tồn tại!");
        }
        final String sql = String.format(
                "update `phongban` set `MaPB`=`%s`,`TenPB`=`%s`,`DiachiPB`=`%s`,`SdtPB`=`%s`  WHERE `MaPB` = '%s'",
                phongban.getMaPB(), phongban.getTenPB(), phongban.getDiachiPB(), phongban.getSdtPB(),MaPB
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

    }



