package com.example.assg_2;

public class Students {

    String fName, mName, lName, id, regNo, gender, s_course, s_department, s_school;
    String s1_unitName, s1_unitCode;

    public Students(String fName, String mName, String lName, String id, String regNo, String gender, String s_course, String s_department, String s_school) {
        this.fName = fName;
        this.mName = mName;
        this.lName = lName;
        this.id = id;
        this.regNo = regNo;
        this.gender = gender;
        this.s_course = s_course;
        this.s_department = s_department;
        this.s_school = s_school;
    }
    public Students(){}

    public String getfName() {
        return fName;
    }

    public String getmName() {
        return mName;
    }

    public String getlName() {
        return lName;
    }

    public String getId() {
        return id;
    }

    public String getRegNo() {
        return regNo;
    }

    public String getGender() { return gender;   }

    public String getS_course() {
        return s_course;
    }

    public String getS_department() {
        return s_department;
    }

    public String getS_school() {
        return s_school;
    }

    public String getS1_unitName() {
        return s1_unitName;
    }

    public String getS1_unitCode() {
        return s1_unitCode;
    }
}
