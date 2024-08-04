package study.com.webtest.dtos.response;

import lombok.Data;

import java.util.List;

@Data
public class DanhSachGioHang {
    private Long id;
    private Float tongTien;
    List<SanPhamChiTiet> spCt;

    @Data
    public static class SanPhamChiTiet{
       private String ten;
       private Integer gia;
       private Integer soLuong;
    }
}
