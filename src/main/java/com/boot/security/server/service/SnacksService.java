package com.boot.security.server.service;

import java.util.List;

import com.boot.security.server.model.Snacks;

public interface SnacksService {
	List<Snacks> getByCinemaCode(String cinemacode);
}
