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
import com.boot.security.server.dao.MembercardcreditruleDao;
import com.boot.security.server.model.Membercardcreditrule;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/membercardcreditrules")
public class MembercardcreditruleController {

    @Autowired
    private MembercardcreditruleDao membercardcreditruleDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public Membercardcreditrule save(@RequestBody Membercardcreditrule membercardcreditrule) {
    	//充值规则编码--10位时间戳加5位随机字母
    	String ruleCode = String.valueOf(new Date().getTime()/1000);
    	for (int i = 0; i < 5; i++) {
            // 得到随机字母
            char c = (char) ((Math.random() * 26) + 97);
            // 拼接成字符串
            ruleCode += (c + "");
        }
    	membercardcreditrule.setRuleCode(ruleCode);
    	membercardcreditrule.setCreateTime(new Date());
        membercardcreditruleDao.save(membercardcreditrule);

        return membercardcreditrule;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Membercardcreditrule get(@PathVariable Long id) {
        return membercardcreditruleDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Membercardcreditrule update(@RequestBody Membercardcreditrule membercardcreditrule) {
    	membercardcreditrule.setUpdateTime(new Date());
        membercardcreditruleDao.update(membercardcreditrule);

        return membercardcreditrule;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return membercardcreditruleDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Membercardcreditrule> list(PageTableRequest request) {
                return membercardcreditruleDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        membercardcreditruleDao.delete(id);
    }
    public static void main(String[] args) {
		
	}
}
