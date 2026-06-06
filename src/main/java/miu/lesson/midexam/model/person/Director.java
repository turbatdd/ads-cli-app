package miu.lesson.midexam.model.person;

public class Director extends Person {
    private String department;

    public Director(String id, String firstName, String lastName,
                    String email, String phone, String department) {
        super(id, firstName, lastName, email, phone);
        this.department = department;
    }

    public String getDepartment() { return department; }

    public void viewQuarterlyAppointments() { }
    public void exportReport()              { }
}
