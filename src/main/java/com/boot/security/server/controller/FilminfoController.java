package com.boot.security.server.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.boot.security.server.page.table.PageTableRequest;
import com.boot.security.server.page.table.PageTableHandler;
import com.boot.security.server.page.table.PageTableResponse;
import com.boot.security.server.page.table.PageTableHandler.CountHandler;
import com.boot.security.server.page.table.PageTableHandler.ListHandler;
import com.boot.security.server.dao.FilminfoDao;
import com.boot.security.server.model.Filminfo;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/filminfos")
public class FilminfoController {

    @Autowired
    private FilminfoDao filminfoDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public Filminfo save(@RequestBody Filminfo filminfo) {
        filminfoDao.save(filminfo);

        return filminfo;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Filminfo get(@PathVariable Long id) {
        return filminfoDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Filminfo update(@RequestBody Filminfo filminfo){
    	filminfoDao.update(filminfo);
        return filminfo;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return filminfoDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Filminfo> list(PageTableRequest request) {
                return filminfoDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        filminfoDao.delete(id);
    }
}
