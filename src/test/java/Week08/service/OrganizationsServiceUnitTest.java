package Week08.service;

import Week08.model.Organization;
import Week08.model.User;
import Week08.repository.OrganizationsRepository;
import Week08.service.exception.RequiredFieldMissedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class OrganizationsServiceUnitTest {

    private static final String TEST_USER_ID = "test";
    private static final String TEST_USER_FIRST_NAME = "test";
    private static final String TEST_USER_LAST_NAME = "test";
    private static final String TEST_USER_MIDDLE_NAME = "test";
    private static final String TEST_USER_PHONE = "test";
    private static final User TEST_USER = new User(
            TEST_USER_ID,
            TEST_USER_FIRST_NAME,
            TEST_USER_LAST_NAME,
            TEST_USER_MIDDLE_NAME,
            TEST_USER_PHONE);
    private static final String TEST_ORG_TEST_ORG_ID = "test";
    private static final String TEST_ORG_NAME = "test";
    private static final String TEST_ORG_IMAGE = "test";
    private static final String TEST_ORG_DIRECTOR = "test";
    private static final String TEST_ORG_INN = "test";
    private static final String TEST_ORG_OGRN = "test";
    private static final String TEST_ORG_KPP = "test";
    private static final String TEST_ORG_OKVED = "test";
    private static final String TEST_ORG_OKPO = "test";
    private static final String TEST_ORG_BANK = "test";
    private static final String TEST_ORG_BIK = "test";
    private static final String TEST_ORG_PHONE = "test";
    private static final String TEST_ORG_EMAIL = "test";
    private static final Integer EMPLOYEES_COUNT = 1;
    private static final String TEST_ORG_ADDRESS = "test";
    private static final LocalDateTime TEST_ORG_CREATION_DATE = LocalDateTime.now();
    private static final LocalDateTime TEST_ORG_UPDATE_DATE = LocalDateTime.now();
    private static final String TEST_ORG_DESCRIPTION = "test";
    private static final Organization TEST_ORG = new Organization(
            TEST_ORG_TEST_ORG_ID,
            TEST_ORG_NAME,
            TEST_ORG_IMAGE,
            TEST_USER,
            TEST_ORG_DIRECTOR,
            TEST_ORG_INN,
            TEST_ORG_OGRN,
            TEST_ORG_KPP,
            TEST_ORG_OKVED,
            TEST_ORG_OKPO,
            TEST_ORG_BANK,
            TEST_ORG_BIK,
            TEST_ORG_PHONE,
            TEST_ORG_EMAIL,
            EMPLOYEES_COUNT,
            TEST_ORG_ADDRESS,
            TEST_ORG_CREATION_DATE,
            TEST_ORG_UPDATE_DATE,
            TEST_ORG_DESCRIPTION);

    @Autowired
    private OrganizationsService organizationsService;

    @MockBean
    private OrganizationsRepository organizationsRepository;

    @Test
    void shouldCreateOrganization() {
        Organization organization = new Organization(
                any(),
                TEST_ORG_NAME,
                TEST_ORG_IMAGE,
                TEST_USER,
                TEST_ORG_DIRECTOR,
                TEST_ORG_INN,
                TEST_ORG_OGRN,
                TEST_ORG_KPP,
                TEST_ORG_OKVED,
                TEST_ORG_OKPO,
                TEST_ORG_BANK,
                TEST_ORG_BIK,
                TEST_ORG_PHONE,
                TEST_ORG_EMAIL,
                EMPLOYEES_COUNT,
                TEST_ORG_ADDRESS,
                TEST_ORG_CREATION_DATE,
                TEST_ORG_UPDATE_DATE,
                TEST_ORG_DESCRIPTION
        );
        Mockito.when(organizationsService.create(organization)).thenReturn(TEST_ORG);
        Assertions.assertEquals(TEST_ORG, organizationsService.create(TEST_ORG));
    }

    @Test
    void shouldNotCreateOrganizationWithoutName() {
        Organization organization = new Organization(
                null,
                null,
                TEST_ORG_IMAGE,
                TEST_USER,
                TEST_ORG_DIRECTOR,
                TEST_ORG_INN,
                TEST_ORG_OGRN,
                TEST_ORG_KPP,
                TEST_ORG_OKVED,
                TEST_ORG_OKPO,
                TEST_ORG_BANK,
                TEST_ORG_BIK,
                TEST_ORG_PHONE,
                TEST_ORG_EMAIL,
                EMPLOYEES_COUNT,
                TEST_ORG_ADDRESS,
                TEST_ORG_CREATION_DATE,
                TEST_ORG_UPDATE_DATE,
                TEST_ORG_DESCRIPTION
        );
        Assertions.assertThrows(RequiredFieldMissedException.class, () -> organizationsService.create(organization));
    }

    @Test
    void shouldNotCreateOrganizationWithoutInn() {
        Organization organization = new Organization(
                null,
                TEST_ORG_NAME,
                TEST_ORG_IMAGE,
                TEST_USER,
                TEST_ORG_DIRECTOR,
                null,
                TEST_ORG_OGRN,
                TEST_ORG_KPP,
                TEST_ORG_OKVED,
                TEST_ORG_OKPO,
                TEST_ORG_BANK,
                TEST_ORG_BIK,
                TEST_ORG_PHONE,
                TEST_ORG_EMAIL,
                EMPLOYEES_COUNT,
                TEST_ORG_ADDRESS,
                TEST_ORG_CREATION_DATE,
                TEST_ORG_UPDATE_DATE,
                TEST_ORG_DESCRIPTION
        );
        Assertions.assertThrows(RequiredFieldMissedException.class, () -> organizationsService.create(organization));
    }

        @Test
        void shouldCreateOrganizationWithoutOptionalFields() {
            Organization organization = new Organization(
                    null,
                    TEST_ORG_NAME,
                    null,
                    null,
                    null,
                    TEST_ORG_INN,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null
            );
            Assertions.assertDoesNotThrow(() -> organizationsService.create(organization));
        }
}