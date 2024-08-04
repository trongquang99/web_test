package study.com.webtest.service;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;
import study.com.webtest.model.HoaDon;
import study.com.webtest.repository.HoaDonRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Service
public class HoaDonServiceBuilder {
    private final EntityManager entityManager;
    private final HoaDonRepository hoaDonRepository;

    public HoaDonServiceBuilder(EntityManager entityManager, HoaDonRepository hoaDonRepository) {
        this.entityManager = entityManager;
        this.hoaDonRepository = hoaDonRepository;
    }

    public List<HoaDon> getListBills(String tenSp, String tenKh, Float gia){
        StringBuilder queryBuilder = new StringBuilder("""
                select * from hoadon 
                """);
        var params = new HashMap<String, Object>();
        if (Objects.nonNull(tenSp)){
            queryBuilder.append("""
                   where id in (
                   select id_Hd from hoadonsanpham where id_Sp in(
                          select id from sanpham where ten like concat('%', :tenSp, '%') ))
                   """);
            params.put("tenSp", tenSp);
        }
        if(Objects.nonNull(tenKh)){
            if(params.isEmpty()){
                queryBuilder.append("where ");
            }
            else {
                queryBuilder.append("and ");
            }
            queryBuilder.append("""
                    id_Kh in (
                    select id from khachhang where ten like concat('%', :tenKh, '%') )
                    """);
            params.put("tenKh", tenKh);
        }
        if(Objects.nonNull(gia)){
            if(params.isEmpty()){
                queryBuilder.append("where ");
            }
            else {
                queryBuilder.append("and ");
            }
            queryBuilder.append("tong_gia >= :x" );
            params.put("x", gia);
        }

        String cmd = queryBuilder.toString();
        var query = entityManager.createNativeQuery(cmd, HoaDon.class);
        params.forEach(query::setParameter);
        List<HoaDon> rs = (List<HoaDon>) query.getResultList();
        return rs;
    }
}
