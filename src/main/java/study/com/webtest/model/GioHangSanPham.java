package study.com.webtest.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "giohang_sanpham")
public class GioHangSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_gh")
    private Long idGh;

    @Column(name = "id_sp")
    private Long idSp;

    @Column(name = "so_luong")
    private Integer soLuong;

    @Column(name = "ngay_tao")
    private String ngayTao;
}
