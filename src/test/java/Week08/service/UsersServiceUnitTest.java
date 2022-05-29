package Week08.service;

import Week08.model.User;
import Week08.repository.UsersRepository;
import Week08.service.exception.RequiredFieldMissedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class UsersServiceUnitTest {
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

    @MockBean
    private UsersRepository usersRepository;

    @Test
    void shouldCreateUser() {
        User user = new User(
                any(),
                TEST_USER_FIRST_NAME,
                TEST_USER_LAST_NAME,
                TEST_USER_MIDDLE_NAME,
                TEST_USER_PHONE
        );
        Mockito.when(usersService.create(user)).thenReturn(TEST_USER);
        Assertions.assertEquals(TEST_USER, usersService.create(TEST_USER));
    }

    @Test
    void shouldNotCreateUserWithoutFirstName() {
        User user = new User(
                null,
                null,
                TEST_USER_LAST_NAME,
                TEST_USER_MIDDLE_NAME,
                TEST_USER_PHONE
        );
        Assertions.assertThrows(RequiredFieldMissedException.class, () -> usersService.create(user));
    }

    @Test
    void shouldNotCreateUserWithoutLastName() {
        User user = new User(
                null,
                TEST_USER_FIRST_NAME,
                null,
                TEST_USER_MIDDLE_NAME,
                TEST_USER_PHONE
        );
        Assertions.assertThrows(RequiredFieldMissedException.class, () -> usersService.create(user));
    }

    @Test
    void shouldCreateUserWithoutOptionalFields() {
        User user = new User(
                null,
                TEST_USER_FIRST_NAME,
                TEST_USER_LAST_NAME,
                null,
                null
        );
        Assertions.assertDoesNotThrow(() -> usersService.create(user));
    }

    @Test
    void shouldNotEqualWithUser() {
        User user = new User(
                null,
                TEST_USER_FIRST_NAME,
                TEST_USER_LAST_NAME,
                TEST_USER_MIDDLE_NAME,
                TEST_USER_PHONE
        );
        Assertions.assertNotEquals(TEST_USER, user);
    }

    @Test
    void shouldNotEqualWithUserHashCode() {
        User user = new User(
                null,
                TEST_USER_FIRST_NAME,
                TEST_USER_LAST_NAME,
                TEST_USER_MIDDLE_NAME,
                TEST_USER_PHONE
        );
        Assertions.assertEquals(TEST_USER.hashCode(), user.hashCode());
    }

    @Test
    void shouldNotEqualWithNewUser() {
        User user = new User(
                UUID.randomUUID().toString(),
                TEST_USER_FIRST_NAME,
                TEST_USER_LAST_NAME,
                TEST_USER_MIDDLE_NAME,
                TEST_USER_PHONE
        );
        Assertions.assertNotEquals(TEST_USER, user);
    }
}
