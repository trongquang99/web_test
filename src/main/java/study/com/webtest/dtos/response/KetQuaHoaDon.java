package study.com.webtest.dtos.response;

import java.util.Date;

public class KetQuaHoaDon {
    private String tenKh;
    private String tenNv;
    private Float tongGia;
    private Date ngayThanhToan;

    public KetQuaHoaDon() {
    }

    public KetQuaHoaDon(String tenKh, String tenNv, Float tongGia, Date ngayThanhToan) {
        this.tenKh = tenKh;
        this.tenNv = tenNv;
        this.tongGia = tongGia;
        this.ngayThanhToan = ngayThanhToan;
    }

    public String getTenKh() {
        return tenKh;
    }

    public void setTenKh(String tenKh) {
        this.tenKh = tenKh;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public Float getTongGia() {
        return tongGia;
    }

    public void setTongGia(Float tongGia) {
        this.tongGia = tongGia;
    }

    public String getTenNv() {
        return tenNv;
    }

    public void setTenNv(String tenNv) {
        this.tenNv = tenNv;
    }
}
