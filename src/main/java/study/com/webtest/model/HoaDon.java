package study.com.webtest.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name = "hoadon")
@Data
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_kh")
    private Long idKh;

    @Column(name = "id_Nv")
    private Long id_nv;

    @Column(name = "ngay_thanh_toan")
    private Date ngay_thanh_toan;

    @Column(name = "tong_gia")
    private Float tongGia;

}
