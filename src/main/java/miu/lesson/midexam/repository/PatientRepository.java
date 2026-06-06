package miu.lesson.midexam.repository;

import java.util.List;

import miu.lesson.midexam.db.DBContext;
import miu.lesson.midexam.model.person.Patient;

public class PatientRepository {
    private static PatientRepository instance;
    private DBContext dbContext;

    private PatientRepository() {
        dbContext = DBContext.getInstance();
    }

    public static synchronized PatientRepository getInstance() {
        if (instance == null) {
            instance = new PatientRepository();
        }
        return instance;
    }

    public List<Patient> findAll() {
        return dbContext.getPatients();
    }

    public Patient findById(String patientId) {
        return dbContext.getPatients().stream()
                .filter(p -> p.getId().equals(patientId))
                .findFirst()
                .orElse(null);
    }
}
