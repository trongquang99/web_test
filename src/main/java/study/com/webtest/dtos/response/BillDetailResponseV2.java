package study.com.webtest.dtos.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BillDetailResponseV2 {
    private Long id;
    private String tenCh;
    private String diaChi;
    private String tenKh;
//    private String diaChiKh;
    private String sdtKh;
    private List<DuLieuSanPham> dsSp;
    private Float tongTien;
    private Date ngayThanhToan;
}
