package dao;
import connection.MyConnection;
import model.nhanvien;
import model.phongban;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
                p.setSdtPB(rs.getString("SdtPB"));
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

    public static phongban getById(String MaPB){
        final String sql = String.format("select * from `phongban` where MaPB = '%s'", MaPB);
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
                p.setSdtPB(rs.getString("SdtPB"));
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

    public static void insert(phongban p){
        final String sql= String.format("insert into `phongban` values ('%s','%s','%s','%s')",
                p.getMaPB(), p.getTenPB(), p.getDiachiPB(), p.getSdtPB());
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


    public static void update(phongban p, String MaPB){
        phongban tmpPB = getById(MaPB);
        if( p == null){
            throw new RuntimeException("phòng ban không tồn tại!");
        }
        final String sql = String.format(
                "update `phongban` set `MaPB`='%s',`TenPB`='%s',`DiachiPB`='%s',`SdtPB`=%s  WHERE `MaPB` = '%s'",
                p.getMaPB(), p.getTenPB(), p.getDiachiPB(), p.getSdtPB(),MaPB
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
    public void removeEmployeeByDeptID() {
        String sql = "DELETE from phongban WHERE id = ?";
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);


            if (rs == 0) {
                System.out.println("Xóa thất bại");
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void delete(String id)
    {
        phongban d = getById(id);
        if (d == null) {
            System.out.println("loi");
            throw new RuntimeException("id không tồn tại!");

        }

        final String sql =
                "SELECT count(*) as checksl FROM nhanvien where MaPB=?";
        try{
            Connection conn = MyConnection.getConnection();
            PreparedStatement st = (PreparedStatement) conn
                    .prepareStatement(sql);
            st.setString(1,id);

            ResultSet rs = st.executeQuery();
            int checknv=0;
            if (rs.next()) {
                checknv= rs.getInt("checksl");

            }
            if(checknv>0)
            {
                System.out.println("còn tồn tại nhân viên trong phòng ban \n yêu cầu chuyển nhân viên qua phòng ban khác rồi mới đc xóa");
            }else if(checknv==0)
            {
                String sql1= "delete from phongban where MaPB=?";
                try{
                    PreparedStatement st1 = (PreparedStatement) conn
                            .prepareStatement(sql1);
                    st1.setString(1,id);
                    long rs1 = st1.executeUpdate();

                    if (rs1 == 0) {
                        System.out.println("Cập nhật thất bại");
                    }
                    st.close();
                    conn.close();
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }



    }




