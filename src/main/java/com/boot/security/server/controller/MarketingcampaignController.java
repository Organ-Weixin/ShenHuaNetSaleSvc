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
import com.boot.security.server.service.impl.MarketingcampaignServiceImpl;
import com.boot.security.server.page.table.PageTableHandler.CountHandler;
import com.boot.security.server.page.table.PageTableHandler.ListHandler;
import com.boot.security.server.dao.MarketingcampaignDao;
import com.boot.security.server.model.Marketingcampaign;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/marketingcampaigns")
public class MarketingcampaignController {

    @Autowired
    private MarketingcampaignDao marketingcampaignDao;
/*    @Autowired
    private MarketingcampaignServiceImpl _marketingcampaignService;*/
    @PostMapping
    @ApiOperation(value = "保存")
    public Marketingcampaign save(@RequestBody Marketingcampaign marketingcampaign) {
        marketingcampaignDao.save(marketingcampaign);

        return marketingcampaign;
    }
 
    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Marketingcampaign get(@PathVariable Long id) {
        return marketingcampaignDao.getById(id);
    }
    @RequestMapping("/changestatus")
    @ApiOperation(value = "改变营销活动状态")
    public int changeStatus(@RequestParam("status") Integer status,@RequestParam("id") Long id){
    	return marketingcampaignDao.changestatus(status, id);
    }
    
    @PutMapping
    @ApiOperation(value = "修改")
    public Marketingcampaign update(@RequestBody Marketingcampaign marketingcampaign) {
        marketingcampaignDao.update(marketingcampaign);
        return marketingcampaign;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return marketingcampaignDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Marketingcampaign> list(PageTableRequest request) {
                return marketingcampaignDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        marketingcampaignDao.delete(id);
    }
}
