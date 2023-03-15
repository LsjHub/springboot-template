package com.example.template.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

@Controller
public class AbstractController {

    public void responseJson(HttpServletResponse response, Map<String, String> map) {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter printWriter = null;
        try {
            printWriter = response.getWriter();
        } catch (Exception e) {
            System.out.println("获取response流失败");
        }
        printWriter.write(JSONObject.toJSONString(map));
        printWriter.flush();
        printWriter.close();
    }

    public void responseJson(HttpServletResponse response, Map<String, String> map, String logPrefix) {
        response.setContentType("application/json;charset=utf-8");
        String result = JSONObject.toJSONString(map);
        System.out.println(logPrefix + "接口返回：" + result);
        PrintWriter printWriter = null;
        try {
            printWriter = response.getWriter();
        } catch (Exception e) {
            System.out.println("获取response流失败");
        }
        printWriter.write(result);
        printWriter.flush();
        printWriter.close();
    }

    public void responseString(HttpServletResponse response, String result) {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter printWriter = null;
        try {
            printWriter = response.getWriter();
        } catch (Exception e) {
            System.out.println("获取response流失败");
        }
        printWriter.write(result);
        printWriter.flush();
        printWriter.close();
    }

    public void responseString(HttpServletResponse response, String result, String logPrefix) {
        response.setContentType("application/json;charset=utf-8");
        System.out.println(logPrefix + "接口返回：" + result);
        PrintWriter printWriter = null;
        try {
            printWriter = response.getWriter();
        } catch (Exception e) {
            System.out.println("获取response流失败");
        }
        printWriter.write(result);
        printWriter.flush();
        printWriter.close();
    }

    public void responseException(HttpServletResponse response, String logPrefix) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", "500");
        jsonObject.put("errMsg", "系统繁忙，请稍后再试");
        responseString(response, jsonObject.toJSONString(), logPrefix);
    }

    public void responseSuccess(HttpServletResponse response, String logPrefix) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", "0");
        jsonObject.put("errMsg", "Success");
        responseString(response, jsonObject.toJSONString(), logPrefix);
    }
}
