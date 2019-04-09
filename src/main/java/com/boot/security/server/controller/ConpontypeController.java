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
import com.boot.security.server.service.impl.ConpontypeServiceImpl;
import com.boot.security.server.page.table.PageTableHandler.CountHandler;
import com.boot.security.server.page.table.PageTableHandler.ListHandler;
import com.boot.security.server.dao.ConpontypeDao;
import com.boot.security.server.model.Conpontype;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/conpontypes")
public class ConpontypeController {

    @Autowired
    private ConpontypeServiceImpl conpontypeService;

    @PostMapping
    @ApiOperation(value = "保存")
    public Conpontype save(@RequestBody Conpontype conpontype) {
    	conpontypeService.save(conpontype);

        return conpontype;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Conpontype get(@PathVariable Long id) {
        return conpontypeService.getById(id);
    }
    
    @RequestMapping("/getCertificatetype")
    public List<Conpontype> getCertificatetype(){
    	List<Conpontype> list = conpontypeService.getCertificatetype();
    	return list;
    }
    
    @RequestMapping("/getConponsType")
    public List<Conpontype> getConponsType(){
    	List<Conpontype> list = conpontypeService.getConpontype();
    	return list;
    }
    
    @PutMapping
    @ApiOperation(value = "修改")
    public Conpontype update(@RequestBody Conpontype conpontype) {
    	conpontypeService.update(conpontype);
        return conpontype;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return conpontypeService.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Conpontype> list(PageTableRequest request) {
                return conpontypeService.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
    	conpontypeService.delete(id);
    }
}
