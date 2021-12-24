package com.xxzhi.servlet;

import com.xxzhi.dao.SignInfoDao;
import com.xxzhi.pojo.SignInfo;
import com.xxzhi.service.SignService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author temuulen
 */
@WebServlet("/reserveSign")
public class ReserveSignServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int status=Integer.parseInt(req.getParameter("status"));
        //签到//签退
        if (new SignService().sign(new SignInfo(req.getParameter("readerId"),req.getParameter("seatId"),Integer.parseInt(req.getParameter("status"))))){
            resp.getWriter().print("success");
        }else {
            resp.getWriter().print("error");
        }
    }
}
