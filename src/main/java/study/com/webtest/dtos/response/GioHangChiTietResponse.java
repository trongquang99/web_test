package study.com.webtest.dtos.response;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class GioHangChiTietResponse {
    private Long id;
    private String tenCh;
    private String diaChi;
    private String tenKh;
    private String sdtKh;
    private List<ChiTietSanPham> dsSp;
    private Float tongTien;
}
