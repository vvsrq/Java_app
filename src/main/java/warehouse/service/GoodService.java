package warehouse.service;

import warehouse.dao.GoodDAO;
import warehouse.model.Good;

import java.sql.SQLException;
import java.util.List;

public class GoodService {
    private GoodDAO goodDAO = new GoodDAO();

    public void saveGood(Good good) throws SQLException {
        if (isGoodNameDuplicate(good.getName())) {
            throw new IllegalArgumentException("Good name already exists!");
        }
        goodDAO.saveGood(good);
    }

    public List<Good> getGoods() throws SQLException {
        return goodDAO.getGoods();
    }

    private boolean isGoodNameDuplicate(String goodName) throws SQLException {
        List<Good> existingGoods = goodDAO.getGoods();
        for (Good existingGood : existingGoods) {
            if (existingGood.getName().equalsIgnoreCase(goodName)) {
                return true;
            }
        }
        return false;
    }
}
