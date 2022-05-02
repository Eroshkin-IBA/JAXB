package com.JAXB.test;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import com.JAXB.model.*;

public class TestExample {
    private static final String XML_FILE = "dept-info.xml";

    public static void main(String[] args) {

        Employee emp1 = new Employee("E01", "Tom", null);
        Employee emp2 = new Employee("E02", "Mary", "E01");
        Employee emp3 = new Employee("E03", "John", null);

        List<Employee> list = new ArrayList<Employee>();
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);

        Department dept = new Department("D01", "ACCOUNTING", "NEW YORK");
        Department dept1 = new Department("D02", "DEPCOUNTING", "NEW JERSI");
        ArrayList<Department> list1 = new ArrayList<Department>();
        list1.add(dept);
        list1.add(dept1);

        Organization organization = new Organization("Vavilone","Minsk");
        organization.setDepartments(list1);

        dept.setEmployees(list);
        dept1.setEmployees(list);
        try {
            // create JAXB context and instantiate marshaller
            JAXBContext context = JAXBContext.newInstance(Organization.class);

            // (1) Marshaller : Java Object to XML content.
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            m.marshal(organization, System.out);

            // Write to File
            File outFile = new File(XML_FILE);
            m.marshal(organization, outFile);

            System.err.println("Write to file: " + outFile.getAbsolutePath());
            // (2) Unmarshaller : Read XML content to Java Object.
            Unmarshaller um = context.createUnmarshaller();

            // XML file create before.


            Organization orgFromFile1 = (Organization) um.unmarshal(new FileReader(
                    XML_FILE));
            List<Department> deps= orgFromFile1.getDepartments();
            System.out.println("organization: " + orgFromFile1.getOrgName());
            for (Department d : deps) {
                System.out.println("    Department: " + d.getDeptName());
                for (Employee e: d.getEmployees()) {
                    System.out.println("        Employee: " + e.getEmpName());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
