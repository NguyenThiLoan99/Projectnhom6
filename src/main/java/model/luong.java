package model;

public class luong {
    private long BacLuong;
    private double LuongCB;
    private double PhuCap;

    public luong() {
    }

    public luong(long bacLuong, double luongCB, double phuCap) {
        BacLuong = bacLuong;
        LuongCB = luongCB;
        PhuCap = phuCap;
    }

    public long getBacLuong() {
        return BacLuong;
    }

    public void setBacLuong(long bacLuong) {
        BacLuong = bacLuong;
    }

    public double getLuongCB() {
        return LuongCB;
    }

    public void setLuongCB(double luongCB) {
        LuongCB = luongCB;
    }

    public double getPhuCap() {
        return PhuCap;
    }

    public void setPhuCap(double phuCap) {
        PhuCap = phuCap;
    }

    @Override
    public String toString() {
        return "luong{" +
                "BacLuong=" + BacLuong +
                ", LuongCB=" + LuongCB +
                ", PhuCap=" + PhuCap +
                '}';
    }
}
