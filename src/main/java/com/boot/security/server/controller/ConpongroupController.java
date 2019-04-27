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
import com.boot.security.server.service.impl.ConpongroupServiceImpl;
import com.boot.security.server.page.table.PageTableHandler.CountHandler;
import com.boot.security.server.page.table.PageTableHandler.ListHandler;
import com.boot.security.server.model.Conpongroup;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/conpongroups")
public class ConpongroupController {

    @Autowired
    private ConpongroupServiceImpl conpongroupService;

    @PostMapping
    @ApiOperation(value = "保存")
    public Conpongroup save(@RequestBody Conpongroup conpongroup) {
    	conpongroupService.save(conpongroup);

        return conpongroup;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Conpongroup get(@PathVariable Long id) {
        return conpongroupService.getById(id);
    }
    
    @PutMapping
    @ApiOperation(value = "修改")
    public Conpongroup update(@RequestBody Conpongroup conpongroup) {
    	conpongroupService.update(conpongroup);

        return conpongroup;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return conpongroupService.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Conpongroup> list(PageTableRequest request) {
                return conpongroupService.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
    	conpongroupService.delete(id);
    }
}
