package study.com.webtest.service;

import org.springframework.stereotype.Service;
import study.com.webtest.dtos.response.*;
import study.com.webtest.model.*;
import study.com.webtest.repository.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerDetailImpl implements CustomerDetailService{
    private final KhachHangRepository khachHangRepository;
    private final HoaDonRepository hoaDonRepository;
    private final HoaDonSanPhamRepository hoaDonSanPhamRepository;
    private final SanPhamRepository sanPhamRepository;
    private final GioHangRepository gioHangRepository;
    private final GioHangSanPhamRepository gioHangSanPhamRepository;


    public CustomerDetailImpl(KhachHangRepository khachHangRepository, HoaDonRepository hoaDonRepository, HoaDonSanPhamRepository hoaDonSanPhamRepository, SanPhamRepository sanPhamRepository, GioHangRepository gioHangRepository, GioHangSanPhamRepository gioHangSanPhamRepository) {
        this.khachHangRepository = khachHangRepository;
        this.hoaDonRepository = hoaDonRepository;
        this.hoaDonSanPhamRepository = hoaDonSanPhamRepository;
        this.sanPhamRepository = sanPhamRepository;
        this.gioHangRepository = gioHangRepository;
        this.gioHangSanPhamRepository = gioHangSanPhamRepository;
    }

    @Override
    public List<CustomerDetailResponse> getListCustomerDetail() {
        List<CustomerDetailResponse> customerDetailResponseList = new ArrayList<>();
        List<KhachHang> khachHangList = khachHangRepository.findAll();

        khachHangList.forEach(khachHang -> {
            CustomerDetailResponse customerDetailResponse = new CustomerDetailResponse();
            customerDetailResponse.setId(khachHang.getId());
            customerDetailResponse.setName(khachHang.getTen());
            customerDetailResponse.setPhone(khachHang.getSdt());
            customerDetailResponse.setEmail(khachHang.getEmail());

            List<HoaDon> hoaDonList = hoaDonRepository.findByIdKh(khachHang.getId());
            List<DanhSachHoaDon> danhSachHoaDonList = new ArrayList<>();

            hoaDonList.forEach(hoaDon -> {
                DanhSachHoaDon danhSachHoaDon = new DanhSachHoaDon();
                danhSachHoaDon.setId(hoaDon.getId());
                danhSachHoaDon.setNgayThanhToan(hoaDon.getNgay_thanh_toan());
                danhSachHoaDon.setTongTien(hoaDon.getTongGia());

                List<HoaDonSanPham> hoaDonSanPhamList = hoaDonSanPhamRepository.findByIdHd(hoaDon.getId());
                List<DanhSachHoaDon.DanhSachSanPham> danhSachSanPhamList = new ArrayList<>();
                hoaDonSanPhamList.forEach(hoaDonSanPham -> {
                    DanhSachHoaDon.DanhSachSanPham spChiTiet = new DanhSachHoaDon.DanhSachSanPham();
                    Optional<SanPham> optionalSanPham = sanPhamRepository.findById(hoaDonSanPham.getIdSp());
                    if(optionalSanPham.isPresent()){
                        SanPham sanPhamById = optionalSanPham.get();
                        spChiTiet.setTen(sanPhamById.getTen());
                        spChiTiet.setGia(sanPhamById.getGia());
                        spChiTiet.setSoLuong(hoaDonSanPham.getSoLuong());
                    }
                    danhSachSanPhamList.add(spChiTiet);
                });
                danhSachHoaDon.setDsSp(danhSachSanPhamList);
                danhSachHoaDonList.add(danhSachHoaDon);
            });
            customerDetailResponse.setDsHd(danhSachHoaDonList);
            customerDetailResponseList.add(customerDetailResponse);

            List<GioHang> gioHangList = gioHangRepository.findByIdKh(khachHang.getId());
            List<DanhSachGioHang> danhSachGioHangList = new ArrayList<>();
            gioHangList.forEach(gioHang -> {
                DanhSachGioHang danhSachGioHang = new DanhSachGioHang();
                danhSachGioHang.setId(gioHang.getId());
                danhSachGioHang.setTongTien(gioHang.getTongTien());

                List<GioHangSanPham> gioHangSanPhamList = gioHangSanPhamRepository.findByIdGh(gioHang.getId());
                List<DanhSachGioHang.SanPhamChiTiet> sanPhamChiTietList = new ArrayList<>();
                gioHangSanPhamList.forEach(gioHangSanPham -> {
                    DanhSachGioHang.SanPhamChiTiet sanPhamChiTiet2 = new DanhSachGioHang.SanPhamChiTiet();
                    Optional<SanPham> optionalSanPham2 = sanPhamRepository.findById(gioHangSanPham.getIdSp());
                    if(optionalSanPham2.isPresent()){
                        SanPham sanPhamById2 = optionalSanPham2.get();
                        sanPhamChiTiet2.setTen(sanPhamById2.getTen());
                        sanPhamChiTiet2.setGia(sanPhamById2.getGia());
                        sanPhamChiTiet2.setSoLuong(gioHangSanPham.getSoLuong());
                    }
                    sanPhamChiTietList.add(sanPhamChiTiet2);
                });
                danhSachGioHang.setSpCt(sanPhamChiTietList);
                danhSachGioHangList.add(danhSachGioHang);
            });
            customerDetailResponse.setDsGh(danhSachGioHangList);
            customerDetailResponseList.add(customerDetailResponse);
         });
        return customerDetailResponseList;
    }

    @Override
    public BillDetailNewResponse getBillDetailNew(Long id) {
        BillDetailNewResponse billDetailNewResponse = new BillDetailNewResponse();
        GioHang gioHangById = gioHangRepository.findById(id).get();

        HoaDon hoaDon = new HoaDon();
        hoaDon.setIdKh(gioHangById.getIdKh());
        hoaDon.setTongGia(gioHangById.getTongTien());
        hoaDon.setNgay_thanh_toan(new Date());
        HoaDon saveHoaDon = hoaDonRepository.save(hoaDon);

        KhachHang khachHangById = khachHangRepository.findById(gioHangById.getIdKh()).get();
        billDetailNewResponse.setIdGh(gioHangById.getId());
        billDetailNewResponse.setTenKh(khachHangById.getTen());
        billDetailNewResponse.setSdtKh(khachHangById.getSdt());
        billDetailNewResponse.setIdHD(saveHoaDon.getId());
        billDetailNewResponse.setNgayThanhToan(saveHoaDon.getNgay_thanh_toan());
        billDetailNewResponse.setTongTien(saveHoaDon.getTongGia());

        List<BillDetailNewResponse.SpChiTiet> danhSachSpChiTiet = new ArrayList<>();
        List<GioHangSanPham> gioHangSanPhamList = gioHangSanPhamRepository.findByIdGh(id);
        gioHangSanPhamList.forEach(gioHangSanPham -> {
            BillDetailNewResponse.SpChiTiet spChiTiet = new BillDetailNewResponse.SpChiTiet();
            SanPham sanPhamById = sanPhamRepository.findById(gioHangSanPham.getIdSp()).get();
            spChiTiet.setTen(sanPhamById.getTen());
            spChiTiet.setSoLuong(gioHangSanPham.getSoLuong());
            spChiTiet.setGia(sanPhamById.getGia());

            HoaDonSanPham hoaDonSanPham = new HoaDonSanPham();
            hoaDonSanPham.setIdHd(saveHoaDon.getId());
            hoaDonSanPham.setIdSp(gioHangSanPham.getIdSp());
            hoaDonSanPham.setSoLuong(gioHangSanPham.getSoLuong());
            hoaDonSanPhamRepository.save(hoaDonSanPham);

            danhSachSpChiTiet.add(spChiTiet);
        });
        billDetailNewResponse.setDanhSachSp(danhSachSpChiTiet);
        return billDetailNewResponse;
    }


}
