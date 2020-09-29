import models.Group;
import models.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {
        ArrayList<Group> groups;
        groups = Group.getAllGroups();
        for (Group group:groups) {
            ArrayList<Student> students;
            students = Student.getStudentsByGroupId(group.getId());
            System.out.println(group.getName()+" students are ");
            for (Student student: students) {
                System.out.println(student.toString());
            }
        }
    }
}
