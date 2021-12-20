package com.xxzhi.servlet;

import com.alibaba.fastjson.JSONObject;
import com.xxzhi.dao.SeatDao;
import com.xxzhi.pojo.Seat;
import com.xxzhi.service.SeatService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author temuulen
 */
@WebServlet("/api/getByFloor")
public class GetSeatByFloor extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print(new SeatService().getByFloor(Integer.parseInt(req.getParameter("floor")),Integer.parseInt(req.getParameter("status"))));
    }
}