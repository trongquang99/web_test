package study.com.webtest.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Table(name = "hoadon_cuahang")
@Entity
public class HoaDonCuaHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_hd")
    private Long idHd;

    @Column(name = "id_ch")
    private Long idCh;

    @Column(name = "ngay_tao")
    private Date ngayTao;
}
