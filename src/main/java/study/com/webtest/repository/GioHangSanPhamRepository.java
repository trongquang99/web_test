package study.com.webtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.com.webtest.model.GioHangSanPham;

import java.util.List;

@Repository
public interface GioHangSanPhamRepository extends JpaRepository<GioHangSanPham, Long> {

    List<GioHangSanPham> findByIdGh(Long idGh);
}
