package study.com.webtest.dtos.response;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class DanhSachHoaDon {
    private Long id;
    private Date ngayThanhToan;
    private Float tongTien;
    private List<DanhSachSanPham> dsSp;

    @Data
    public static class DanhSachSanPham {
        private String ten;
        private Integer gia;
        private Integer soLuong;
    }
}
