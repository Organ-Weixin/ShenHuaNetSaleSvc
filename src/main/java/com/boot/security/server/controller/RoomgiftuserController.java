package com.boot.security.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.security.server.page.table.PageTableRequest;
import com.boot.security.server.page.table.PageTableHandler;
import com.boot.security.server.page.table.PageTableResponse;
import com.boot.security.server.utils.UserUtil;
import com.boot.security.server.page.table.PageTableHandler.CountHandler;
import com.boot.security.server.page.table.PageTableHandler.ListHandler;
import com.boot.security.server.dao.RoomgiftuserDao;
import com.boot.security.server.model.Roomgiftuser;
import com.boot.security.server.model.SysUser;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/roomgiftusers")
public class RoomgiftuserController {

    @Autowired
    private RoomgiftuserDao roomgiftuserDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public Roomgiftuser save(@RequestBody Roomgiftuser roomgiftuser) {
        roomgiftuserDao.save(roomgiftuser);

        return roomgiftuser;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Roomgiftuser get(@PathVariable Long id) {
        return roomgiftuserDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Roomgiftuser update(@RequestBody Roomgiftuser roomgiftuser) {
        roomgiftuserDao.update(roomgiftuser);

        return roomgiftuser;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
    	//获取当前登陆人信息
    	SysUser sysuser = UserUtil.getLoginUser();
    	request.getParams().put("id", sysuser.getId());
    	request.getParams().put("roleId", sysuser.getRoleId());
    	
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return roomgiftuserDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Roomgiftuser> list(PageTableRequest request) {
                return roomgiftuserDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        roomgiftuserDao.delete(id);
    }
}
