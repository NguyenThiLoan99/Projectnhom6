package model;

public class phongban {
    private String MaPB ;
    private String TenPB;
    private String DiachiPB;
    private String SdtPB;

    public phongban() {
    }

    public phongban(String maPB, String tenPB, String diachiPB, String sdtPB) {
        MaPB = maPB;
        TenPB = tenPB;
        DiachiPB = diachiPB;
        SdtPB = sdtPB;
    }

    public String getMaPB() {
        return MaPB;
    }

    public void setMaPB(String maPB) {
        MaPB = maPB;
    }

    public String getTenPB() {
        return TenPB;
    }

    public void setTenPB(String tenPB) {
        TenPB = tenPB;
    }

    public String getDiachiPB() {
        return DiachiPB;
    }

    public void setDiachiPB(String diachiPB) {
        DiachiPB = diachiPB;
    }

    public String getSdtPB() {
        return SdtPB;
    }

    public void setSdtPB(String sdtPB) {
        SdtPB = sdtPB;
    }

    @Override
    public String toString() {
        return "phongban{" +
                "MaPB='" + MaPB + '\'' +
                ", TenPB='" + TenPB + '\'' +
                ", DiachiPB='" + DiachiPB + '\'' +
                ", SdtPB='" + SdtPB + '\'' +
                '}';
    }
}
