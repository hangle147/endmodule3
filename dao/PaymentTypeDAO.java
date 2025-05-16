package dao;

import model.PaymentType;
import utils.DBConnection;
import java.sql.*;
import java.util.*;

public class PaymentTypeDAO {
    public List<PaymentType> getAll() {
        List<PaymentType> list = new ArrayList<>();
        String sql = "SELECT * FROM payment_type";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PaymentType pt = new PaymentType();
                pt.setId(rs.getInt("id"));
                pt.setTypeName(rs.getString("type_name"));
                list.add(pt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
