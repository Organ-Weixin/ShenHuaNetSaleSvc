package com.boot.security.server.service;

import java.util.List;
import java.util.Map;
import com.boot.security.server.model.Activity;

public interface ActivityService {
    Activity getById(Long id);
    int delete(Long id);
    int update(Activity activity);
    int save(Activity activity);
    int count(Map<String, Object> params);
    List<Activity> list(Map<String, Object> params,Integer offset,Integer limit);
}
