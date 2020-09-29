package models;

import lombok.Data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@Data
public class Group{
    int id;
    String name;

    public Group() {

    }
    public Group(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Group { id = " + id + ", name = " + name + "} ";
    }

    public static ArrayList<Group> getAllGroups() throws SQLException {
        Connection connection;
        ArrayList<Group> collection = new ArrayList<Group>();
        connection = new DBConnection().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(
                "select * from groups"
        );
        while (resultSet.next()){
            collection.add(new Group(resultSet.getInt(1),resultSet.getString(2)));
        }

        connection.close();

        return collection;
    }
}
