package com.xxzhi.servlet;

import com.xxzhi.service.ReserveService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author temuulen
 */
@WebServlet("/reserve")
public class ReserveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int status=Integer.parseInt(req.getParameter("status"));
        if (status==1){

            resp.getWriter().print(new ReserveService().reserve(req.getParameter("readerId"),req.getParameter("seatId"),req.getParameter("startTime"),req.getParameter("endTime")));
        }else if (status==0){
            resp.getWriter().print(new ReserveService().cancelReserve(req.getParameter("readerId")));
        }
    }
}