package study.com.webtest.dtos.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DuLieuSanPham {
    private Long id;
    private String ten;
    private Integer soLuong;
    private Integer gia;
}
