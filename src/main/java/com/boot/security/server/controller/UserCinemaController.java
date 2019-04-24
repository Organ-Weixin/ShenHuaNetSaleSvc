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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.security.server.page.table.PageTableRequest;
import com.boot.security.server.page.table.PageTableHandler;
import com.boot.security.server.page.table.PageTableResponse;
import com.boot.security.server.page.table.PageTableHandler.CountHandler;
import com.boot.security.server.page.table.PageTableHandler.ListHandler;
import com.boot.security.server.dao.UserCinemaDao;
import com.boot.security.server.model.UserCinema;
import com.boot.security.server.modelView.UserCinemaTitle;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/userCinemas")
public class UserCinemaController {

    @Autowired
    private UserCinemaDao userCinemaDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public UserCinema save(@RequestBody UserCinema userCinema) {
        userCinemaDao.save(userCinema);

        return userCinema;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public UserCinema get(@PathVariable Long id) {
        return userCinemaDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public UserCinema update(@RequestBody UserCinema userCinema) {
        userCinemaDao.update(userCinema);

        return userCinema;
    }

    @PostMapping("/getByUserIdAndCode")
    @ApiOperation(value = "根据userid、cinemacode查询影院")
    public UserCinema getByUserIdAndCode(@RequestParam(value="UserId") Long UserId, @RequestParam(value="CinemaCode") String CinemaCode) {
        
        return userCinemaDao.getByUserIdAndCinemaCode(UserId, CinemaCode);
    }
    
    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return userCinemaDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<UserCinema> list(PageTableRequest request) {
                return userCinemaDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @GetMapping("/getByUserId/{userid}")
    @ApiOperation(value = "根据接入商id查影院列表")
    public PageTableResponse listByUserId(PageTableRequest request,@PathVariable Long userid) {
    	
         return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return userCinemaDao.countByUserid(request.getParams(),userid);
            }
        }, new ListHandler() {

            @Override
            public List<UserCinemaTitle> list(PageTableRequest request) {
            	 
                return userCinemaDao.listByUserid(request.getParams(), request.getOffset(), request.getLimit(),userid);
            }
        }).handle(request);
         
    }
    
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        userCinemaDao.delete(id);
    }
}
