package dao;

import model.RentRoom;
import utils.DBConnection;
import java.sql.*;
import java.util.*;

public class RentRoomDAO {
    public List<RentRoom> getAllRooms() {
        List<RentRoom> list = new ArrayList<>();
        String sql = "SELECT tp.*, ltt.ten_loai FROM thue_phong tp JOIN loai_thanh_toan ltt ON tp.id_hinh_thuc_thanh_toan = ltt.id";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                RentRoom room = new RentRoom();
                room.setId(rs.getInt("id"));
                room.setTenNguoiThue(rs.getString("ten_nguoi_thue"));
                room.setSoDienThoai(rs.getString("so_dien_thoai"));
                room.setNgayBatDau(rs.getString("ngay_bat_dau"));
                room.setIdHinhThucThanhToan(rs.getInt("id_hinh_thuc_thanh_toan"));
                room.setTenLoaiThanhToan(rs.getString("ten_loai"));
                room.setGhiChu(rs.getString("ghi_chu"));
                list.add(room);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<RentRoom> searchRooms(String keyword) {
        List<RentRoom> list = new ArrayList<>();
        String sql = "SELECT tp.*, ltt.ten_loai FROM thue_phong tp JOIN loai_thanh_toan ltt ON tp.id_hinh_thuc_thanh_toan = ltt.id " +
                "WHERE tp.id LIKE ? OR tp.ten_nguoi_thue LIKE ? OR tp.so_dien_thoai LIKE ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            String kw = "%" + keyword + "%";
            ps.setString(1, kw);
            ps.setString(2, kw);
            ps.setString(3, kw);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                RentRoom room = new RentRoom();
                room.setId(rs.getInt("id"));
                room.setTenNguoiThue(rs.getString("ten_nguoi_thue"));
                room.setSoDienThoai(rs.getString("so_dien_thoai"));
                room.setNgayBatDau(rs.getString("ngay_bat_dau"));
                room.setIdHinhThucThanhToan(rs.getInt("id_hinh_thuc_thanh_toan"));
                room.setTenLoaiThanhToan(rs.getString("ten_loai"));
                room.setGhiChu(rs.getString("ghi_chu"));
                list.add(room);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void insertRoom(RentRoom room) {
        String sql = "INSERT INTO thue_phong (ten_nguoi_thue, so_dien_thoai, ngay_bat_dau, id_hinh_thuc_thanh_toan, ghi_chu) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, room.getTenNguoiThue());
            ps.setString(2, room.getSoDienThoai());
            ps.setString(3, room.getNgayBatDau());
            ps.setInt(4, room.getIdHinhThucThanhToan());
            ps.setString(5, room.getGhiChu());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteRoomById(int id) {
        String sql = "DELETE FROM thue_phong WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
