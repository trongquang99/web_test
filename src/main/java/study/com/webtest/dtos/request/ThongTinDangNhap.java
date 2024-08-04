package study.com.webtest.dtos.request;

import lombok.Data;

public class ThongTinDangNhap {
    private String ten;
    private String matKhau;

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
}
