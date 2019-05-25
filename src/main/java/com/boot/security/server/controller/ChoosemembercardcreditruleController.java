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
import com.boot.security.server.service.impl.ChoosemembercardcreditruleServiceImpl;
import com.boot.security.server.page.table.PageTableHandler.CountHandler;
import com.boot.security.server.page.table.PageTableHandler.ListHandler;
import com.boot.security.server.dao.ChoosemembercardcreditruleDao;
import com.boot.security.server.model.Choosemembercardcreditrule;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/choosemembercardcreditrules")
public class ChoosemembercardcreditruleController {

    @Autowired
    private ChoosemembercardcreditruleDao choosemembercardcreditruleDao;
    @Autowired
    private ChoosemembercardcreditruleServiceImpl choosemembercardcreditruleService;

    @PostMapping
    @ApiOperation(value = "保存")
    public Choosemembercardcreditrule save(@RequestBody Choosemembercardcreditrule choosemembercardcreditrule) {
    	choosemembercardcreditruleService.deleteByLevelCode(choosemembercardcreditrule.getCinemaCode(), choosemembercardcreditrule.getLevelCode());
    	String ruleCodes []  = choosemembercardcreditrule.getRuleCode().split(",");
    	String ruleTypes [] = choosemembercardcreditrule.getRuleType().split(",");
    	for(int j=0; j<ruleCodes.length; j++){
    		Choosemembercardcreditrule choosemembercardcredit = new Choosemembercardcreditrule();
    		choosemembercardcredit.setCinemaCode(choosemembercardcreditrule.getCinemaCode());
    		choosemembercardcredit.setLevelCode(choosemembercardcreditrule.getLevelCode());
    		choosemembercardcredit.setRuleCode(ruleCodes[j]);
    		choosemembercardcredit.setRuleType(ruleTypes[j]);
    		choosemembercardcreditruleDao.save(choosemembercardcredit);
        }
        
        return choosemembercardcreditrule;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Choosemembercardcreditrule get(@PathVariable Long id) {
        return choosemembercardcreditruleDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Choosemembercardcreditrule update(@RequestBody Choosemembercardcreditrule choosemembercardcreditrule) {
        choosemembercardcreditruleDao.update(choosemembercardcreditrule);

        return choosemembercardcreditrule;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return choosemembercardcreditruleDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Choosemembercardcreditrule> list(PageTableRequest request) {
                return choosemembercardcreditruleDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        choosemembercardcreditruleDao.delete(id);
    }
    
    @RequestMapping("/getByLevelCode")
    @ApiOperation(value ="根据卡类别编码获取列表")
    public List<Choosemembercardcreditrule> getByLevelCode(@RequestParam("cinemacode") String cinemacode,@RequestParam("levelcode") String levelcode){
    	return choosemembercardcreditruleService.getByLevelCode(cinemacode, levelcode);
    }
}
