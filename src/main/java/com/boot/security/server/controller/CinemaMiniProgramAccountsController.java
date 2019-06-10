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
import com.boot.security.server.service.impl.CinemaMiniProgramAccountsServiceImpl;
import com.boot.security.server.page.table.PageTableHandler.CountHandler;
import com.boot.security.server.page.table.PageTableHandler.ListHandler;
import com.boot.security.server.dao.CinemaMiniProgramAccountsDao;
import com.boot.security.server.model.CinemaMiniProgramAccounts;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/cinemaminiprogramaccountss")
public class CinemaMiniProgramAccountsController {

    @Autowired
    private CinemaMiniProgramAccountsDao cinemaminiprogramaccountsDao;
    @Autowired
    private CinemaMiniProgramAccountsServiceImpl cinemaMiniProgramAccountsService;

    @PostMapping
    @ApiOperation(value = "保存")
    public CinemaMiniProgramAccounts save(@RequestBody CinemaMiniProgramAccounts cinemaminiprogramaccounts) {
        cinemaminiprogramaccountsDao.save(cinemaminiprogramaccounts);

        return cinemaminiprogramaccounts;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public CinemaMiniProgramAccounts get(@PathVariable Long id) {
        return cinemaminiprogramaccountsDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public int update(@RequestBody CinemaMiniProgramAccounts cinemaminiprogramaccounts) {
        
        return cinemaminiprogramaccountsDao.update(cinemaminiprogramaccounts);
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return cinemaminiprogramaccountsDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<CinemaMiniProgramAccounts> list(PageTableRequest request) {
                return cinemaminiprogramaccountsDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        cinemaminiprogramaccountsDao.delete(id);
    }
    
    @RequestMapping("/getAppIdByCinemaCode")
    @ApiOperation(value = "获取影院APPID")
    public CinemaMiniProgramAccounts getAppIdByCinemaCode(@RequestParam("cinemacode")String cinemacode){
    	return cinemaMiniProgramAccountsService.getByCinemaCode(cinemacode);
    }
    
    @RequestMapping("/getCinemaCodeByAppId")
    @ApiOperation(value = "获取appid下的所有影院")
    public List<CinemaMiniProgramAccounts> getCinemaCodeByAppId(@RequestParam("appid")String appid){
    	return cinemaMiniProgramAccountsService.getByAppId(appid);
    }
}
