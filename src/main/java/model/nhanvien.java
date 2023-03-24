package model;

public class nhanvien {
    private String MaNV;
    private String HoTen;
    private String Email;
    private String Ngayvaolam;
    private String NgaySinh;
    private String Sdt;
    private String Chucvu;
    private int LuongCV;

    private String MaPB;
    private String NguoiQL;
    private int BacLuong;

    public nhanvien() {
    }

    public nhanvien(String maNV, String hoTen, String email, String ngayvaolam, String ngaySinh, String sdt, String chucvu, int luongCV, String maPB, String nguoiQL, int bacLuong) {
        MaNV = maNV;
        HoTen = hoTen;
        Email = email;
        Ngayvaolam = ngayvaolam;
        NgaySinh = ngaySinh;
        Sdt = sdt;
        Chucvu = chucvu;
        LuongCV = luongCV;
        MaPB = maPB;
        NguoiQL = nguoiQL;
        BacLuong = bacLuong;
    }

    public nhanvien(String hoTen, String email, String ngayvaolam, String ngaySinh, String sdt, String chucvu, int luongCV, String maPB, String nguoiQL, int bacLuong) {
        HoTen = hoTen;
        Email = email;
        Ngayvaolam = ngayvaolam;
        NgaySinh = ngaySinh;
        Sdt = sdt;
        Chucvu = chucvu;
        LuongCV = luongCV;
        MaPB = maPB;
        NguoiQL = nguoiQL;
        BacLuong = bacLuong;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String maNV) {
        MaNV = maNV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getNgayvaolam() {
        return Ngayvaolam;
    }

    public void setNgayvaolam(String ngayvaolam) {
        Ngayvaolam = ngayvaolam;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String sdt) {
        Sdt = sdt;
    }

    public String getChucvu() {
        return Chucvu;
    }

    public void setChucvu(String chucvu) {
        Chucvu = chucvu;
    }

    public int getLuongCV() {
        return LuongCV;
    }

    public void setLuongCV(int luongCV) {
        LuongCV = luongCV;
    }

    public String getMaPB() {
        return MaPB;
    }

    public void setMaPB(String maPB) {
        MaPB = maPB;
    }

    public String getNguoiQL() {
        return NguoiQL;
    }

    public void setNguoiQL(String nguoiQL) {
        NguoiQL = nguoiQL;
    }

    public int getBacLuong() {
        return BacLuong;
    }

    public void setBacLuong(int bacLuong) {
        BacLuong = bacLuong;
    }

    @Override
    public String toString() {
        return "nhanvien [  " +
                "MaNV='" + MaNV + '\'' +
                ", HoTen ='" + HoTen + '\'' +
                ", Email ='" + Email + '\'' +
                ", Ngayvaolam ='" + Ngayvaolam + '\'' +
                ", NgaySinh ='" + NgaySinh + '\'' +
                ", Sdt ='" + Sdt + '\'' +
                ", Chucvu ='" + Chucvu + '\'' +
                ", LuongCV =" + LuongCV +
                ", MaPB ='" + MaPB + '\'' +
                ", NguoiQL ='" + NguoiQL + '\'' +
                ", BacLuong =" + BacLuong +
                ']';
    }
}
