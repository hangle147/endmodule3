package web;

import model.RentRoom;

import java.io.IOException;

public class CreateRoomServlet {
    protected <HttpServletRequest, HttpServletResponse> void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String tenantName = request.getParameter("tenantName");
            String phoneNumber = request.getParameter("phoneNumber");
            String startDate = request.getParameter("startDate"); // nên có định dạng yyyy-MM-dd
            int paymentTypeId = Integer.parseInt(request.getParameter("paymentTypeId"));
            String note = request.getParameter("note");

            RentRoom room = new RentRoom();
            room.setTenantName(tenantName);
            room.setPhoneNumber(phoneNumber);
            room.setStartDate(startDate);
            room.setPaymentTypeId(paymentTypeId);
            room.setNote(note);

            roomDAO.insertRoom(room);

            response.sendRedirect("RoomListServlet");

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Có lỗi xảy ra khi thêm phòng: " + e.getMessage());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

}
