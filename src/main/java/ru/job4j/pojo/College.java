package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student st = new Student();
        st.setFullName("Carabas Barabas Barabasovich");
        st.setGroup(0);
        st.setEnrollmentDate(new Date());
        System.out.println(st.getFullName() + " " + st.getGroup() + " " + st.getEnrollmentDate());
    }
}
