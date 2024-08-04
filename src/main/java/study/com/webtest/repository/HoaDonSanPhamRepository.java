package study.com.webtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import study.com.webtest.model.HoaDonSanPham;

import java.util.List;

public interface HoaDonSanPhamRepository extends JpaRepository<HoaDonSanPham, Long> {
    @Query("select n from HoaDonSanPham n where n.id = :id")
    List<HoaDonSanPham> getListHoaDonSanPham (Long id);

    List<HoaDonSanPham> findByIdHd(Long idHd);

//    List<HoaDonSanPham> findByIdHdIn(List<Long> idHds);

    List<HoaDonSanPham> findByIdHdIn(List<Long> idHd);

    List<HoaDonSanPham> findByIdSpIn(List<Long> idSp);


}




