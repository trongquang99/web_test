package study.com.webtest.dtos.response;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class HoaDonChiTietResponse {
    private Long maHD;
    private List<DsSP> dsSP;
    private String tenKh;
    private Float tongSoTien;
    private Date ngayThanhToan;


    @Data
    public static  class DsSP{
        private String tenSp;
        private Integer soLuong;

    }
}
