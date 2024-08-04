package study.com.webtest.service;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;
import study.com.webtest.model.SanPham;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Service
public class SanPhamServiceBuilder {
    private final EntityManager entityManager;

    public SanPhamServiceBuilder(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<SanPham> getListProducts(String tenSp, String tenKh){
        StringBuilder queryBuilder = new StringBuilder("""
                select * from sanpham
                """);
        var params = new HashMap<String, Object>();
        if (Objects.nonNull(tenSp)){
            queryBuilder.append("where ten like concat('%', :tenSP, '%') ");
            params.put("tenSP", tenSp);
        }
        if (Objects.nonNull(tenKh)){
            if(params.isEmpty()){
                queryBuilder.append("where ");
            }
            else {
                queryBuilder.append("and ");
            }
            queryBuilder.append("""
                   id in (
                   select id_sp from hoadonsanpham where id_Hd in
                  (
                        select id from hoadon where id_kh in
                        (select id from khachhang where ten like concat('%', :tenKh, '%') ))
                  )
                  """);
            params.put("tenKh", tenKh);
        }
        queryBuilder.append("order by gia desc ");
        String cmd = queryBuilder.toString();
        var query = entityManager.createNativeQuery(cmd, SanPham.class);
        params.forEach(query::setParameter);
        List<SanPham> rs = (List<SanPham>) query.getResultList();
        return rs;
    }
}
