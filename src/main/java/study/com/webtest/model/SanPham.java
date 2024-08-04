package study.com.webtest.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "sanpham")
@Data
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ten")
    private String ten;

    @Column(name = "gia")
    private Integer gia;

    @Column(name = "mo_ta")
    private String moTa;
}
