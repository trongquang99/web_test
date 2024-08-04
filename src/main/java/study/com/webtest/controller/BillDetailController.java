package study.com.webtest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.com.webtest.dtos.response.BillDetailResponseV2;
import study.com.webtest.dtos.response.base.BaseResponse;
import study.com.webtest.dtos.response.base.ResponseBuilder;
import study.com.webtest.service.BillServiceV2;

import java.util.List;

@RestController
public class BillDetailController {
    private final BillServiceV2 billServiceV2;

    public BillDetailController(BillServiceV2 billServiceV2) {
        this.billServiceV2 = billServiceV2;
    }

    @GetMapping("api/bill_details")
    public ResponseEntity<BaseResponse<List<BillDetailResponseV2>>> getBillDetailListV2(){
        List<BillDetailResponseV2> response = billServiceV2.getBillDetail();
        return ResponseEntity.ok(ResponseBuilder.successList(response));
    }
}
