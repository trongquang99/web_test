package study.com.webtest.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "khachhang")
@Data
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ten")
    private String ten;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "email")
    private String email;
}
