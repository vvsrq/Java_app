package warehouse.dao;

import warehouse.model.Good;
import warehouse.util.Constants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GoodDAO {

    public void saveGood(Good good) throws SQLException {
        try (Connection conn = DriverManager.getConnection(Constants.DB_URL, Constants.DB_USER, Constants.DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO goods (name, quantity) VALUES (?, ?)")) {

            stmt.setString(1, good.getName());
            stmt.setInt(2, good.getQuantity());
            stmt.executeUpdate();

        }
    }

    public List<Good> getGoods() throws SQLException {
        List<Good> goods = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(Constants.DB_URL, Constants.DB_USER, Constants.DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM goods")) {

            while (rs.next()) {
                Good good = new Good(); // Now uses the default constructor
                good.setId(rs.getInt("id"));
                good.setName(rs.getString("name"));
                good.setQuantity(rs.getInt("quantity"));
                goods.add(good);
            }
        }
        return goods;
    }
}