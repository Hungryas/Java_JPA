package Week08.service;

import Week08.config.PostgreSQLContainerInitializer;
import Week08.model.User;
import Week08.repository.UsersRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(initializers = {PostgreSQLContainerInitializer.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UsersServiceIntegrationTest {
    private static final String TEST_USER_ID = "test";
    private static final String TEST_USER_FIRST_NAME = "test";
    private static final String TEST_USER_LAST_NAME = "test";
    private static final String TEST_USER_MIDDLE_NAME = "test";
    private static final String TEST_USER_PHONE = "test";
    private static final User TEST_USER = new User(TEST_USER_ID,
            TEST_USER_FIRST_NAME,
            TEST_USER_LAST_NAME,
            TEST_USER_MIDDLE_NAME,
            TEST_USER_PHONE);

    @Autowired
    private UsersService usersService;

    @Autowired
    private UsersRepository usersRepository;

    @Test
    void shouldCreateUser() {
        User user = new User(
                null,
                TEST_USER_FIRST_NAME,
                TEST_USER_LAST_NAME,
                TEST_USER_MIDDLE_NAME,
                TEST_USER_PHONE
        );
        user = usersService.create(user);
        Assertions.assertEquals(user, usersRepository.findById(user.getId())
                .orElseThrow(() -> new RuntimeException("User not found")));
    }
}
