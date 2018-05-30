package hackerrank;

public class Student implements Comparable {
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


    public String getName() {
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