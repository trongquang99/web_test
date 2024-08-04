package study.com.webtest.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import study.com.webtest.dtos.request.CuaHangRequest;
import study.com.webtest.model.*;
import study.com.webtest.repository.*;

import java.util.*;

@Service
@AllArgsConstructor
public class NguoiServiceImpl implements NguoiService{
    NgRepository ngRepository;
    CuaHangRepository cuaHangRepository;
    KhachHangRepository khachHangRepository;
    NhanVienRepository nhanVienRepository;
    HoaDonRepository hoaDonRepository;
    HoaDonSanPhamRepository hoaDonSanPhamRepository;
    SanPhamRepository sanPhamRepository;

    @Override
    public List<CuaHang> getAllcuaHang() {
        return cuaHangRepository.findAll();
    }

//    public CuaHang createCuaHang(CuaHangRequest cuaHangRequest) {
//        return cuaHangRepository.save(cuaHangRequest);
//    }

    public CuaHang createCuaHangA(CuaHang cuaHang) {
        return cuaHangRepository.save(cuaHang);
    }

    @Override

    public CuaHang createCuaHang(CuaHangRequest cuaHangRequest) {

        CuaHang newCuaHang = new CuaHang();

        if (Objects.nonNull(cuaHangRequest.getTen())) {
            newCuaHang.setTen(cuaHangRequest.getTen());
        }
        if (Objects.nonNull(cuaHangRequest.getDiChi())) {
            newCuaHang.setDiChi(cuaHangRequest.getDiChi());
        }
        if (Objects.nonNull(cuaHangRequest.getSdt())) {
            newCuaHang.setSdt(cuaHangRequest.getSdt());
        }
        if (Objects.nonNull(cuaHangRequest.getEmail())) {
            newCuaHang.setEmail(cuaHangRequest.getEmail());
        }

        return cuaHangRepository.save(newCuaHang);
    }



    public CuaHang updateCuaHang(Long id, CuaHang cuaHang){
        Optional<CuaHang> optionalCuaHang = cuaHangRepository.findById(id);

        if (optionalCuaHang.isPresent()) {

            CuaHang existingCuaHang = optionalCuaHang.get();

            existingCuaHang.setTen(cuaHang.getTen());
            existingCuaHang.setDiChi(cuaHang.getDiChi());
            existingCuaHang.setSdt(cuaHang.getSdt());
            existingCuaHang.setEmail(cuaHang.getEmail());

            return cuaHangRepository.save(existingCuaHang);
        } else {
            throw new RuntimeException("CuaHang not found with id " + id);
        }
    }


    public CuaHang capNhatCuaHang(Long id, CuaHangRequest cuaHangRequest){
        Optional<CuaHang> optionalCuaHang = cuaHangRepository.findById(id);
        CuaHang existingCuaHang;
        if (optionalCuaHang.isPresent()) {
            existingCuaHang = optionalCuaHang.get();
            if (Objects.nonNull((cuaHangRequest.getTen()))){
                existingCuaHang.setTen(cuaHangRequest.getTen());
            }
            if (Objects.nonNull((cuaHangRequest.getDiChi()))){
                existingCuaHang.setDiChi(cuaHangRequest.getDiChi());
            }
            if (Objects.nonNull((cuaHangRequest.getSdt()))){
                existingCuaHang.setSdt(cuaHangRequest.getSdt());
            }

            if (Objects.nonNull((cuaHangRequest.getEmail()))){
                existingCuaHang.setEmail(cuaHangRequest.getEmail());
            }
            return cuaHangRepository.save(existingCuaHang);
        }
        return null;
    }


    @Override
    public void deleteCuaHang(Long id) {
        cuaHangRepository.deleteById(id);
    }

    @Override
    public List<Nguoi> getAllList() {
//        return ngRepository.getListNguoi(1L);
        return ngRepository.findAll();
    }

    @Override
    public List<KhachHang> getAllSdtKhacHang() {
        return khachHangRepository.getListSdtKhachHang("0888888888");
    }

    @Override
    public void deleteKhachhang(Long id) {
        khachHangRepository.deleteById(id);
    }

    @Override
    public KhachHang createKhachHang(KhachHang khachHang) {
        return khachHangRepository.save(khachHang);
    }

    @Override
    public List<NhanVien> getAllnhanVien() {
        return nhanVienRepository.findAll();
    }

    public NhanVien createNhanVien(NhanVien nhanVien) {
        return nhanVienRepository.save(nhanVien);
    }

    @Override
    public List<HoaDon> getAllhoaDon() {
        return hoaDonRepository.findAll();
    }



    public void deleteHoaDon(Long id) {
        hoaDonRepository.deleteById(id);
    }

