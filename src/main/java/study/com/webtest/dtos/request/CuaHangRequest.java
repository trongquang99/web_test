package study.com.webtest.dtos.request;

public class CuaHangRequest {
    private String ten;
    private String diChi;
    private String sdt;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiChi() {
        return diChi;
    }

    public void setDiChi(String diChi) {
        this.diChi = diChi;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

}

