package models;

import java.util.Objects;

public class Patient extends Users {
    public static final String DATABASE_TYPE= "patient";
    private int id;
    public Patient(String firstName, String lastName, String email, String password, String gender, String phone){
        this.email=email;
        this.password=password;
        this.firstName =firstName;
        this.lastName=lastName;
        this.gender=gender;
        this.phone=phone;
        role=DATABASE_TYPE;
    }

    public String getEmail(){return email;}
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
    }
}
