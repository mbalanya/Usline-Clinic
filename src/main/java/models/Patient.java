package models;

import java.util.Objects;

/*
public abstract class Users {

    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public String gender;
    public String phone;
    public String role;
}
*/


public class Patient{
    public static final String DATABASE_TYPE= "patient";
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    public String password;
    private String gender;
    private String phone;
    private String role;

    public Patient(String firstName, String lastName, String email, String password, String gender, String phone){
        this.firstName =firstName;
        this.lastName=lastName;
        this.email=email;
        this.password=password;
        this.gender=gender;
        this.phone=phone;
        role=DATABASE_TYPE;
    }

    public static String getDatabaseType() {
        return DATABASE_TYPE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient patient = (Patient) o;
        return id == patient.id &&
                firstName.equals(patient.firstName) &&
                lastName.equals(patient.lastName) &&
                email.equals(patient.email) &&
                password.equals(patient.password) &&
                gender.equals(patient.gender) &&
                phone.equals(patient.phone) &&
                role.equals(patient.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, password, gender, phone, role);
    }

    /*public String getEmail(){return email;}
    public void setEmail(String email){ this.email=email; }

    public String getPassword(){return password;}
    public void setPassword(String Password){this.password=password;}

    public String getFirtsname(){return firstName;}
    public void setFirstname(String firstname){this.firstName = firstname;}

    public String getLastname(){return lastName;}
    public void setLastname(String lastname){this.lastName = lastName;}

    public String getGender(){return gender;}
    public void setGender(String gender){this.gender = gender;}

    public static String getDatabaseRole() {return DATABASE_TYPE; }
    public void  setDatabaseType(String role){role=DATABASE_TYPE;}

    public int getId() { return id; }
    public void setId(int id) {this.id = id;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient patient = (Patient) o;
        return id == patient.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }*/
}
