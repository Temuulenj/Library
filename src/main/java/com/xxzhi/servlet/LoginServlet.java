package com.xxzhi.servlet;

import com.alibaba.fastjson.JSON;
import com.xxzhi.pojo.Reader;
import com.xxzhi.service.ReaderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
TODO
实现并测试前端注册、登录、预约、取消预约功能
后端功能通过测试
重建数据库
 */
/**
 * @author temuulen
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int status=Integer.parseInt(req.getParameter("status"));
        if (status==1){
            resp.getWriter().print(new ReaderService().signIn(req.getParameter("readerId"),req.getParameter("password")));
        }else if (status==0){
            resp.getWriter().print(new ReaderService().signUp(JSON.parseObject("reader",Reader.class)));
        }
    }
}