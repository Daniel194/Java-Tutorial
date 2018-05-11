package hackerrank;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class Student implements Comparable {
    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }

    public int compareTo(Object o) {
        Student s;
        int result = 0;

        if (o instanceof Student) {
            s = (Student) o;
        } else {
            throw new IllegalArgumentException("Please provide a Student !");
        }

        result = (int) (s.getCgpa() * 100 - this.cgpa * 100);
        result += result == 0 ? this.fname.compareTo(s.getFname()) : 0;
        result += result == 0 ? this.id - s.getId() : 0;

        return result;
    }
}

public class JavaSort {

    public static void main(String[] args) {
        Set<Student> studentList = new TreeSet<Student>();
        studentList.add(new Student(56, "Samiha", 3.75));
        studentList.add(new Student(19, "Samara", 3.75));
        studentList.add(new Student(33, "Rumpa", 3.68));

        for (Student st : studentList) {
            System.out.println(st.getFname());
        }
    }

}
