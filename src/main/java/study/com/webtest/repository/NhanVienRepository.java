package study.com.webtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import study.com.webtest.model.NhanVien;
import study.com.webtest.model.SanPham;

import java.util.List;

public interface NhanVienRepository extends JpaRepository<NhanVien, Long> {
    @Query("select n from NhanVien n where n.id = :id")
    List<NhanVien> getListNhanVien (Long id);
    List<NhanVien> findBySdtAndEmail(String sdt, String email);
}
