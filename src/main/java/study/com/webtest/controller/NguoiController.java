package study.com.webtest.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import study.com.webtest.dtos.request.CuaHangRequest;
import study.com.webtest.dtos.response.HoaDonChiTietResponse;
import study.com.webtest.dtos.response.KetQuaHoaDon;
import study.com.webtest.model.*;
import study.com.webtest.repository.NguoiService;

import java.util.List;

@RestController
@AllArgsConstructor
public class NguoiController {

    NguoiService nguoiService;

//    @PostMapping("/user")
//    public String caNhan(
//            @RequestParam String ten,
//            @RequestParam String ngaySinh,
//            @RequestParam(name = "diaChi", required = false) String diaChi,
//            @RequestParam(name = "sdt", required = false) String sdt,
//            Integer tuoi
//    ) {
//        String ketQua = nguoiService.nguoiB(ten, ngaySinh, diaChi, sdt, tuoi);
//        return ketQua;
//        // check du lieu
////        if (ten == null || tuoi == null) return "lỗi input rồi";
////        if (tuoi < 10) {
////            return ten + "tre con" + tuoi;
////        } else if (tuoi >= 10 && tuoi < 50) {
////            return ten + " trung nien " + tuoi;
////        } else {
////            return ten + " gia " + tuoi;
////        }
//    }
//
//    @PostMapping("/ThongTin123")
//    public KetQuaCaNhan NguoiB(
//            @RequestParam String ten,
//            @RequestParam Integer tuoi
//    ){
//        KetQuaCaNhan ketQua = nguoiService.nguoiC(ten, tuoi);
//        return ketQua;
////        if(tuoi < 10){
////            String ketqua;
////            ketqua = ten + " tre con " + tuoi;
////            return new KetQuaCaNhan(ketqua);
////        } else if (tuoi >= 10 && tuoi < 50) {
////            return new KetQuaCaNhan(ten + " trung nien " + tuoi);
////        } else {
////            return new KetQuaCaNhan(ten + " gia " + tuoi);
////        }
//    }
//
//    @PostMapping("/Nguoi")
//    public String NguoiA(
//            @RequestBody ThongTinCaNhan nguoi
//    ) {
//        String ketQua = nguoiService.nguoiA(nguoi);
//        return ketQua;
////        if (nguoi.getTuoi() < 10) {
////            return nguoi.getTen() + "tre con" + nguoi.getTuoi();
////        } else if (nguoi.getTuoi() >= 10 && nguoi.getTuoi() < 50) {
////            return nguoi.getTen() + " trung nien " + nguoi.getTuoi();
////        } else {
////            return nguoi.getTen() + " gia " + nguoi.getTuoi();
////        }
//    }
//
//    @PostMapping("/CaNhan")
//    public KetQuaCaNhan caNhan(@RequestBody ThongTinCaNhan nguoi){
//        KetQuaCaNhan ketQua = nguoiService.thongTin(nguoi);
//        return ketQua;
////        if (nguoi.getTuoi() < 10) {
////            String Ketqua;
////            Ketqua = nguoi.getTen() + " tre con " + nguoi.getTuoi();
////            return new KetQuaCaNhan(Ketqua);
////        } else if (nguoi.getTuoi() >= 10 && nguoi.getTuoi() < 50) {
////            return new KetQuaCaNhan(nguoi.getTen() + " trung nien " + nguoi.getTuoi());
////        } else {
////            return new KetQuaCaNhan(nguoi.getTen() + " gia " + nguoi.getTuoi());
////        }
//    }


    @GetMapping("/api/cuahang/get_list")
    public List<CuaHang> getCuaHangList() {
        List<CuaHang> response = nguoiService.getAllcuaHang();
        return response;
    }

    @DeleteMapping("/api/delete/{id}")
    public void delete(@PathVariable Long id) {
        nguoiService.deleteCuaHang(id);
    }

    @PostMapping("api/themCuaHang")
    public CuaHang themCuaHang(@RequestBody CuaHang cuaHang){
        return nguoiService.createCuaHangA(cuaHang);
    }

    @PostMapping("/api/create")
    public CuaHang createCuaHang(@RequestBody CuaHangRequest cuaHangRequest) {
        return nguoiService.createCuaHang(cuaHangRequest);
    }

    @PutMapping("/update/{id}")
    public CuaHang updateCuaHang(@PathVariable Long id, @RequestBody CuaHang cuaHang) {
        return nguoiService.updateCuaHang(id, cuaHang);
    }

    @PutMapping("/update/CuaHang/{id}")
    public CuaHang capNhatCuaHang(@PathVariable Long id, @RequestBody CuaHangRequest cuaHangRequest) {
        return nguoiService.capNhatCuaHang(id, cuaHangRequest);
    }

    @GetMapping("/api/nguoi/get_list")
    public List<Nguoi> getList() {
        List<Nguoi> response = nguoiService.getAllList();
        return response;
    }

    @GetMapping("/api/khachhang/get_list")
    public List<KhachHang> getKhachHangList() {
        List<KhachHang> response = nguoiService.getAllSdtKhacHang();
        return response;
    }

    @DeleteMapping("/api/xoaKhachHang/{id}")
    public void xoaKhachhang(@PathVariable Long id){
        nguoiService.deleteKhachhang(id);
    }

    @PostMapping("/api/themKhachhang")
    public KhachHang themKhachhang(@RequestBody KhachHang khachHang){
        return nguoiService.createKhachHang(khachHang);
    }
    
    @GetMapping("/api/nhanvien/get_list")
    public List<NhanVien> getNhanVienList() {
        List<NhanVien> response = nguoiService.getAllnhanVien();
        return response;
    }

    @DeleteMapping("/api/xoaNhanVien/{id}")
    public void xoaNhanVien(@PathVariable Long id) {
        nguoiService.deleteNhanVien(id);
    }

    @PostMapping("/api/themNhanVien")
    public NhanVien createNhanVien(@RequestBody NhanVien nhanVien) {
        return nguoiService.createNhanVien(nhanVien);
    }

    @GetMapping("/api/hoadon/get_list")
    public List<HoaDon> getHoaDonList(){
        List<HoaDon> response = nguoiService.getAllhoaDon();
        return response;
    }


    @DeleteMapping("/api/xoaHoaDon/{id}")
    public void xoaHoaDon(@PathVariable Long id) {
        nguoiService.deleteHoaDon(id);
    }

    @PostMapping("/api/themHoaDon")
    public HoaDon themHoaDon(@RequestBody HoaDon hoaDon) {
        return nguoiService.createHoaDon(hoaDon);
    }

    @PutMapping("/suaHoaDon/{id}")
    public HoaDon updateHoaDon(@PathVariable Long id, @RequestBody HoaDon hoaDon) {
        return nguoiService.updateHoaDon(id, hoaDon);
    }


   @GetMapping("/api/hoadonsanpham/get_list")
    public List<HoaDonSanPham> getHoaDonSanPhamList(){
        List<HoaDonSanPham> response = nguoiService.getAllhoaDonSanpham();
        return response;
   }

   @GetMapping("/api/sanpham/get_list")
    public List<SanPham> getSanPhamList(){
        List<SanPham> response = nguoiService.getAllSanPham();
        return response;
   }

//   @GetMapping("/api/layHoaDon")
//    public List<KetQuaHoaDon> LayHoaDon(
//            @RequestParam(name = "id") Long id
//   ){
//        List<KetQuaHoaDon> response = nguoiService.LayHoaDon(id);
//        return response;
//   }

}






