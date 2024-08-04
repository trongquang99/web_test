package study.com.webtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.com.webtest.model.GioHangCuaHang;
import study.com.webtest.model.HoaDonCuaHang;

@Repository
public interface GioHangCuaHangRepository extends JpaRepository<GioHangCuaHang, Long> {

    GioHangCuaHang findByIdGh(Long idGh);
}
