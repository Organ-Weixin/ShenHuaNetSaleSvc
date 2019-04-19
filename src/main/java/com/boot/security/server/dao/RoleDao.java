package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.boot.security.server.model.Role;

@Mapper
public interface RoleDao {

	@Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into sys_role(name, type, createUserId, description, createTime, updateTime, deleted) values(#{name}, #{type}, #{createUserId}, #{description}, now(), now(), 0)")
	int save(Role role);

	int count(@Param("params") Map<String, Object> params);

	List<Role> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset,
			@Param("limit") Integer limit);
	
	@Select("select ss.* from sys_role ss, (select id from sys_role where id = #{roleId}) s where (ss.createUserId = s.id or ss.id = s.id)")
	List<Role> getRoleById(Long roleId);
	
	@Select("select * from sys_role")
	List<Role> getAllRole();

	@Select("select * from sys_role t where t.id = #{id}")
	Role getById(Long id);

	@Select("select * from sys_role t where t.name = #{name}")
	Role getRole(String name);

	@Update("update sys_role t set t.name = #{name}, t.type = #{type}, t.description = #{description}, updateTime = now() where t.id = #{id}")
	int update(Role role);

	@Select("select * from sys_role r inner join sys_role_user ru on r.id = ru.roleId where ru.userId = #{userId}")
	List<Role> listByUserId(Long userId);

	@Delete("delete from sys_role_permission where roleId = #{roleId}")
	int deleteRolePermission(Long roleId);

	int saveRolePermission(@Param("roleId") Long roleId, @Param("permissionIds") List<Long> permissionIds);

	@Delete("delete from sys_role where id = #{id}")
	int delete(Long id);

	@Delete("delete from sys_role_user where roleId = #{roleId}")
	int deleteRoleUser(Long roleId);

}
