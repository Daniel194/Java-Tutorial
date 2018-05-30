package hackerrank;

import java.util.Set;
import java.util.TreeSet;

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
