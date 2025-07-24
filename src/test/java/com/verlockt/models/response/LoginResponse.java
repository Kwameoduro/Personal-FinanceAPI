package com.verlockt.models.response;


public class LoginResponse {

    private boolean success;
    private String message;
    private LoginData data;

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public LoginData getData() {
        return data;
    }

    public static class LoginData {
        private int id;
        private String accessToken;
        private String refreshToken;
        private String username;

        public int getId() {
            return id;
        }

        public String getAccessToken() {
            return accessToken;
        }

        public String getRefreshToken() {
            return refreshToken;
        }

        public String getUsername() {
            return username;
        }
    }
}
