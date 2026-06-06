package miu.lesson.midexam.repository;

import java.util.List;

import miu.lesson.midexam.db.DBContext;
import miu.lesson.midexam.model.Surgery;

public class SurgeryRepository {
    private static SurgeryRepository instance;
    private DBContext dbContext;

    private SurgeryRepository() {
        dbContext = DBContext.getInstance();
    }

    public static synchronized SurgeryRepository getInstance() {
        if (instance == null) {
            instance = new SurgeryRepository();
        }
        return instance;
    }

    public List<Surgery> findAll() {
        return dbContext.getSurgeries();
    }

    public Surgery findById(String surgeryId) {
        return dbContext.getSurgeries().stream()
                .filter(s -> s.getId().equals(surgeryId))
                .findFirst()
                .orElse(null);
    }
}
