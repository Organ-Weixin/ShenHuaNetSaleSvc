package com.boot.security.server.service;

import com.boot.security.server.model.Cinemamessage;

public interface CinemamessageService {
	Cinemamessage getByCinemaCodeAndMessageType(String CinemaCode,String MessageType);

}
