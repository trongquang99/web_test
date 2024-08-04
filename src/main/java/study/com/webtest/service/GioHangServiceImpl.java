package study.com.webtest.service;

import org.springframework.stereotype.Service;
import study.com.webtest.dtos.response.ChiTietSanPham;
import study.com.webtest.dtos.response.GioHangChiTietResponse;
import study.com.webtest.model.*;
import study.com.webtest.repository.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GioHangServiceImpl implements GioHangService {
    private final GioHangRepository gioHangRepository;
    private final CuaHangRepository cuaHangRepository;
    private final GioHangCuaHangRepository gioHangCuaHangRepository;
    private final KhachHangRepository khachHangRepository;
    private final GioHangSanPhamRepository gioHangSanPhamRepository;
    private final SanPhamRepository sanPhamRepository;

    public GioHangServiceImpl(GioHangRepository gioHangRepository, CuaHangRepository cuaHangRepository, GioHangCuaHangRepository gioHangCuaHangRepository, KhachHangRepository khachHangRepository, GioHangSanPhamRepository gioHangSanPhamRepository, SanPhamRepository sanPhamRepository) {
        this.gioHangRepository = gioHangRepository;
        this.cuaHangRepository = cuaHangRepository;
        this.gioHangCuaHangRepository = gioHangCuaHangRepository;
        this.khachHangRepository = khachHangRepository;
        this.gioHangSanPhamRepository = gioHangSanPhamRepository;
        this.sanPhamRepository = sanPhamRepository;
    }

    @Override
    public GioHangChiTietResponse getGioHangChiTiet(Long id) {
        GioHangChiTietResponse gioHangChiTietResponse = new GioHangChiTietResponse();
        GioHang gioHangById = gioHangRepository.findById(id).get();

       GioHangCuaHang gioHangCuaHang = gioHangCuaHangRepository.findByIdGh(gioHangById.getId());
       Optional<CuaHang> optionalCuaHang = cuaHangRepository.findById(gioHangCuaHang.getIdCh());
       if (optionalCuaHang.isPresent()){
           CuaHang cuaHangById = optionalCuaHang.get();
           gioHangChiTietResponse.setTenCh(cuaHangById.getTen());
           gioHangChiTietResponse.setDiaChi(cuaHangById.getDiChi());
       }
       else {
           gioHangChiTietResponse.setTenCh("khong tim thay ten cua hang");
           gioHangChiTietResponse.setDiaChi("khong tim thay dia chi cua hang");
       }

       Optional<KhachHang> optionalKhachHang = khachHangRepository.findById(gioHangById.getIdKh());
       if(optionalKhachHang.isPresent()){
           KhachHang khachHangById = optionalKhachHang.get();
           gioHangChiTietResponse.setTenKh(khachHangById.getTen());
           gioHangChiTietResponse.setSdtKh(khachHangById.getSdt());
       }
       else {
           gioHangChiTietResponse.setTenKh("khong tim thay ten khach hang");
           gioHangChiTietResponse.setSdtKh("khong tim thay sdt khach hang");
       }

       gioHangChiTietResponse.setId(gioHangById.getId());
       gioHangChiTietResponse.setTongTien(gioHangById.getTongTien());

       List<ChiTietSanPham> chiTietSanPhamList = new ArrayList<>();
       List<GioHangSanPham> gioHangSanPhamList = gioHangSanPhamRepository.findByIdGh(id);

       gioHangSanPhamList.forEach(gioHangSanPham -> {
           ChiTietSanPham spChiTiet = new ChiTietSanPham();
           Optional<SanPham> optionalSanPham = sanPhamRepository.findById(gioHangSanPham.getIdSp());
           if(optionalSanPham.isPresent()){
               SanPham sanPhamById = optionalSanPham.get();
               spChiTiet.setTen(sanPhamById.getTen());
               spChiTiet.setSoLuong(gioHangSanPham.getSoLuong());
               spChiTiet.setGia(sanPhamById.getGia());
           }
           else {
               spChiTiet.setTen("khong tim thay ten san pham");
           }
           chiTietSanPhamList.add(spChiTiet);
       });
       gioHangChiTietResponse.setDsSp(chiTietSanPhamList);
        return gioHangChiTietResponse;
    }

    @Override
    public List<GioHangChiTietResponse> getGioHangChiTietList() {
        List<GioHangChiTietResponse> gioHangChiTietResponseList = new ArrayList<>();
        List<GioHang> gioHangList = gioHangRepository.danhSachGioHang();

        gioHangList.forEach(gioHang -> {
            GioHangChiTietResponse gioHangChiTietResponse = new GioHangChiTietResponse();

            GioHangCuaHang gioHangCuaHang = gioHangCuaHangRepository.findByIdGh(gioHang.getId());
            Optional<CuaHang> optionalCuaHang = cuaHangRepository.findById(gioHangCuaHang.getIdCh());
            if (optionalCuaHang.isPresent()){
                CuaHang cuaHangById = optionalCuaHang.get();
                gioHangChiTietResponse.setTenCh(cuaHangById.getTen());
                gioHangChiTietResponse.setDiaChi(cuaHangById.getDiChi());

                Optional<KhachHang> optionalKhachHang = khachHangRepository.findById(gioHang.getIdKh());
                if(optionalKhachHang.isPresent()){
                    KhachHang khachHangById = optionalKhachHang.get();
                    gioHangChiTietResponse.setTenKh(khachHangById.getTen());
                    gioHangChiTietResponse.setSdtKh(khachHangById.getSdt());
                }

                gioHangChiTietResponse.setId(gioHang.getId());
                gioHangChiTietResponse.setTongTien(gioHang.getTongTien());

                List<ChiTietSanPham> chiTietSanPhamList = new ArrayList<>();
                List<GioHangSanPham> gioHangSanPhamList = gioHangSanPhamRepository.findByIdGh(gioHang.getId());

                gioHangSanPhamList.forEach(gioHangSanPham -> {
                    ChiTietSanPham spChiTiet = new ChiTietSanPham();
                    Optional<SanPham> optionalSanPham = sanPhamRepository.findById(gioHangSanPham.getIdSp());
                    if(optionalSanPham.isPresent()){
                        SanPham sanPhamById = optionalSanPham.get();
                        spChiTiet.setTen(sanPhamById.getTen());
                        spChiTiet.setSoLuong(gioHangSanPham.getSoLuong());
                        spChiTiet.setGia(sanPhamById.getGia());
                    }
                    else {
                        spChiTiet.setTen("khong tim thay ten san pham");
                    }
                    chiTietSanPhamList.add(spChiTiet);
                });
                gioHangChiTietResponse.setDsSp(chiTietSanPhamList);
                gioHangChiTietResponseList.add(gioHangChiTietResponse);
            }
        });
        return gioHangChiTietResponseList;
    }
}
