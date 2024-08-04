package study.com.webtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import study.com.webtest.model.HoaDon;
import study.com.webtest.model.KhachHang;
import study.com.webtest.model.NhanVien;

import java.util.List;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, Long> {
   @Query("select n from KhachHang n where n.sdt = :sdt")
   List<KhachHang> getListSdtKhachHang(String sdt);
//   List<KhachHang> findBySdtContaining(String sdt);

   @Query(value = "select * from KhachHang where ten like %?1%", nativeQuery = true)
   List<KhachHang> danhSachKhachHang(String ten);

//   List<KhachHang> findByTenContaining(String ten);
   List<KhachHang> findByTenContaining(String ten);
}

