package study.com.webtest.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "giohang")
public class GioHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_Kh")
    private Long idKh;

    @Column(name = "tong_tien")
    private float tongTien;

}
