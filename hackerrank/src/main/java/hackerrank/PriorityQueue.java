package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PriorityQueue {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
    }
}


class Priorities {
    private java.util.PriorityQueue<Student> students;

    Priorities() {
        students = new java.util.PriorityQueue<>();
    }

    List<Student> getStudents(List<String> events) {
        for (String ev : events) {
            executeEvent(ev.split(" "));
        }

        return convertQueueToList();
    }

    private void executeEvent(String[] events) {
        if ("ENTER".equals(events[0])) {
            addStudent(events[1], events[2], events[3]);
        } else if ("SERVED".equals(events[0])) {
            students.poll();
        }
    }

    private void addStudent(String fname, String sCgpa, String sId) {
        int id = Integer.parseInt(sId);
        double cgpa = Double.parseDouble(sCgpa);
        students.add(new Student(id, fname, cgpa));
    }

    private List<Student> convertQueueToList() {
        List<Student> lStudents = new ArrayList<>();

        while (!students.isEmpty()) {
            lStudents.add(students.poll());
        }

        return lStudents;
    }

}