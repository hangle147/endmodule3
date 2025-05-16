package dao;

import model.PaymentType;
import utils.DBConnection;
import java.sql.*;
import java.util.*;

public class PaymentTypeDAO {
    public List<PaymentType> getAll() {
        List<PaymentType> list = new ArrayList<>();
        String sql = "SELECT * FROM loai_thanh_toan";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PaymentType pt = new PaymentType();
                pt.setId(rs.getInt("id"));
                pt.setTenLoai(rs.getString("ten_loai"));
                list.add(pt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
