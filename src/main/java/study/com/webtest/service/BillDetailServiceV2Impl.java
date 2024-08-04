package study.com.webtest.service;

import org.springframework.stereotype.Service;
import study.com.webtest.dtos.response.BillDetailResponseV2;
import study.com.webtest.dtos.response.DuLieuSanPham;
import study.com.webtest.model.*;
import study.com.webtest.repository.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BillDetailServiceV2Impl implements BillServiceV2{
    private final HoaDonRepository hoaDonRepository;
    private final CuaHangRepository cuaHangRepository;
    private final HoaDonCuaHangRepository hoaDonCuaHangRepository;
    private final KhachHangRepository khachHangRepository;
    private final HoaDonSanPhamRepository hoaDonSanPhamRepository;
    private final SanPhamRepository sanPhamRepository;

    public BillDetailServiceV2Impl(HoaDonRepository hoaDonRepository, CuaHangRepository cuaHangRepository, HoaDonCuaHangRepository hoaDonCuaHangRepository, KhachHangRepository khachHangRepository, HoaDonSanPhamRepository hoaDonSanPhamRepository, SanPhamRepository sanPhamRepository) {
        this.hoaDonRepository = hoaDonRepository;
        this.cuaHangRepository = cuaHangRepository;
        this.hoaDonCuaHangRepository = hoaDonCuaHangRepository;
        this.khachHangRepository = khachHangRepository;
        this.hoaDonSanPhamRepository = hoaDonSanPhamRepository;
        this.sanPhamRepository = sanPhamRepository;
    }

    @Override
    public List<BillDetailResponseV2> getBillDetail() {
        List<BillDetailResponseV2> billDetailResponseV2s = new ArrayList<>();
        List<HoaDon> hoaDonList = hoaDonRepository.danhSachHoaDon();

        hoaDonList.forEach(hoaDon -> {
            BillDetailResponseV2 billDetailResponseV2 = new BillDetailResponseV2();
            HoaDonCuaHang hoaDonCuaHang = hoaDonCuaHangRepository.findByIdHd(hoaDon.getId());
            Optional<CuaHang> optionalCuaHang = cuaHangRepository.findById(hoaDonCuaHang.getIdCh());
            if(optionalCuaHang.isPresent()) {
                CuaHang cuaHangById = optionalCuaHang.get();
                billDetailResponseV2.setTenCh(cuaHangById.getTen());
                billDetailResponseV2.setDiaChi(cuaHangById.getDiChi());
            }
            else {
                billDetailResponseV2.setTenCh("khong tim thay ten cua hang");
                billDetailResponseV2.setDiaChi("khong tim thay dia chi");
            }

            Optional<KhachHang> optionalKhachHang = khachHangRepository.findById(hoaDon.getIdKh());
            if(optionalKhachHang.isPresent()) {
                KhachHang khachHangById = optionalKhachHang.get();
                billDetailResponseV2.setTenKh(khachHangById.getTen());
                billDetailResponseV2.setSdtKh(khachHangById.getSdt());
            }
            else{
                billDetailResponseV2.setTenKh("khong tim thay ten khach hang");
                billDetailResponseV2.setSdtKh("khong tim thay SDT khach hang");
            }
            billDetailResponseV2.setId(hoaDon.getId());
            billDetailResponseV2.setTongTien(hoaDon.getTongGia());
            billDetailResponseV2.setNgayThanhToan(hoaDon.getNgay_thanh_toan());

            List<DuLieuSanPham> danhSachSpChiTiet = new ArrayList<>();
            List<HoaDonSanPham> danhSachHoaDonSanPham = hoaDonSanPhamRepository.findByIdHd(hoaDon.getId());

            danhSachHoaDonSanPham.forEach(hoaDonSanPham -> {
                DuLieuSanPham spChiTiet = new DuLieuSanPham();
                Optional<SanPham> optionalSanPham = sanPhamRepository.findById(hoaDonSanPham.getIdSp());
                if(optionalSanPham.isPresent()){
                    SanPham sanPhamById = optionalSanPham.get();
                    spChiTiet.setTen(sanPhamById.getTen());
                    spChiTiet.setSoLuong(hoaDonSanPham.getSoLuong());
                    spChiTiet.setGia(sanPhamById.getGia());
                }
                else {
                    spChiTiet.setTen("khong tim thay ten san pham");
                }
                danhSachSpChiTiet.add(spChiTiet);
            });
            billDetailResponseV2.setDsSp(danhSachSpChiTiet);
            billDetailResponseV2s.add(billDetailResponseV2);
        });
        return billDetailResponseV2s;
    }
}
