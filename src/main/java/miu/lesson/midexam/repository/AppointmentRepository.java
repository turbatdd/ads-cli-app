package miu.lesson.midexam.repository;

import java.util.List;

import miu.lesson.midexam.db.DBContext;
import miu.lesson.midexam.model.Appointment;

public class AppointmentRepository {
    private static AppointmentRepository instance;
    private DBContext dbContext;

    private AppointmentRepository() {
        dbContext = DBContext.getInstance();
    }

    public static synchronized AppointmentRepository getInstance() {
        if (instance == null) {
            instance = new AppointmentRepository();
        }
        return instance;
    }

    public List<Appointment> findAll() {
        return dbContext.getAppointments();
    }

    public Appointment findById(int appointmentId) {
        return dbContext.getAppointments().stream()
                .filter(a -> a.getId() == appointmentId)
                .findFirst()
                .orElse(null);
    }
}
