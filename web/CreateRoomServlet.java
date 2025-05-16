package web;

import model.RentRoom;

import java.io.IOException;

public class CreateRoomServlet {
    protected <HttpServletRequest, HttpServletResponse> void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Đảm bảo mã hóa tiếng Việt
        request.setCharacterEncoding("UTF-8");

        try {
            // Lấy dữ liệu từ form
            String tenantName = request.getParameter("tenantName");
            String phoneNumber = request.getParameter("phoneNumber");
            String startDate = request.getParameter("startDate"); // nên có định dạng yyyy-MM-dd
            int paymentTypeId = Integer.parseInt(request.getParameter("paymentTypeId"));
            String note = request.getParameter("note");

            // Tạo đối tượng thuê phòng
            RentRoom room = new RentRoom();
            room.setTenantName(tenantName);
            room.setPhoneNumber(phoneNumber);
            room.setStartDate(startDate);
            room.setPaymentTypeId(paymentTypeId);
            room.setNote(note);

            // Gọi DAO lưu vào database
            roomDAO.insertRoom(room);

            // Chuyển hướng về danh sách
            response.sendRedirect("RoomListServlet");

        } catch (Exception e) {
            e.printStackTrace(); // Ghi log
            // Nếu lỗi, chuyển tiếp về form với thông báo lỗi
            request.setAttribute("error", "Có lỗi xảy ra khi thêm phòng: " + e.getMessage());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

}
