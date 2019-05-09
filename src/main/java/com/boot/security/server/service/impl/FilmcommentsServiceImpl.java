package com.boot.security.server.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.FilmcommentsDao;
import com.boot.security.server.model.Filmcomments;
import com.boot.security.server.service.FilmcommentsService;

@Service
public class FilmcommentsServiceImpl implements FilmcommentsService{
	private static final Logger log = LoggerFactory.getLogger("adminLogger");
	@Autowired
	private FilmcommentsDao filmcommentsDao;
	
	@Override
	public Filmcomments getById(Long id) {
		return filmcommentsDao.getById(id);
	}

	@Override
	public int delete(Long id) {
		return filmcommentsDao.delete(id);
	}

	@Override
	public int update(Filmcomments filmcomments) {
		return filmcommentsDao.update(filmcomments);
	}

	@Override
	public int save(Filmcomments filmcomments) {
		return filmcommentsDao.save(filmcomments);
	}

	@Override
	public int count(Map<String, Object> params) {
		return filmcommentsDao.count(params);
	}

	@Override
	public List<Filmcomments> list(Map<String, Object> params, Integer offset, Integer limit) {
		return filmcommentsDao.list(params, offset, limit);
	}

	@Override
	public List<Filmcomments> getByFilmCode(String filmcode) {
		return filmcommentsDao.getByFilmCode(filmcode);
	}

	@Override
	public Filmcomments getByOpenId(String openid) {
		return filmcommentsDao.getByOpenId(openid);
	}

}
