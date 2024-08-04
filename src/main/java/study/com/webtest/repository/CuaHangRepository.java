package study.com.webtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import study.com.webtest.model.CuaHang;

import java.util.List;

@Repository
public interface CuaHangRepository extends JpaRepository<CuaHang, Long> {
    CuaHang findByTenAndEmail(String ten, String email);
    CuaHang findFirstById(Long id);

}

