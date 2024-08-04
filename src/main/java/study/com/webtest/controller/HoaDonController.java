package study.com.webtest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;
import study.com.webtest.dtos.response.BillDetailResponse;
import study.com.webtest.dtos.response.base.BaseResponse;
import study.com.webtest.dtos.response.base.ResponseBuilder;
import study.com.webtest.model.HoaDon;
import study.com.webtest.model.HoaDonSanPham;
import study.com.webtest.service.BillService;

import java.util.List;

@RestController
@Slf4j
public class HoaDonController {
    private final BillService billService;

    public HoaDonController(BillService billService) {
        this.billService = billService;
    }

    @GetMapping("/api/v1/get_bill_detail/{id}")
    public BillDetailResponse getBillDetail(@PathVariable(name = "id") Long id){
        BillDetailResponse response = billService.getBillDetailById(id);
        return response;
    }

//    @GetMapping("/api/get_bill_detail2")
//        public ResponseEntity<BaseResponse<List<BillDetailResponse>>> getBillDetailList(){
//        try {
//            List<BillDetailResponse> response = billService.getBillDetailList();
//            return ResponseEntity.ok(ResponseBuilder.successList(response));
//        }catch (Exception exception){
//            log.error("Đã có lỗi xảy ra", exception);
//            return ResponseEntity.badRequest().body(ResponseBuilder.error(400, "Dữ liệu bị lỗi xin cảm ơn!"));
//        }
//    }

    @GetMapping("api/get_bill_detail2")
    public ResponseEntity<BaseResponse<List<BillDetailResponse>>> getBillDetailList(){
        try{
            List<BillDetailResponse> response = billService.getBillDetailList();
            return ResponseEntity.ok(ResponseBuilder.successList(response));
        }catch(Exception ex) {
            //ignore
            return null;
        }
    }


    @GetMapping("/api/hoaDon/count")
    public ResponseEntity<BaseResponse<Integer>> getHoaDonCount(){
        Integer response = billService.getHoaDonCount();
        return ResponseEntity.ok(ResponseBuilder.success(response));
    }
}
