package com.boot.security.server.service;

import java.util.List;

import com.boot.security.server.dto.RoleDto;
import com.boot.security.server.model.Role;

public interface RoleService {
	
	void saveRole(RoleDto roleDto);

	void deleteRole(Long id);
}
