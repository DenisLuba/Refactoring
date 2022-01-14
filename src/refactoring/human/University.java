package refactoring.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Student> students = new ArrayList<>();
    public String name;
    public int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        for (Student student : students)
            if (student.getAverageGrade() == averageGrade) return student;
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        double maxAverageGrade = 0;
        Student s = null;
        for (Student student : students)
            if (student.getAverageGrade() > maxAverageGrade) {
                maxAverageGrade = student.getAverageGrade();
                s = student;
            }
        return s;
    }

    public void getStudentWithMinAverageGradeAndExpel() {
        //T0D0:
    }

    public Student getStudentWithMinAverageGrade() {
        double maxAverageGrade = students.get(0).getAverageGrade();
        Student s = students.get(0);
        for (Student student : students) {
            if (s == student) continue;
            if (student.getAverageGrade() < maxAverageGrade) {
                maxAverageGrade = student.getAverageGrade();
                s = student;
            }
        }
        return s;
    }

    public void expel(Student student) {
        students.remove(student);
    }
}
