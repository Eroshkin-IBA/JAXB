package com.JAXB.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@XmlRootElement(name = "organization")
@XmlAccessorType(XmlAccessType.FIELD)
public class Organization {
private String orgName;
private String city;

@XmlElementWrapper(name = "departments")
@XmlElement(name = "department")
private ArrayList<Department> departments;

    public Organization() {
    }


    public Organization(String orgName, String city) {
        this.orgName = orgName;
        this.city = city;

    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(ArrayList<Department> departments) {
        this.departments = departments;
    }
}
