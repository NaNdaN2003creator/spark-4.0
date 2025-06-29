package collection.collectionDemo;

import java.util.ArrayList;
import java.util.List;

class Student
{
    int id;
    String name;
    String course;

    public Student(int id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
}
public class CustomListDem0 {
    public static void main(String[] args) {
       Student s1 = new Student(1,"arjun","java");
        Student s2 = new Student(2,"anand","Devops");
        Student s3 = new Student(4,"Abhinandan","DSa");

        List<Student> StudentList = new ArrayList<>();
        StudentList.add(s1);
        StudentList.add(s2);
        StudentList.add(s3);
        System.out.println(StudentList);
        }
    }


