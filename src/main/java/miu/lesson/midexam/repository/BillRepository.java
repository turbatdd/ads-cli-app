package miu.lesson.midexam.repository;

import java.util.List;

import miu.lesson.midexam.db.DBContext;
import miu.lesson.midexam.model.Bill;

public class BillRepository {
    private static BillRepository instance;
    private DBContext dbContext;

    private BillRepository() {
        dbContext = DBContext.getInstance();
    }

    public static synchronized BillRepository getInstance() {
        if (instance == null) {
            instance = new BillRepository();
        }
        return instance;
    }

    public List<Bill> findAll() {
        return dbContext.getBills();
    }

    public Bill findById(String billId) {
        return dbContext.getBills().stream()
                .filter(b -> b.getId().equals(billId))
                .findFirst()
                .orElse(null);
    }
}
