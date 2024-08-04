package study.com.webtest.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "giohang_cuahang")
public class GioHangCuaHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_gh")
    private Long idGh;

    @Column(name = "id_ch")
    private Long idCh;

    @Column(name = "ngay_tao")
    private String ngayTao;
}
