package study.com.webtest.service;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;
import study.com.webtest.dtos.response.GioHangBuilderResponse;
import study.com.webtest.model.*;
import study.com.webtest.repository.*;

import java.util.*;

@Service
public class GioHangServiceBuilder {
    private final EntityManager entityManager;
    private final KhachHangRepository khachHangRepository;
    private final GioHangSanPhamRepository gioHangSanPhamRepository;
    private final SanPhamRepository sanPhamRepository;

    public GioHangServiceBuilder(EntityManager entityManager, GioHangRepository gioHangRepository, CuaHangRepository cuaHangRepository, GioHangCuaHangRepository gioHangCuaHangRepository, KhachHangRepository khachHangRepository, GioHangSanPhamRepository gioHangSanPhamRepository, SanPhamRepository sanPhamRepository) {
        this.entityManager = entityManager;
        this.khachHangRepository = khachHangRepository;
        this.gioHangSanPhamRepository = gioHangSanPhamRepository;
        this.sanPhamRepository = sanPhamRepository;
    }

    public List<GioHangBuilderResponse> layDanhSachGioHang(String tenKh, String sdtKh, String tenCh, String sdtCh, String tenSp, Float tongGia){
        StringBuilder queryBuilder = new StringBuilder("""
                select * from giohang 
                """);
        var params = new HashMap<String, Object>();
        if(Objects.nonNull(tenKh)){
            queryBuilder.append("""
                    where id_kh in (
                    select id from khachhang where ten like concat('%', :tenKh, '%') )
                    """);
            params.put("tenKh", tenKh);
        }
        if(Objects.nonNull(sdtKh)){
            if(params == null){
                queryBuilder.append("where");
            }
            else {
                queryBuilder.append("and ");
            }
            queryBuilder.append("""
                    id_kh in (
                    select id from khachhang where sdt = :sdt )
                    """);
            params.put("sdt", sdtKh);
        }
        if(Objects.nonNull(tenCh)){
            if(params == null){
                queryBuilder.append("where");
            }
            else {
                queryBuilder.append("and ");
            }
            queryBuilder.append("""
                     id in (
                    select id_gh from giohang_cuahang where id_ch in (
                           select id from cuahang where ten like concat('%', :tenCh, '%') ))
                    """);
            params.put("tenCh", tenCh);
        }
        if(Objects.nonNull(sdtCh)){
            if(params == null){
                queryBuilder.append("where");
            }
            else {
                queryBuilder.append("and ");
            }
            queryBuilder.append("""
                     id in (
                    select id_gh from giohang_cuahang where id_ch in (
                           select id from cuahang where sdt = :sdtCh ))
                    """);
            params.put("sdtCh", sdtCh);
        }
        if(Objects.nonNull(tenSp)){
            if(params.isEmpty()){
                queryBuilder.append("where");
            }
            else {
                queryBuilder.append("and ");
            }
            queryBuilder.append("""
                     id in (
                    select id_gh from giohang_sanpham where id_sp in (
                           select id from sanpham where ten like concat('%', :tenSp, '%') ))
                    """);
            params.put("tenSp", tenSp);
        }
        if(Objects.nonNull(tongGia)){
            if(params.isEmpty()){
                queryBuilder.append("where");
            }
            else {
                queryBuilder.append("and ");
            }
            queryBuilder.append(" tong_tien >= :x" );
            params.put("x", tongGia);
        }
        String cmd = queryBuilder.toString();
        var query = entityManager.createNativeQuery(cmd, GioHang.class);
        params.forEach(query::setParameter);
        List<GioHang> gioHangList = (List<GioHang>) query.getResultList();

        List<GioHangBuilderResponse> gioHangChiTietBuilder = new ArrayList<>();
        gioHangList.forEach(gioHang -> {
            GioHangBuilderResponse gioHangBuilderResponse = new GioHangBuilderResponse();
            Optional<KhachHang> optionalKhachHang = khachHangRepository.findById(gioHang.getIdKh());
            if(optionalKhachHang.isPresent()){
                KhachHang khachHangById = optionalKhachHang.get();
                gioHangBuilderResponse.setTenKh(khachHangById.getTen());
            }
            gioHangBuilderResponse.setId(gioHang.getId());
            gioHangBuilderResponse.setTongGia(gioHang.getTongTien());

            List<GioHangBuilderResponse.SpChiTiet> dSChiTietSanPham = new ArrayList<>();
            List<GioHangSanPham> gioHangSanPhams = gioHangSanPhamRepository.findByIdGh(gioHang.getId());
            gioHangSanPhams.forEach(gioHangSp -> {
                GioHangBuilderResponse.SpChiTiet chiTietSp = new GioHangBuilderResponse.SpChiTiet();

                Optional<SanPham> optionalSanPham = sanPhamRepository.findById(gioHangSp.getIdSp());
                if(optionalSanPham.isPresent()){
                    SanPham sanPhamById = optionalSanPham.get();
                    chiTietSp.setTen(sanPhamById.getTen());
                    chiTietSp.setGia(sanPhamById.getGia());
                    chiTietSp.setSoLuong(gioHangSp.getSoLuong());
                }
                dSChiTietSanPham.add(chiTietSp);
            });
            gioHangBuilderResponse.setDanhSachSp(dSChiTietSanPham);
            gioHangChiTietBuilder.add(gioHangBuilderResponse);
        });
        return gioHangChiTietBuilder;

    }
}
