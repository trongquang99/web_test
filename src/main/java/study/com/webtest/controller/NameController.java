package study.com.webtest.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import study.com.webtest.dtos.request.*;
import study.com.webtest.dtos.response.*;
import study.com.webtest.model.HocSinh;
import study.com.webtest.service.HsService;
import study.com.webtest.service.NameService;


@RestController
public class NameController {
    // goi service
    private final NameService a;
    private final HsService hsService;

    public NameController(NameService nameService, HsService hsService) {
        this.a = nameService;
        this.hsService = hsService;
    }

    // viet api
    @GetMapping("/name/get")
    public String getName(  String tenInput){
        String ten = a.layTen(tenInput);
        return ten;
    }

    @PostMapping("/hocsinh/layThongTin")
    public HocSinh layThongTinHs(@RequestBody HsRequest request){
        HocSinh hs = hsService.layThongTin(request);
        return hs;
    }

    @GetMapping("/userId")
    public HocSinh getUser(@PathVariable String userId) {
        return new HocSinh("quang", 20, "haNam", "anNinh", "0953435");
    }

    @GetMapping("/web/logic")
    public UserResponse login(@RequestParam String username, String pass){

        UserResponse userResponse = a.checkLogin(username, pass);
        return userResponse;
    }
}
