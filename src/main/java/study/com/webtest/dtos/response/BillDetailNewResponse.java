package study.com.webtest.dtos.response;

import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
public class BillDetailNewResponse {
    private Long idGh;
    private String tenKh;
    private String sdtKh;
    private Float tongTien;
    private Long idHD;
    private Date ngayThanhToan;
    private List<SpChiTiet> danhSachSp;

    @Data
    public static class SpChiTiet {
        protected String ten;
        private Integer soLuong;
        private Integer gia;
    }
}
