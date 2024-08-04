package study.com.webtest.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import study.com.webtest.dtos.response.BillDetailResponse;
//import study.com.webtest.dtos.response.SpChiTiet;
import study.com.webtest.model.*;
import study.com.webtest.repository.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BillServiceImpl implements BillService {
    //    protected String abc = "âfafafaf";
    private final HoaDonRepository hoaDonRepository;
    private final CuaHangRepository cuaHangRepository;
    private final KhachHangRepository khachHangRepository;
    private final HoaDonSanPhamRepository hoaDonSanPhamRepository;
    private final SanPhamRepository sanPhamRepository;

    public BillServiceImpl(HoaDonRepository hoaDonRepository, CuaHangRepository cuaHangRepository, KhachHangRepository khachHangRepository, HoaDonSanPhamRepository hoaDonSanPhamRepository, SanPhamRepository sanPhamRepository) {
        this.hoaDonRepository = hoaDonRepository;
        this.cuaHangRepository = cuaHangRepository;
        this.khachHangRepository = khachHangRepository;
        this.hoaDonSanPhamRepository = hoaDonSanPhamRepository;
        this.sanPhamRepository = sanPhamRepository;
    }

    @Override
    public BillDetailResponse getBillDetailById(Long id) {
        BillDetailResponse billDetailResponse = new BillDetailResponse();
        HoaDon hoaDonById = hoaDonRepository.findById(id).get();
//        String tmp = abc;
        CuaHang cuaHangById = cuaHangRepository.findById(1L).get(); // tạm thời dùng id = 1 +. chuyển sang bảng hoadon_cuahang

        KhachHang khachHangById = khachHangRepository.findById(hoaDonById.getIdKh()).get();
        billDetailResponse.setIdHd(hoaDonById.getId());
        billDetailResponse.setTenCh(cuaHangById.getTen());
        billDetailResponse.setDiaChi(cuaHangById.getDiChi());
        billDetailResponse.setTenKh(khachHangById.getTen());
        billDetailResponse.setNgayThanhToan(hoaDonById.getDateSuccess());
        billDetailResponse.setTongThanhToan(hoaDonById.getTongGia());
//        return billDetailResponse;
        //Khởi tạo list spchitiet => adđ response  -> BillDetailResponse
        List<BillDetailResponse.SpChiTiet> danhSachSpChiTiet = new ArrayList<>();

        //Vì 1 id hóa đơn => có nhiều hoadon_sanpham
        List<HoaDonSanPham> hoaDonSanPhamList = hoaDonSanPhamRepository.findByIdHd(id);

//        for (int i = 0; i < hoaDonSanPhamList.size(); i++){
//            SpChiTiet spChiTiet = new SpChiTiet();
//            SanPham sanPhamById = sanPhamRepository.findById(hoaDonSanPhamList.get(i).getIdSp()).get();
//            spChiTiet.setTen(sanPhamById.getTen());
//            spChiTiet.setSoLuong(Long.valueOf(hoaDonSanPhamList.get(i).getSoLuong()));
//            spChiTiet.setGia(sanPhamById.getGia());
//            danhSachSpChiTiet.add(spChiTiet);
//        }

//        for (HoaDonSanPham hoaDonSanPham: hoaDonSanPhamList){
//            SpChiTiet spChiTiet = new SpChiTiet();
//            SanPham sanPhamById = sanPhamRepository.findById(hoaDonSanPham.getIdSp()).get();
//            spChiTiet.setTen(sanPhamById.getTen());
//            spChiTiet.setSoLuong(Long.valueOf(hoaDonSanPham.getSoLuong()));
//            spChiTiet.setGia(sanPhamById.getGia());
//            danhSachSpChiTiet.add(spChiTiet);
//        }

        hoaDonSanPhamList.forEach(hoaDonSanPham -> {
            BillDetailResponse.SpChiTiet spChiTiet = new BillDetailResponse.SpChiTiet();
            SanPham sanPhamById = sanPhamRepository.findById(hoaDonSanPham.getIdSp()).get();
            spChiTiet.setTen(sanPhamById.getTen());
            spChiTiet.setSoLuong(Long.valueOf(hoaDonSanPham.getSoLuong()));
            spChiTiet.setGia(sanPhamById.getGia());
            danhSachSpChiTiet.add(spChiTiet);
        });

        billDetailResponse.setDanhSachSp(danhSachSpChiTiet);
        return billDetailResponse;
    }

    @Override
//    public List<BillDetailResponse> getBillDetailList() {
//        List<BillDetailResponse> billDetaiList = new ArrayList<>();
//
//        List<HoaDon> hoaDonList = hoaDonRepository.findByTongGiaGreaterThanEqual(1000);
//        for(int i = 0; i<hoaDonList.size(); i++){
//            BillDetailResponse billDetailResponse = new BillDetailResponse();
//
//            CuaHang cuaHangById = cuaHangRepository.findById(1L).get();
//            billDetailResponse.setTenCh(cuaHangById.getTen());
//            billDetailResponse.setDiaChi(cuaHangById.getDiChi());
//
//            KhachHang khachHangById = khachHangRepository.findById(hoaDonList.get(i).getId_kh()).get();
//            billDetailResponse.setTenKh(khachHangById.getTen());
//
//            billDetailResponse.setIdHd(hoaDonList.get(i).getId());
//            billDetailResponse.setNgayThanhToan(hoaDonList.get(i).getNgay_thanh_toan());
//            billDetailResponse.setTongThanhToan(hoaDonList.get(i).getTong_gia());
//
//
//            List<BillDetailResponse.SpChiTiet> danhSachSpChiTiet = new ArrayList<>();
//
//            List<HoaDonSanPham> hoaDonSanPhamList = hoaDonSanPhamRepository.findByIdHd(hoaDonList.get(i).getId());
//
//            for (int j = 0; j < hoaDonSanPhamList.size(); j++){
//                BillDetailResponse.SpChiTiet spChiTiet = new BillDetailResponse.SpChiTiet();
//                SanPham sanPhamById = sanPhamRepository.findById(hoaDonSanPhamList.get(i).getIdSp()).get();
//
//                spChiTiet.setTen(sanPhamById.getTen());
//                spChiTiet.setSoLuong(Long.valueOf(hoaDonSanPhamList.get(i).getSoLuong()));
//                spChiTiet.setGia(sanPhamById.getGia());
//                danhSachSpChiTiet.add(spChiTiet);
//        }
//            billDetailResponse.setDanhSachSp(danhSachSpChiTiet);
//
//            billDetaiList.add(billDetailResponse);
//        }
//
//        return billDetaiList;
//    }
//}

    public List<BillDetailResponse> getBillDetailList() {
        List<BillDetailResponse> billDetaiList = new ArrayList<>();

        List<HoaDon> hoaDonList = hoaDonRepository.findByTongGiaGreaterThanEquals(100000F);
        for (int i = 0; i < hoaDonList.size(); i++) {
            BillDetailResponse billDetailResponse = new BillDetailResponse();

            // Kiểm tra Optional trước khi gọi get()
//            try{
//                Optional<CuaHang> optionalCuaHang = cuaHangRepository.findById(21L);
//                CuaHang tmp = optionalCuaHang.get();
//                if (optionalCuaHang.isPresent()) {
//                    CuaHang cuaHangById = optionalCuaHang.get();
//                    billDetailResponse.setTenCh(cuaHangById.getTen());
//                    billDetailResponse.setDiaChi(cuaHangById.getDiChi());
//                } else {
//                    // Xử lý trường hợp không tìm thấy CuaHang
//                    billDetailResponse.setTenCh("Unknown Store");
//                    billDetailResponse.setDiaChi("Unknown Address");
//                }
//            }catch (Exception ex){
//                log.error("Loi o dau vay", ex);
//            }
            Optional<CuaHang> optionalCuaHang = cuaHangRepository.findById(1L);
             if (optionalCuaHang.isPresent()) {
                CuaHang cuaHangById = optionalCuaHang.get();
                billDetailResponse.setTenCh(cuaHangById.getTen());
                billDetailResponse.setDiaChi(cuaHangById.getDiChi());
            } else {
//                continue;
//                // Xử lý trường hợp không tìm thấy CuaHang
                billDetailResponse.setTenCh("Unknown Store");
                billDetailResponse.setDiaChi("Unknown Address");
            }

            // Retrieve and set customer details
            Optional<KhachHang> optionalKhachHang = khachHangRepository.findById(hoaDonList.get(i).getIdKh());
            if (optionalKhachHang.isPresent()) {
                KhachHang khachHangById = optionalKhachHang.get();
                billDetailResponse.setTenKh(khachHangById.getTen());
            } else {
                // Xử lý trường hợp không tìm thấy KhachHang
                billDetailResponse.setTenKh("Unknown Customer");
            }

            billDetailResponse.setIdHd(hoaDonList.get(i).getId());
            billDetailResponse.setNgayThanhToan(hoaDonList.get(i).getDateSuccess());
            billDetailResponse.setTongThanhToan(hoaDonList.get(i).getTongGia());

            List<BillDetailResponse.SpChiTiet> danhSachSpChiTiet = new ArrayList<>();
            List<HoaDonSanPham> hoaDonSanPhamList = hoaDonSanPhamRepository.findByIdHd(hoaDonList.get(i).getId());

            for (int j = 0; j < hoaDonSanPhamList.size(); j++) {
                BillDetailResponse.SpChiTiet spChiTiet = new BillDetailResponse.SpChiTiet();
                // Kiểm tra Optional trước khi gọi get()
                Optional<SanPham> optionalSanPham = sanPhamRepository.findById(hoaDonSanPhamList.get(j).getIdSp());
                if (optionalSanPham.isPresent()) {
                    SanPham sanPhamById = optionalSanPham.get();
                    spChiTiet.setTen(sanPhamById.getTen());
                    spChiTiet.setSoLuong(Long.valueOf(hoaDonSanPhamList.get(j).getSoLuong()));
                    spChiTiet.setGia(sanPhamById.getGia());
                } else {
                    // Xử lý trường hợp không tìm thấy SanPham
                    spChiTiet.setTen("Unknown Product");
                    spChiTiet.setSoLuong(0L);
                    spChiTiet.setGia((int) 0.0);
                }
                danhSachSpChiTiet.add(spChiTiet);
            }
            billDetailResponse.setDanhSachSp(danhSachSpChiTiet);

            billDetaiList.add(billDetailResponse);
        }

        return billDetaiList;
    }

    @Override
    public Integer getHoaDonCount() {
        return hoaDonRepository.soLuongHoaDon();
    }
}


