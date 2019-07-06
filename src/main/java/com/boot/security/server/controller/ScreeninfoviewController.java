package com.boot.security.server.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.security.server.api.core.NetSaleSvcCore;
import com.boot.security.server.api.core.QueryCinemaReply;
import com.boot.security.server.api.core.QuerySeatReply;
import com.boot.security.server.dao.ScreeninfoviewDao;
import com.boot.security.server.model.Screeninfoview;
import com.boot.security.server.page.table.PageTableHandler;
import com.boot.security.server.page.table.PageTableHandler.CountHandler;
import com.boot.security.server.page.table.PageTableHandler.ListHandler;
import com.boot.security.server.page.table.PageTableRequest;
import com.boot.security.server.page.table.PageTableResponse;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/screeninfoviews")
public class ScreeninfoviewController {

    @Autowired
    private ScreeninfoviewDao screeninfoviewDao;
    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping
    @ApiOperation(value = "保存")
    public Screeninfoview save(@RequestBody Screeninfoview screeninfoview) {
        screeninfoviewDao.save(screeninfoview);

        return screeninfoview;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Screeninfoview get(@PathVariable Long id) {
        return screeninfoviewDao.getById(id);
    }
    @PostMapping("/getNewScreeninfoview")
    @ApiOperation(value = "重新获取影厅")
    public QueryCinemaReply getNewScreen(@RequestBody Map map){
    	String UserName = "MiniProgram";
    	String Password = "6BF477EBCC446F54E6512AFC0E976C41";
    	try {
			QueryCinemaReply reply=NetSaleSvcCore.getInstance().QueryCinema(UserName, Password,map.get("cinemaCode").toString());
		return reply;
    	} catch (Exception e) {
			e.printStackTrace();
			return new QueryCinemaReply();
		}
    }
    @RequestMapping("/getNewScreenSeat")
    @ApiOperation(value = "重新获取影厅座位")//@RequestParam(value="loginname",required=false
    public QuerySeatReply getNewScreenSeat(@RequestBody Map map){

    	redisTemplate.delete("seats:"+map.get("cinemaCode"));//清缓存

    	String UserName = "MiniProgram";
    	String Password = "6BF477EBCC446F54E6512AFC0E976C41";
    	try {
			QuerySeatReply reply=NetSaleSvcCore.getInstance().QuerySeat(UserName, Password, map.get("cinemaCode").toString(), map.get("screenCode").toString());
			return reply;
    	} catch (Exception e) {
			e.printStackTrace();
			return new QuerySeatReply();
		}
    }
    @PutMapping
    @ApiOperation(value = "修改")
    public Screeninfoview update(@RequestBody Screeninfoview screeninfoview) {
        screeninfoviewDao.update(screeninfoview);

        return screeninfoview;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return screeninfoviewDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Screeninfoview> list(PageTableRequest request) {
                return screeninfoviewDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        screeninfoviewDao.delete(id);
    }
}
