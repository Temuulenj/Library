package com.xxzhi.servlet;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xxzhi.dao.SeatDao;
import com.xxzhi.pojo.Seat;

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
@WebServlet("/api/getAllSeat")
public class GetAllSeat extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String jsonString=req.getParameter("data");
//        Seat seat= JSON.parseObject(jsonString,Seat.class);
        ArrayList<Seat> list= SeatDao.selectAll();
        resp.getWriter().print(JSONObject.toJSON(list));
    }
}