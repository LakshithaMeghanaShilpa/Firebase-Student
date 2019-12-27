package com.example.firebasestudent;

public class students {

    private String studentid;
    private String studentName;
    private String studentUSN;
    private String studentspecialization;
    private String studentdept;

    public students(String studentid, String studentName, String studentUSN, String studentspecialization, String studentdept) {
        this.studentid = studentid;
        this.studentName = studentName;
        this.studentUSN = studentUSN;
        this.studentspecialization = studentspecialization;
        this.studentdept = studentdept;
    }

    public String getStudentid() {
        return studentid;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentUSN() {
        return studentUSN;
    }

    public String getStudentspecialization() {
        return studentspecialization;
    }

    public String getStudentdept() {
        return studentdept;
    }

    public students(){

    }





}
