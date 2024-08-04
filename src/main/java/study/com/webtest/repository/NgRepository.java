package study.com.webtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import study.com.webtest.dtos.request.ThongTinCaNhan;
import study.com.webtest.dtos.response.KetQuaCaNhan;
import study.com.webtest.model.CuaHang;
import study.com.webtest.model.Nguoi;

import java.util.List;

@Repository
public interface NgRepository extends JpaRepository<Nguoi, Long> {
    @Query("select n from Nguoi n where n.id = :id")
    List<Nguoi> getListNguoi (Long id);
}

