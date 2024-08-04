package study.com.webtest.dtos.response;

import lombok.Data;

import java.util.List;

@Data
public class CustomerDetailResponse {
    private Long id;
    private String name;
    private String phone;
    private String email;
    private List<DanhSachHoaDon> dsHd;
    private List<DanhSachGioHang> dsGh;
}
