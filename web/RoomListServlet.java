package web;

import dao.PaymentTypeDAO;
import model.PaymentType;
import model.RentRoom;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class RoomListServlet extends HttpServlet {
    private RentRoomDAO roomDAO = new RentRoomDAO();
    private PaymentTypeDAO paymentTypeDAO = new PaymentTypeDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        List<RentRoom> listRoom = (keyword != null && !keyword.isEmpty()) ? roomDAO.searchRooms(keyword) : roomDAO.getAllRooms();
        List<PaymentType> paymentTypes = paymentTypeDAO.getAll();

        request.setAttribute("listRoom", listRoom);
        request.setAttribute("paymentTypes", paymentTypes);
        request.setAttribute("keyword", keyword);
        request.setAttribute("today", LocalDate.now().toString());
        request.getRequestDispatcher("room_list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String confirmDelete = request.getParameter("confirmDelete");
        String[] roomIds = request.getParameterValues("roomId");

        if (confirmDelete != null && confirmDelete.equals("true") && roomIds != null) {
            for (String idStr : roomIds) {
                try {
                    int id = Integer.parseInt(idStr);
                    roomDAO.deleteRoomById(id);
                } catch (NumberFormatException ignored) {}
            }
            response.sendRedirect("RoomListServlet");
            return;
        }

        String tenantName = request.getParameter("tenantName");
        String phoneNumber = request.getParameter("phoneNumber");
        String startDate = request.getParameter("startDate");
        String paymentTypeIdStr = request.getParameter("paymentTypeId");
        String note = request.getParameter("note");

        if (tenantName == null || phoneNumber == null || startDate == null || paymentTypeIdStr == null
                || tenantName.isEmpty() || phoneNumber.isEmpty() || startDate.isEmpty() || paymentTypeIdStr.isEmpty()) {
            response.sendRedirect("RoomListServlet?error=Vui+lòng+nhập+đầy+đủ+thông+tin");
            return;
        }

        try {
            int paymentTypeId = Integer.parseInt(paymentTypeIdStr);
            RentRoom room = new RentRoom();
            room.setTenNguoiThue(tenantName);
            room.setSoDienThoai(phoneNumber);
            room.setNgayBatDau(startDate);
            room.setIdHinhThucThanhToan(paymentTypeId);
            room.setGhiChu(note);

            roomDAO.insertRoom(room);
            response.sendRedirect("RoomListServlet");
        } catch (NumberFormatException e) {
            response.sendRedirect("RoomListServlet?error=Hình+thức+thanh+toán+k hợp+lệ");
        }
    }
