package com.boot.security.server.api.ctms.reply;

import java.util.List;

import com.boot.security.server.model.Filminfo;

public class CTMSQueryFilmReply extends CTMSBaseReply {
	private List<Filminfo> Films;

	public List<Filminfo> getFilms() {
		return Films;
	}

	public void setFilms(List<Filminfo> films) {
		Films = films;
	}
}
