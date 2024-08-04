package study.com.webtest.dtos.response;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class BillDetailResponse {
    protected Long idHd;
    private String tenCh;
    private String tenKh;
    private String diaChi;
    private Float tongThanhToan;
    private Date ngayThanhToan;
    private List<SpChiTiet> danhSachSp;

    @Data
    public static class SpChiTiet {
        protected String ten;
        private Long soLuong;
        private Integer gia;
    }
}
