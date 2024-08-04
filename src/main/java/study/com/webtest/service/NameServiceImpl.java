package study.com.webtest.service;

import org.springframework.stereotype.Service;
import study.com.webtest.dtos.response.UserResponse;
import study.com.webtest.repository.NameRepository;

@Service
public class NameServiceImpl implements NameRepository {
    @Override
    public String getName(String name) {
        return name + " hehe";
    }

    @Override
    public UserResponse checkLogin(String username, String pass) {
        UserResponse userResponse = new UserResponse();

        // Tìm trong DB có cặp username và pass
        UserResponse userDB = new UserResponse();

        if (userDB != null){
            // Có
            userResponse.setUserName(userDB.getUserName());
            userResponse.setPassword(userDB.getPassword());
            userResponse.setToken(userDB.getToken());
            userResponse.setStatus("Thanh cong");
        }else {
            // Không có
            userResponse.setStatus("That bai");
        }
        return userResponse;
    }
}
