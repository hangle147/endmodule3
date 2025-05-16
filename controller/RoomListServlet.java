package controller;

import dao.*;
import model.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.*;

public class RoomListServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RoomDAO dao = new RoomDAO();
        PaymentTypeDAO ptDao = new PaymentTypeDAO();

        String keyword = req.getParameter("keyword");
        List<RentRoom> rooms = (keyword != null && !keyword.isEmpty()) ? dao.searchRooms(keyword) : dao.getAllRooms();

        req.setAttribute("listRoom", rooms);
        req.setAttribute("paymentTypes", ptDao.getAll());
        req.setAttribute("keyword", keyword);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
