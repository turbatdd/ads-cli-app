package miu.lesson.midexam.repository;

import java.util.List;

import miu.lesson.midexam.db.DBContext;
import miu.lesson.midexam.model.person.Dentist;

public class DentistRepository {
    private static DentistRepository instance;
    private DBContext dbContext;

    private DentistRepository() {
        dbContext = DBContext.getInstance();
    }

    public static synchronized DentistRepository getInstance() {
        if (instance == null) {
            instance = new DentistRepository();
        }
        return instance;
    }

    public List<Dentist> findAll() {
        return dbContext.getDentists();
    }

    public Dentist findById(String dentistId) {
        return dbContext.getDentists().stream()
                .filter(d -> d.getId().equals(dentistId))
                .findFirst()
                .orElse(null);
    }
}
