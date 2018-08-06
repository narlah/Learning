package interviewPickings.hackerRank;

import java.util.*;

class Student {
    int id;
    String name;
    double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cgpa=" + cgpa +
                '}';
    }

}

class Priorities {
    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.cgpa != o2.cgpa) {
                return o1.cgpa < o2.cgpa ? 1 : -1;
            } else if (!o1.name.contentEquals(o2.name)) {
                return o1.name.compareTo(o2.name);
            } else {
                return o1.id < o2.id ? 1 : -1;
            }
        });
        for (String e : events) {
            if (e.startsWith("ENTER")) {
                String[] eArr = e.split(" ");
                queue.add(new Student(Integer.parseInt(eArr[3]), eArr[1], Double.parseDouble(eArr[2])));
            } else if (queue.size() > 0) {
                queue.remove();
            }
        }
        int size = queue.size();
        Student[] studentArr = new Student[size];
        for (int i = 0; i < size; i++) {
            studentArr[i] = queue.remove();
        }
        return Arrays.asList(studentArr);
    }
}

public class JavaPriorityQueue {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        String[] arr = new String[]{
                "ENTER Bidhan 3.75 50",
                "ENTER Rijul 3.8 24",
                "ENTER Shafaet 3.7 35",
                "SERVED",
                "SERVED",
                "ENTER Samiha 3.85 36",
                "SERVED",
                "ENTER Ratul 3.9 42",
                "ENTER Tanvir 3.6 46",
                "ENTER Anik 3.95 49",
                "ENTER Nisha 3.95 50",
                "SERVED",
                "SERVED",
                "SERVED",
                "SERVED",
                "SERVED",
                "SERVED",
                "SERVED",
                "SERVED",
                "SERVED",
                "SERVED"
        };
        List<String> events = new ArrayList<>();
        for (String s : arr) {
            events.add(s);
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