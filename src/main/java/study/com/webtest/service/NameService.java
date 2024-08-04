package study.com.webtest.service;

import org.springframework.stereotype.Service;
import study.com.webtest.dtos.response.UserResponse;

@Service
public class NameService {
    private final BillServiceImpl billService;
    private final NameServiceImpl nameService;

    public NameService(BillServiceImpl billService, NameServiceImpl nameService) {
        this.billService = billService;
        this.nameService = nameService;
    }

    public String layTen(String ten){
        return nameService.getName(ten);
    }

    public UserResponse checkLogin(String username, String pass) {
//        String tmp = billService.abc;
        return nameService.checkLogin(username, pass);
    }

}
