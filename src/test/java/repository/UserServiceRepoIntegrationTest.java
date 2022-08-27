package repository;

import kls.auth.server.repository.UserServiceRepo;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
@AllArgsConstructor
class UserServiceRepoIntegrationTest {

    private final JdbcTemplate jdbcTemplate;

    private final UserServiceRepo userServiceRepo;

    @BeforeEach
    void beforeEach() {
        final String insertNewUserQuery = "";
//        jdbcTemplate.execute();
    }

    @Test
    void t1 () {
//        userServiceRepo.getFullUserInfoByUserName();
    }

    @AfterEach
    void afterEach() {

    }

}