    public HoaDon createHoaDon(HoaDon hoaDon) {
        return hoaDonRepository.save(hoaDon);
    }

    public HoaDon updateHoaDon(Long id, HoaDon hoaDon){
        Optional<HoaDon> optionalHoaDon = hoaDonRepository.findById(id);

        if (optionalHoaDon.isPresent()) {

            HoaDon existingHoaDon = optionalHoaDon.get();

            existingHoaDon.setIdKh(hoaDon.getIdKh());
            existingHoaDon.setIdNv(hoaDon.getIdNv());
            existingHoaDon.setTongGia(hoaDon.getTongGia());
            existingHoaDon.setNgayThanhToan(hoaDon.getNgayThanhToan());

            return hoaDonRepository.save(existingHoaDon);
        } else {
            throw new RuntimeException("HoaDon not found with id " + id);
        }
    }

    @Override
    public List<HoaDonSanPham> getAllhoaDonSanpham() {
        return hoaDonSanPhamRepository.findAll();
    }


    @Override
    public List<SanPham> getAllSanPham() {
        return sanPhamRepository.getGiatSanPham();
    }

//    @Override
//    public List<KetQuaHoaDon> LayHoaDon(Long id) {
//        return hoaDonRepository.layHoaDon(id);
//    }


    @Override
    public void deleteNhanVien(Long id) {
        nhanVienRepository.deleteById(id);
    }
//    public KetQuaCaNhan checkThongtin(ThongTinCaNhan nguoi) {
//        if (nguoi.getTuoi() < 10) {
//            String Ketqua;
//            Ketqua = nguoi.getTen() + " tre con " + nguoi.getTuoi();
//            return new KetQuaCaNhan(Ketqua);
//        } else if (nguoi.getTuoi() >= 10 && nguoi.getTuoi() < 50) {
//            return new KetQuaCaNhan(nguoi.getTen() + " trung nien " + nguoi.getTuoi());
//        } else {
//            return new KetQuaCaNhan(nguoi.getTen() + " gia " + nguoi.getTuoi());
//        }
//    }
//
//    public String thongTinA(ThongTinCaNhan nguoi){
//        if (nguoi.getTuoi() < 10) {
//            return nguoi.getTen() + "tre con" + nguoi.getTuoi();
//        } else if (nguoi.getTuoi() >= 10 && nguoi.getTuoi() < 50) {
//            return nguoi.getTen() + " trung nien " + nguoi.getTuoi();
//        } else {
//            return nguoi.getTen() + " gia " + nguoi.getTuoi();
//        }
//    }
//
//    public String thongTinB(String ten, String ngaySinh, String diaChi, String sdt, Integer tuoi){
//        if (ten == null || tuoi == null) return "lỗi input rồi";
//        if (tuoi < 10) {
//            return ten + "tre con" + tuoi;
//        } else if (tuoi >= 10 && tuoi < 50) {
//            return ten + " trung nien " + tuoi;
//        } else {
//            return ten + " gia " + tuoi;
//        }
//    }
//
//    public KetQuaCaNhan thongTinC(String ten, Integer tuoi) {
//        if (tuoi < 10) {
//            String ketqua;
//            ketqua = ten + " tre con " + tuoi;
//            return new KetQuaCaNhan(ketqua);
//        } else if (tuoi >= 10 && tuoi < 50) {
//            return new KetQuaCaNhan(ten + " trung nien " + tuoi);
//        } else {
//            return new KetQuaCaNhan(ten + " gia " + tuoi);
//        }
//    }

//
//    public List<CuaHang> getAllcuaHang(){
//        return cuaHangRepository.findAll();
//    }
//
//    public void deleteCuaHang(Long id) {
//        cuaHangRepository.deleteById(id);
//    }
//
//    public List<Nguoi> getAllList() {
////        return ngRepository.getListNguoi(1L);
//        return ngRepository.findAll();
//    }
//
//
//    public List<KhachHang> getAllSdtKhacHang(){
//        return khachHangRepository.getListSdtKhachHang("0888888888");
//    }
//
//    public List<NhanVien> getAllnhanVien(){
//        return nhanVienRepository.findAll();
//    }
//
//
//    public List<HoaDon> getAllhoaDon(){
//        return hoaDonRepository.findAll();
//    }
//
//    public List<HoaDonSanPham> getAllhoaDonSanpham(){
//        return hoaDonSanPhamRepository.findAll();
//    }
//
//    public List<SanPham> getAllSanPham(){
//        return sanPhamRepository.getGiatSanPham();
//    }
//
//    public List<KetQuaHoaDon> layHoaDon(Long id){
////        return Collections.singletonList(hoaDonRepository.layHoaDon(id));
//        return hoaDonRepository.layHoaDon(id);
//    }
}
