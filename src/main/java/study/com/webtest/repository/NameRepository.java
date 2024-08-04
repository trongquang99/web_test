package study.com.webtest.repository;

import org.springframework.stereotype.Repository;
import study.com.webtest.dtos.response.UserResponse;

@Repository
public interface NameRepository {
    String getName(String name);

    UserResponse checkLogin(String username, String pass);
}
