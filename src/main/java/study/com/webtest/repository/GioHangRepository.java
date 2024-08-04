package study.com.webtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import study.com.webtest.model.GioHang;

import java.util.List;


@Repository
public interface GioHangRepository extends JpaRepository<GioHang, Long> {
    @Query(value = "SELECT gh.* FROM giohang gh " +
            "JOIN giohang_sanpham ghsp ON gh.id = ghsp.id_gh " +
            "GROUP BY gh.id " +
            "HAVING COUNT(ghsp.id_sp) >= 5", nativeQuery = true)
    List<GioHang> danhSachGioHang();

    List<GioHang> findByIdKh (Long idKh);
}
