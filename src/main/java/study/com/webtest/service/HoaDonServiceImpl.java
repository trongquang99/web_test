package study.com.webtest.service;

import org.springframework.stereotype.Service;
import study.com.webtest.model.HoaDon;
import study.com.webtest.model.HoaDonSanPham;
import study.com.webtest.model.KhachHang;
import study.com.webtest.model.SanPham;
import study.com.webtest.repository.HoaDonRepository;
import study.com.webtest.repository.HoaDonSanPhamRepository;
import study.com.webtest.repository.KhachHangRepository;
import study.com.webtest.repository.SanPhamRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class HoaDonServiceImpl implements HoaDonService{
    private final KhachHangRepository khachHangRepository;
    private final HoaDonRepository hoaDonRepository;
    private final SanPhamRepository sanPhamRepository;
    private final HoaDonSanPhamRepository hoaDonSanPhamRepository;

    public HoaDonServiceImpl(KhachHangRepository khachHangRepository, HoaDonRepository hoaDonRepository, SanPhamRepository sanPhamRepository, HoaDonSanPhamRepository hoaDonSanPhamRepository) {
        this.khachHangRepository = khachHangRepository;
        this.hoaDonRepository = hoaDonRepository;
        this.sanPhamRepository = sanPhamRepository;
        this.hoaDonSanPhamRepository = hoaDonSanPhamRepository;
    }

    @Override
    public List<HoaDon> layDanhSachHoaDonTheoTenVaGia(String tenSp, String tenKh, Float gia) {
        List<HoaDon> hoaDons = new ArrayList<>();
        if(tenSp == null && tenKh == null && gia == null){
            hoaDons = hoaDonRepository.findAll();
        }
        if(tenSp == null && tenKh == null && gia != null){
            hoaDons = hoaDonRepository.findByTongGiaGreaterThanEquals(gia);
        }

        if(tenSp == null && tenKh != null && gia == null){
            List<KhachHang> danhSachKh = khachHangRepository.findByTenContaining(tenKh);
            List<Long> dSIdKh = new ArrayList<>();
            danhSachKh.forEach(khachHang -> {
                dSIdKh.add(khachHang.getId());
            });
            List<HoaDon> danhSachHd = hoaDonRepository.findByIdKhIn(dSIdKh);
            hoaDons = danhSachHd;
         }

        if (tenSp == null && tenKh !=null && gia != null){
            List<KhachHang> dSKhTheoTen = khachHangRepository.findByTenContaining(tenKh);
            List<Long> dSIdKh = new ArrayList<>();
            dSKhTheoTen.forEach(khachHang -> {
                dSIdKh.add(khachHang.getId());
            });
            List<HoaDon> danhSachHdIdKh = hoaDonRepository.findByIdKhIn(dSIdKh);

            List<HoaDon> danhSachHdGia = hoaDonRepository.danhSachHoaDonTheoGia(gia);

            List<HoaDon> giaoHdIdKhGia = new ArrayList<>();
            danhSachHdIdKh.forEach(hoaDonIdKh -> {
                danhSachHdGia.forEach(hoaDonGia -> {
                    if(Objects.equals(hoaDonIdKh.getId(), hoaDonGia.getId())){
                        giaoHdIdKhGia.add(hoaDonIdKh);
                    }
                });
            });
            hoaDons = giaoHdIdKhGia;
         }

        if(tenSp != null && tenKh == null && gia == null){
            List<SanPham> danhSachSp = sanPhamRepository.findByTenContaining(tenSp);
            List<Long> dSIdSp = new ArrayList<>();
            danhSachSp.forEach(sanPham -> {
                dSIdSp.add(sanPham.getId());
            });
            List<HoaDonSanPham> danhSachHdSp = hoaDonSanPhamRepository.findByIdSpIn(dSIdSp);
            List<Long> dSIdHd = new ArrayList<>();
            danhSachHdSp.forEach(hoaDonSanPham -> {
                dSIdHd.add(hoaDonSanPham.getIdHd());
            });
            List<HoaDon> danhSachHoaDon = hoaDonRepository.findByIdIn(dSIdHd);
            hoaDons = danhSachHoaDon;
        }

        if(tenSp != null && tenKh == null && gia != null){
            List<SanPham> dSachSpTheoTen = sanPhamRepository.findByTenContaining(tenSp);
            List<Long> dSIdSp = new ArrayList<>();
            dSachSpTheoTen.forEach(sanPham -> {
                dSIdSp.add(sanPham.getId());
            });
            List<HoaDonSanPham> dSachHdSp = hoaDonSanPhamRepository.findByIdSpIn(dSIdSp);
            List<Long> dSIdHdSp = new ArrayList<>();
            dSachHdSp.forEach(hoaDonSanPham -> {
                dSIdHdSp.add(hoaDonSanPham.getIdHd());
            });
            List<HoaDon> danhSachIdHd = hoaDonRepository.findByIdIn(dSIdHdSp);

            List<HoaDon> danhSachIdGia = hoaDonRepository.danhSachHoaDonTheoGia(gia);

            List<HoaDon> giaoIdHdGia = new ArrayList<>();
            danhSachIdHd.forEach(hoaDon -> {
                danhSachIdGia.forEach(hoaDonIdGia -> {
                    if(Objects.equals(hoaDon.getId(), hoaDonIdGia.getId())){
                        giaoIdHdGia.add(hoaDon);
                    }
                });
            });
            hoaDons = giaoIdHdGia;
         }

        if(tenSp != null && tenKh != null && gia == null){
            List<SanPham> danhSach1 = sanPhamRepository.findByTenContaining(tenSp);
            List<Long> dSIdSp1 = new ArrayList<>();
            danhSach1.forEach(sanPham -> {
                dSIdSp1.add(sanPham.getId());
            });
            List<HoaDonSanPham> hoaDonSanPham1 = hoaDonSanPhamRepository.findByIdSpIn(dSIdSp1);
            List<Long> dSIdHdSp1 = new ArrayList<>();
            hoaDonSanPham1.forEach(hoaDonSanPham -> {
                dSIdHdSp1.add(hoaDonSanPham.getIdHd());
            });
            List<HoaDon> hoaDon1 = hoaDonRepository.findByIdIn(dSIdHdSp1);

            List<KhachHang> danhSachKhachHang2 = khachHangRepository.findByTenContaining(tenKh);
            List<Long> dSIdKh2 = new ArrayList<>();
            danhSachKhachHang2.forEach(khachHang -> {
                dSIdKh2.add(khachHang.getId());
            });
            List<HoaDon> hoaDon2 = hoaDonRepository.findByIdKhIn(dSIdKh2);

            List<HoaDon> hoaDon3 = new ArrayList<>();
            hoaDon1.forEach(hoaDonDS1 ->{
                hoaDon2.forEach(hoaDonDS2 -> {
                    if(Objects.equals(hoaDonDS1.getId(), hoaDonDS2.getId())){
                        hoaDon3.add(hoaDonDS1);
                    }
                });
            });
            hoaDons = hoaDon3;
        }
        if(tenSp != null && tenKh != null && gia != null){
            List<SanPham> danhSachSp1 = sanPhamRepository.findByTenContaining(tenSp);
            List<Long> dSPId1 = new ArrayList<>();
            danhSachSp1.forEach(sanPham -> {
                dSPId1.add(sanPham.getId());
            });
            List<HoaDonSanPham> danhSachHdSp1 = hoaDonSanPhamRepository.findByIdSpIn(dSPId1);
            List<Long> dSHdSp1 = new ArrayList<>();
            danhSachHdSp1.forEach(hoaDonSanPham -> {
                dSHdSp1.add(hoaDonSanPham.getIdHd());
            });
            List<HoaDon> danhSachHd1 = hoaDonRepository.findByIdIn(dSHdSp1);

            List<KhachHang> danhSachKh2 = khachHangRepository.findByTenContaining(tenKh);
            List<Long> dSKh2 = new ArrayList<>();
            danhSachKh2.forEach(khachHang -> {
                dSKh2.add(khachHang.getId());
            });
            List<HoaDon> danhSachHd2 = hoaDonRepository.findByIdKhIn(dSKh2);

            List<HoaDon> danhSachHd3 = hoaDonRepository.findByTongGiaGreaterThanEqual(gia);

            List<HoaDon> giaoDanhSachHD123 = new ArrayList<>();
            danhSachHd1.forEach(hd -> {
                if (danhSachHd2.contains(hd) && danhSachHd3.contains(hd)) {
                    giaoDanhSachHD123.add(hd);
                }
            });
            hoaDons = giaoDanhSachHD123;
         }

        return hoaDons;
    }
}
