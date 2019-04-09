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
import com.boot.security.server.page.table.PageTableHandler.CountHandler;
import com.boot.security.server.page.table.PageTableHandler.ListHandler;
import com.boot.security.server.dao.MembercardDao;
import com.boot.security.server.model.Membercard;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/membercards")
public class MembercardController {

    @Autowired
    private MembercardDao membercardDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public Membercard save(@RequestBody Membercard membercard) {
        membercardDao.save(membercard);

        return membercard;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Membercard get(@PathVariable Long id) {
        return membercardDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Membercard update(@RequestBody Membercard membercard) {
        membercardDao.update(membercard);

        return membercard;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return membercardDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Membercard> list(PageTableRequest request) {
                return membercardDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        membercardDao.delete(id);
    }
}
