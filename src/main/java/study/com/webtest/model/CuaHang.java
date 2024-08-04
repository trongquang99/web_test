package study.com.webtest.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cuahang")
@Data
public class CuaHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ten")
    private String ten;

    @Column(name = "dia_chi")
    private String diChi;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "email")
    private String email;

}
