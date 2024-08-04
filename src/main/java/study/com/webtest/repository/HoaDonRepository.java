package study.com.webtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import study.com.webtest.dtos.response.HoaDonChiTietResponse;
import study.com.webtest.dtos.response.KetQuaHoaDon;
import study.com.webtest.model.HoaDon;
import study.com.webtest.model.SanPham;

import java.util.List;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Long> {
    @Query("select n from HoaDon n where n.id = :id")
    List<HoaDon> getListHoaDon(Long id);

//    @Query(value = "SELECT new study.com.webtest.dtos.response.KetQuaHoaDon(kh.ten, nv.ten, hd.tong_gia, hd.ngay_thanh_toan) " +
//            "FROM HoaDon hd " +
//            "JOIN KhachHang kh ON hd.id_kh = kh.id " +
//            "JOIN NhanVien nv ON hd.id_nv = nv.id " +
//            "WHERE hd.id = :id")
//    List<KetQuaHoaDon> layHoaDon(@Param("id") Long id);


    @Query("SELECT h FROM HoaDon h WHERE tongGia >= :t")
    List<HoaDon> findByTongGiaGreaterThanEquals(@Param("t") Float a);


    @Query(value = "select count(*) from HoaDon where tong_gia > 100000", nativeQuery = true)
    Integer soLuongHoaDon();


    @Query(value = "select * from HoaDon as hd where hd.tong_gia > 100000", nativeQuery = true)
    List<HoaDon> danhSachHoaDon();


    List<HoaDon> findByIdKh(Long idKh);

//    List<HoaDon> findByIdKhIn(List<Long> idKhs);
    List<HoaDon> findByIdKhIn(List<Long> idKh);

    List<HoaDon> findByIdIn(List<Long> id);

    @Query(value = "select * from hoadon where tong_gia >= :x" , nativeQuery = true)
    List<HoaDon> danhSachHoaDonTheoGia(@Param("x") Float tong_gia);

    List<HoaDon> findByTongGiaGreaterThanEqual(Float gia);
}
