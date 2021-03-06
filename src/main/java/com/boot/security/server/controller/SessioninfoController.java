package com.boot.security.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.security.server.page.table.PageTableRequest;
import com.boot.security.server.page.table.PageTableHandler;
import com.boot.security.server.page.table.PageTableResponse;
import com.boot.security.server.service.impl.SessioninfoServiceImpl;
import com.boot.security.server.page.table.PageTableHandler.CountHandler;
import com.boot.security.server.page.table.PageTableHandler.ListHandler;
import com.boot.security.server.dao.SessioninfoDao;
import com.boot.security.server.model.Sessioninfo;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/sessioninfos")
public class SessioninfoController{

    @Autowired
    private SessioninfoDao sessioninfoDao;
    @Autowired
    private SessioninfoServiceImpl sessioninfoService;

    @PostMapping
    @ApiOperation(value = "保存")
    public Sessioninfo save(@RequestBody Sessioninfo sessioninfo) {
        sessioninfoDao.save(sessioninfo);

        return sessioninfo;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Sessioninfo get(@PathVariable Long id) {
        return sessioninfoDao.getById(id);
    }

    @GetMapping
    @ApiOperation(value = "排期列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return sessioninfoDao.countSession(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Sessioninfo> list(PageTableRequest request) {
                return sessioninfoDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        sessioninfoDao.delete(id);
    }
    
    @RequestMapping("/getFilmsByCinemaCode")
    public List<Sessioninfo> getFilmsByCinemaCode(@RequestParam("cinemacodes") String cinemacodes){
    	return sessioninfoService.getFilmsByCinemaCode(cinemacodes);
    }
    
    @RequestMapping("/getByCinemaFilm")
    @ApiOperation(value = "根据影院、影片查询场次")
    public List<Sessioninfo> getByCinemaFilm(@RequestParam("cinemacode") String cinemacode,@RequestParam("filmcode") String filmcode){
    	return sessioninfoService.getByCinemaCodeAndFilmCode(cinemacode, filmcode);
    }
}
