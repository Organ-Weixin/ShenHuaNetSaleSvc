package com.boot.security.server.service;

import java.util.List;
import java.util.Map;



import com.boot.security.server.model.Filmcomments;

public interface FilmcommentsService {
	    Filmcomments getById(Long id);
	    List<Filmcomments> getByFilmCode(String filmcode);
	    
	    Filmcomments getByOpenId(String openid);

	    
	    int delete(Long id);

	    int update(Filmcomments filmcomments);
	    
	    int save(Filmcomments filmcomments);
	    
	    int count(Map<String, Object> params);

	    List<Filmcomments> list( Map<String, Object> params,  Integer offset,  Integer limit);

}
