package study.com.webtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import study.com.webtest.model.HoaDonSanPham;
import study.com.webtest.model.KhachHang;
import study.com.webtest.model.SanPham;

import java.util.List;
@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Long> {
    @Query("select n from SanPham n where n.gia > 10000")
    List<SanPham> getGiatSanPham ();

    @Query(value = "select * from SanPham where ten like %?1%", nativeQuery = true)
    List<SanPham> danhSachSanPham(String ten);

//    List<SanPham> findByTenContaining(String ten);
//    List<SanPham> findByIdIn(List<Long> listId);

    List<SanPham> findByTenContaining(String ten);

    List<SanPham> findByIdIn(List<Long> id);

}
