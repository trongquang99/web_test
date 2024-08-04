package study.com.webtest.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "hoadonsanpham")
@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class HoaDonSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_Hd")
    private Long idHd;

    @Column(name = "id_Sp")
    private Long idSp;

    @Column(name = "so_luong")
    private Integer soLuong;

}
