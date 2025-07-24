package com.verlockt.tests.auth;



import com.verlockt.base.TestBase;
import com.verlockt.config.Endpoints;
import com.verlockt.data.TestDataProvider;
import com.verlockt.models.request.LoginRequest;
import com.verlockt.models.response.LoginResponse;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@Epic("Authentication")
@Feature("Login")
public class LoginTest extends TestBase {

    @Test
    @Story("User logs in with valid credentials")
    @DisplayName("Successful Login with Valid Credentials")
    @Description("Should return access token when correct email and password are provided.")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginWithValidCredentials() {
        LoginRequest requestBody = TestDataProvider.validUser();

        Response response = given()
                .spec(request)
                .body(requestBody)
                .when()
                .post(Endpoints.LOGIN);

        logResponse(response);
        assertEquals(200, response.statusCode());

        LoginResponse loginResponse = response.as(LoginResponse.class);
        assertTrue(loginResponse.isSuccess());
        assertNotNull(loginResponse.getData().getAccessToken());
    }

    @Test
    @Story("User enters wrong password")
    @DisplayName("Login Fails with Incorrect Password")
    @Description("Should return 401 when wrong password is used.")
    @Severity(SeverityLevel.NORMAL)
    public void testLoginWithIncorrectPassword() {
        LoginRequest requestBody = TestDataProvider.wrongPassword();

        Response response = given()
                .spec(request)
                .body(requestBody)
                .when()
                .post(Endpoints.LOGIN);

        logResponse(response);
        assertEquals(401, response.statusCode());
    }

    @Test
    @Story("User tries to log in with unregistered email")
    @DisplayName("Login Fails with Non-existent Email")
    @Description("Should return 401 when email is not in the system.")
    @Severity(SeverityLevel.NORMAL)
    public void testLoginWithNonExistentEmail() {
        LoginRequest requestBody = TestDataProvider.nonExistentUser();

        Response response = given()
                .spec(request)
                .body(requestBody)
                .when()
                .post(Endpoints.LOGIN);

        logResponse(response);
        assertEquals(401, response.statusCode());
    }

    @Test
    @Story("User submits empty email")
    @DisplayName("Login Fails with Empty Email")
    @Description("Should return 400 for empty email field.")
    @Severity(SeverityLevel.MINOR)
    public void testLoginWithEmptyEmail() {
        LoginRequest requestBody = TestDataProvider.emptyEmail();

        Response response = given()
                .spec(request)
                .body(requestBody)
                .when()
                .post(Endpoints.LOGIN);

        logResponse(response);
        assertEquals(400, response.statusCode());
    }

    @Test
    @Story("User submits empty password")
    @DisplayName("Login Fails with Empty Password")
    @Description("Should return 400 for empty password field.")
    @Severity(SeverityLevel.MINOR)
    public void testLoginWithEmptyPassword() {
        LoginRequest requestBody = TestDataProvider.emptyPassword();

        Response response = given()
                .spec(request)
                .body(requestBody)
                .when()
                .post(Endpoints.LOGIN);

        logResponse(response);
        assertEquals(400, response.statusCode());
    }

    @Test
    @Story("User sends invalid/malformed request payload")
    @DisplayName("Login Fails with Malformed JSON")
    @Description("Should return 400 for structurally invalid JSON request.")
    @Severity(SeverityLevel.MINOR)
    public void testLoginWithMalformedPayload() {
        String malformed = TestDataProvider.malformedJson();

        Response response = given()
                .spec(request)
                .body(malformed)
                .when()
                .post(Endpoints.LOGIN);

        logResponse(response);
        assertEquals(400, response.statusCode());
    }
}
