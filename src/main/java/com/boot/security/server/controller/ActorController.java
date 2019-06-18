package com.boot.security.server.controller;

import java.util.Date;
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
import com.boot.security.server.dao.ActorDao;
import com.boot.security.server.model.Actor;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/actors")
public class ActorController {

    @Autowired
    private ActorDao actorDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public Actor save(@RequestBody Actor actor) {
    	actor.setCreateTime(new Date());
    	actor.setValid(1);
    	actor.setVersion(0);
        actorDao.save(actor);

        return actor;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Actor get(@PathVariable Long id) {
        return actorDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Actor update(@RequestBody Actor actor) {
    	actor.setModifyTime(new Date());
        actorDao.update(actor);

        return actor;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return actorDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Actor> list(PageTableRequest request) {
                return actorDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        actorDao.delete(id);
    }
}
