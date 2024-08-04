package study.com.webtest.model;

import lombok.Data;

public class HocSinh {
    private String ten;
    private Integer tuoi;
    private String diaChi;
    private String queQuan;
    private String std;

    public HocSinh(String ten, Integer tuoi, String diaChi, String queQuan, String std) {
        this.ten = ten;
        this.tuoi = tuoi;
        this.diaChi = diaChi;
        this.queQuan = queQuan;
        this.std = std;
    }

    public HocSinh() {

    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Integer getTuoi() {
        return tuoi;
    }

    public void setTuoi(Integer tuoi) {
        this.tuoi = tuoi;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getStd() {
        return std;
    }

    public void setStd(String std) {
        this.std = std;
    }
}
