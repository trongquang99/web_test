package study.com.webtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.com.webtest.model.HoaDonCuaHang;


public interface HoaDonCuaHangRepository extends JpaRepository<HoaDonCuaHang, Long> {
    HoaDonCuaHang findByIdHd(Long idHd);

}
