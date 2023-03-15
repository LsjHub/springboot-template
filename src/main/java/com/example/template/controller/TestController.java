package com.example.template.controller;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.template.bean.BaseAPIResponse;
import com.example.template.bean.Test;
import com.example.template.service.RedisService;
import com.example.template.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class TestController extends AbstractController {

    @Autowired
    private RedisService redisService;

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/test")
    public void test(HttpServletResponse response) {
        BaseAPIResponse baseAPIResponse = new BaseAPIResponse();
        responseString(response, JSON.toJSONString(baseAPIResponse));
    }

    @RequestMapping(value = "/test_redis")
    public void testRedis(HttpServletResponse response) {
        BaseAPIResponse baseAPIResponse = new BaseAPIResponse();
        String result = redisService.testRedis();
        JSONObject dataJson = new JSONObject();
        dataJson.put("result", result);
        baseAPIResponse.setData(dataJson);
        responseString(response, JSON.toJSONString(baseAPIResponse));
    }

    @RequestMapping(value = "/test_mysql")
    public void testMysql(HttpServletResponse response,
                          @RequestParam(required = false) Integer current,
                          @RequestParam(required = false) Integer size
    ) {
        current = current == null ? 1 : current;
        size = size == null ? 10 : size;
        BaseAPIResponse baseAPIResponse = new BaseAPIResponse();
        IPage<Test> page = testService.page(new Page(current, size), new QueryWrapper<Test>()
                .orderByDesc("id"));
        JSONObject dataJson = (JSONObject) JSONObject.toJSON(page);
        baseAPIResponse.setData(dataJson);
        responseString(response, JSON.toJSONString(baseAPIResponse));
    }
}
