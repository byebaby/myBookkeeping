package com.example.demo.mapper.dto;

public class UserDto {
    private final String username;   // 登录名，不可改
    private final String nick;    // 用户昵称，可改

    public UserDto(String username, String nick) {
        this.username = username;
        this.nick = nick;
    }

    public String getUsername() {
        return username;
    }


    public String getNick() {
        return nick;
    }


}
