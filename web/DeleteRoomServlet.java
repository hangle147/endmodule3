package web;

import java.io.IOException;

public class DeleteRoomServlet {
    protected <HttpServletRequest, HttpServletResponse> void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            String[] ids = request.getParameterValues("roomId");

            if (ids != null) {
                for (String id : ids) {
                    roomDAO.deleteRoomById(Integer.parseInt(id));
                }
            }

            response.sendRedirect("RoomListServlet");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Lỗi xóa phòng: " + e.getMessage());
        }
    }

}
