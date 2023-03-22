package dao;

public class luongDAO {
    private int BacLuong;
    private float LuongCB;
    private float PhuCap;

    public luongDAO() {
    }

    public luongDAO(int bacLuong, float luongCB, float phuCap) {
        BacLuong = bacLuong;
        LuongCB = luongCB;
        PhuCap = phuCap;
    }

    public int getBacLuong() {
        return BacLuong;
    }

    public void setBacLuong(int bacLuong) {
        BacLuong = bacLuong;
    }

    public float getLuongCB() {
        return LuongCB;
    }

    public void setLuongCB(float luongCB) {
        LuongCB = luongCB;
    }

    public float getPhuCap() {
        return PhuCap;
    }

    public void setPhuCap(float phuCap) {
        PhuCap = phuCap;
    }



    @Override
    public String toString() {
        return "luongDAO{" +
                "BacLuong=" + BacLuong +
                ", LuongCB=" + LuongCB +
                ", PhuCap=" + PhuCap +
                '}';
    }
}
