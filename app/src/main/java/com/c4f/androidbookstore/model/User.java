package com.c4f.androidbookstore.model;

import org.json.JSONObject;

import okhttp3.RequestBody;

public class User {
    private String phone;
    private String displayName;
    private String avatar;
    private String token;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public static RequestBody signInRequestBody(String phone, String pass) {
        JSONObject data = new JSONObject();
        try {
            data.put("phone", phone);
            data.put("password", pass);
        } catch (Exception exp) {}

        return RequestBody.create(
                okhttp3.MediaType.parse(
                        "application/json; charset=utf-8"),
                data.toString());
    }
}
