package models;

import java.util.Date;

public class Appointment {
    private int id;
    private Date day;
    private Date startTime;
    private Date endTime;
    private int patid;
    private int docid;

    public Appointment(Date day, Date startTime, Date endTime, int patid, int docid) {
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.patid = patid;
        this.docid = docid;
    }

    public int getId() { return id; }
    public void setId(int id) {this.id = id; }

    public Date getDay() { return day; }
    public void setDay(Date day) {this.day = day;}

    public Date getStartTime() {return startTime;}
    public void setStartTime(Date startTime) {this.startTime = startTime;}

    public Date getEndTime() {return endTime;}
    public void setEndTime(Date endTime) {this.endTime = endTime;}

    public int getPatid() {return patid; }
    public void setPatid(int patid) {this.patid = patid;}

    public int getDocid() { return docid;}
    public void setDocid(int docid) {this.docid = docid;}
}

