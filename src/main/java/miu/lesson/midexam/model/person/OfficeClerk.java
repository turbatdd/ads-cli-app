package miu.lesson.midexam.model.person;

public class OfficeClerk extends Person {
    private String employeeId;

    public OfficeClerk(String id, String firstName, String lastName,
                       String email, String phone, String employeeId) {
        super(id, firstName, lastName, email, phone);
        this.employeeId = employeeId;
    }

    public String getEmployeeId() { return employeeId; }

    public void bookAppointment() { }
    public void searchPatient()   { }
}
