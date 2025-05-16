package controller;

import dao.RoomDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class DeleteRoomServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] ids = req.getParameterValues("roomId");
        if (ids != null) {
            RoomDAO dao = new RoomDAO();
            for (String id : ids) {
                dao.deleteRoomById(Integer.parseInt(id));
            }
        }
        resp.sendRedirect("RoomListServlet");
    }
}
