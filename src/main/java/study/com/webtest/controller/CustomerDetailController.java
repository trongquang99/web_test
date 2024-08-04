package study.com.webtest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import study.com.webtest.dtos.response.BillDetailNewResponse;
import study.com.webtest.dtos.response.CustomerDetailResponse;
import study.com.webtest.service.CustomerDetailService;

import java.util.List;

@RestController
public class CustomerDetailController {
    private final CustomerDetailService customerDetailService;

    public CustomerDetailController(CustomerDetailService customerDetailService) {
        this.customerDetailService = customerDetailService;
    }

    @GetMapping("api/get_customerdetail")
    public List<CustomerDetailResponse> getListCustomerDetail(){
        List<CustomerDetailResponse> response = customerDetailService.getListCustomerDetail();
        return response;
    }

    @PostMapping("api/hoaDonChiTietMoi/{id}")
    public BillDetailNewResponse getBillDetailNew(@PathVariable(name = "id") Long id){
        BillDetailNewResponse response = customerDetailService.getBillDetailNew(id);
        return response;
    }
}
