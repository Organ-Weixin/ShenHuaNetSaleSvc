package com.boot.security.server.service;


import com.boot.security.server.model.Userinfo;

public interface UserInfoService {
	Userinfo getByUserCredential(String username,String password);
}
