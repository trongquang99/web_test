package study.com.webtest.repository;

import org.springframework.stereotype.Service;
import study.com.webtest.dtos.request.CuaHangRequest;
import study.com.webtest.dtos.response.HoaDonChiTietResponse;
import study.com.webtest.dtos.response.KetQuaHoaDon;
import study.com.webtest.model.*;

import java.util.List;

@Service
public interface NguoiService{

//    public KetQuaCaNhan thongTin(ThongTinCaNhan nguoi){
//        return nguoiS.checkThongtin(nguoi);
//    }
//
//    public String nguoiA(ThongTinCaNhan nguoi){
//        return nguoiS.thongTinA(nguoi);
//    }
//
//    public String nguoiB(String ten, String ngaySinh, String diaChi, String sdt, Integer tuoi){
//        return nguoiS.thongTinB(ten, ngaySinh, diaChi, sdt, tuoi);
//    }
//
//    public KetQuaCaNhan nguoiC(String ten,  Integer tuoi){
//        return nguoiS.thongTinC(ten, tuoi);
//    }


    List<CuaHang> getAllcuaHang();

    void deleteCuaHang(Long id) ;

    CuaHang createCuaHang(CuaHangRequest cuaHangRequest);

    CuaHang updateCuaHang(Long id, CuaHang cuaHang);

    List<Nguoi> getAllList();

    List<KhachHang> getAllSdtKhacHang();

    void deleteKhachhang(Long id);

    KhachHang createKhachHang(KhachHang khachHang);

    List<NhanVien> getAllnhanVien();

    void deleteNhanVien(Long id);

    NhanVien createNhanVien(NhanVien nhanVien);

    List<HoaDon> getAllhoaDon();

    void deleteHoaDon(Long id);

    HoaDon createHoaDon(HoaDon hoaDon);

    HoaDon updateHoaDon(Long id, HoaDon hoaDon);

    List<HoaDonSanPham> getAllhoaDonSanpham();

    List<SanPham> getAllSanPham();

//    List<KetQuaHoaDon> LayHoaDon(Long id);

    CuaHang capNhatCuaHang(Long id, CuaHangRequest cuaHangRequest);

    CuaHang createCuaHangA(CuaHang cuaHang);

}
