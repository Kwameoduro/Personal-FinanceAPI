package com.verlockt.tests.auth;

import com.verlockt.base.TestBase;
import com.verlockt.config.Endpoints;
import com.verlockt.models.request.LoginRequest;
import com.verlockt.models.request.LogoutRequest;
import com.verlockt.models.response.LoginResponse;
import com.verlockt.models.response.LogoutResponse;
import com.verlockt.data.TestDataProvider;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@Epic("Authentication")
@Feature("Logout")
public class LogoutTest extends TestBase {

    @Test
    @Story("User logs out")
    @DisplayName("Logout with Valid Refresh Token")
    @Description("Verifies that a logged-in user can log out using their refresh token.")
    @Severity(SeverityLevel.CRITICAL)
    public void testLogoutWithValidRefreshToken() {
        // Step 1: Login to get a valid refresh token
        LoginRequest loginBody = TestDataProvider.validUserLogin();
        Response loginResponse = given()
                .spec(request)
                .body(loginBody)
                .when()
                .post(Endpoints.LOGIN);

        logResponse(loginResponse);

        assertEquals(200, loginResponse.statusCode());

        LoginResponse loginData = loginResponse.as(LoginResponse.class);
        String refreshToken = loginData.getData().getRefreshToken();
        assertNotNull(refreshToken);

        // Step 2: Logout using that refresh token
        LogoutRequest logoutBody = new LogoutRequest(refreshToken);

        Response logoutResponse = given()
                .spec(request)
                .body(logoutBody)
                .when()
                .post(Endpoints.LOGOUT);

        logResponse(logoutResponse);

        assertEquals(200, logoutResponse.statusCode());

        LogoutResponse result = logoutResponse.as(LogoutResponse.class);
        assertTrue(result.isSuccess());
        assertNotNull(result.getMessage());
    }
}
