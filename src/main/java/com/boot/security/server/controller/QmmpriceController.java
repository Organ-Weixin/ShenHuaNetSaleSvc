package com.boot.security.server.controller;

import java.io.IOException;
import java.text.ParseException;
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
import com.boot.security.server.page.table.PageTableHandler.CountHandler;
import com.boot.security.server.page.table.PageTableHandler.ListHandler;
import com.boot.security.server.utils.QmmPriceUtil;
import com.boot.security.server.utils.UserUtil;
import com.google.gson.Gson;
import com.boot.security.server.dao.CinemaDao;
import com.boot.security.server.dao.QmmpriceDao;
import com.boot.security.server.model.Cinema;
import com.boot.security.server.model.Qmmprice;
import com.boot.security.server.model.SysUser;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/qmmprices")
public class QmmpriceController {

    @Autowired
    private QmmpriceDao qmmpriceDao;
    @Autowired
    private CinemaDao cinemaDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public Qmmprice save(@RequestBody Qmmprice qmmprice) {
    	System.out.println("------"+new Gson().toJson(qmmprice));
        qmmpriceDao.save(qmmprice);

        return qmmprice;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Qmmprice get(@PathVariable Long id) {
        return qmmpriceDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Qmmprice update(@RequestBody Qmmprice qmmprice) {
        qmmpriceDao.update(qmmprice);

        return qmmprice;
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
                return qmmpriceDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Qmmprice> list(PageTableRequest request) {
                return qmmpriceDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        qmmpriceDao.delete(id);
    }
    
    @PostMapping("/AllDataType")
    @ApiOperation(value = "查询第三方平台")
    public List<Qmmprice> getDataType() {

        return qmmpriceDao.getDataType();
    }
    
    @PostMapping("/synchronousData")
    @ApiOperation(value = "同步趣满满数据")
    public void synchronous() {
    	//获取当前登陆人信息
    	SysUser sysuser = UserUtil.getLoginUser();
    	List<Cinema> cinemalist = cinemaDao.getCinemasByUser(sysuser.getRoleId(),sysuser.getId());
    	
    	for(Cinema cinema : cinemalist){
    		try {
    			new QmmPriceUtil().getQmmPrice(cinema.getCode());
				
			} catch (ParseException | IOException e) {
				e.printStackTrace();
			}
    	}
    }
}
