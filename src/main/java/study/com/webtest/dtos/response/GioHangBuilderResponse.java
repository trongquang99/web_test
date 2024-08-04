package study.com.webtest.dtos.response;

import lombok.Data;

import java.util.List;

@Data
public class GioHangBuilderResponse {
    private Long id;
    private String tenKh;
    private Float tongGia;
    private List<SpChiTiet> danhSachSp;

    @Data
    public static class SpChiTiet {
        protected String ten;
        private Integer soLuong;
        private Integer gia;
    }
}

