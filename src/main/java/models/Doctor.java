package models;

import java.util.Objects;

public class Doctor extends Users {
    private static final String DATABASE_TYPE= "doctor";
    private int id;
    public Doctor(String email,String password,String firstName,String lastName,String gender,String phone){
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

    public String getFirstName(){return firstName;}
    public void setFirstName(String firstName){this.firstName = firstName;}

    public String getLastName(){return lastName;}
    public void setLastName(String lastName){this.lastName = lastName;}

    public String getGender(){return gender;}
    public void setGender(String gender){this.gender = gender;}

    public static String getDatabaseRole() {return DATABASE_TYPE; }
    public void  setDatabaseType(String role){role=DATABASE_TYPE;}

    public int getId() { return id; }
    public void setId(int id) {this.id = id;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doctor)) return false;
        Doctor doctor = (Doctor) o;
        return id == doctor.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
