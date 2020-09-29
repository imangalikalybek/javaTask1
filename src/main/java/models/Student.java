package models;

import lombok.Data;

import java.sql.*;
import java.util.ArrayList;

@Data
public class Student {
    int id;
    int groupId;
    String name;
    String phone;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getGroupId() {
        return groupId;
    }
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Student() {

    }
    public Student(int id, int groupId, String name, String phone) {
        this.id = id;
        this.groupId = groupId;
        this.name = name;
        this.phone = phone;
    }

    public static ArrayList<Student> getStudentsByGroupId(int id) throws SQLException {
        Connection connection;
        ArrayList<Student> collection = new ArrayList<Student>();
        connection = new DBConnection().getConnection();
        String sql = "select * from students where group_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,id);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            collection.add(new Student(resultSet.getInt(1),resultSet.getInt(2),
                    resultSet.getString(3),resultSet.getString(4)));
        }
        connection.close();

        return collection;
    }

    @Override
    public String toString() {
        return "Student { id = " + id + ", groupId = " + groupId +
                ", name = " + name + ", phone='" + phone + "} ";
    }

}
