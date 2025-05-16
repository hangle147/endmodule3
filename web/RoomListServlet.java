package web;

import model.PaymentType;
import model.RentRoom;

import java.io.IOException;
import java.util.List;

public class RoomListServlet {
    protected <HttpServletRequest> void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<RentRoom> listRoom = roomDAO.getAllRooms();
            List<PaymentType> paymentTypes = roomDAO.getAllPaymentTypes();

            request.setAttribute("listRoom", listRoom);
            request.setAttribute("paymentTypes", paymentTypes);

            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Lỗi lấy dữ liệu: " + e.getMessage());
        }
    }

}
