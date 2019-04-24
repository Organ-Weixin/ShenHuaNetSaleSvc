package com.boot.security.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.security.server.dao.UserinfoDao;
import com.boot.security.server.model.Userinfo;
import com.boot.security.server.page.table.PageTableHandler;
import com.boot.security.server.page.table.PageTableRequest;
import com.boot.security.server.page.table.PageTableResponse;
import com.boot.security.server.page.table.PageTableHandler.CountHandler;
import com.boot.security.server.page.table.PageTableHandler.ListHandler;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * 接入商管理
 * @author sheng
 *
 */
@Api(tags = "接入商")
@RestController
@RequestMapping("/userInfo")
public class UserinfoController {

	@Autowired
	private UserinfoDao userinfoDao;
	
	@GetMapping
	@PreAuthorize("hasAuthority('sys:userinfo:query')")
	@ApiOperation(value="获取接入商列表")
	public PageTableResponse list(PageTableRequest request) {
		
		return new PageTableHandler(new CountHandler() {

			@Override
			public int count(PageTableRequest request) {
				return userinfoDao.count(request.getParams());
			}
		}, new ListHandler() {

			@Override
			public List<Userinfo> list(PageTableRequest request) {
				return userinfoDao.list(request.getParams(), request.getOffset(), request.getLimit());
			}
		}).handle(request);
	}
	
	@GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
	@PreAuthorize("hasAuthority('sys:user:query')")
    public Userinfo getUserInfo(@PathVariable Long id) {
		Userinfo userinfo=userinfoDao.getById(id);
		
        return userinfo;
    }
	
	@PutMapping
    @ApiOperation(value = "修改")
	@PreAuthorize("hasAuthority('sys:userinfo:add')")
    public Userinfo updateUserInfo(@RequestBody Userinfo userinfo) {
        userinfoDao.update(userinfo);
        
        return userinfo;
    }
	
	@PostMapping
    @ApiOperation(value = "新增")
	@PreAuthorize("hasAuthority('sys:userinfo:add')")
    public Userinfo addUserInfo(@RequestBody Userinfo userinfo) {
        String userName = userinfo.getUserName();
        Userinfo u = userinfoDao.selcectByUserName(userName);
        if(u != null){
        	throw new IllegalArgumentException(userName + "已存在");
        }
		userinfoDao.save(userinfo);
        
        return userinfo;
    }
	
	@DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
	@PreAuthorize("hasAuthority('sys:userinfo:delete')")
    public void deleteUserInfo(@PathVariable Long id) {
		userinfoDao.delete(id);
        
    }
}
