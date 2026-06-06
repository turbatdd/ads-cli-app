package miu.lesson.midexam.model.person;

public abstract class Person {
    protected String id;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String phone;

    protected Person(String id, String firstName, String lastName, String email, String phone) {
        this.id        = id;
        this.firstName = firstName;
        this.lastName  = lastName;
        this.email     = email;
        this.phone     = phone;
    }

    public String getId()        { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName()  { return lastName; }
    public String getEmail()     { return email; }
    public String getPhone()     { return phone; }
}
