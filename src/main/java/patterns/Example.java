package patterns;

import java.sql.ResultSet;

import patterns.app.Users;
import patterns.builder.DirectorInterface;
import patterns.builder.MySqlBuilder;

public class Example {

    private static final String CONNECTION = "jdbc:mysql://localhost:3306/patterns";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) throws Exception {
        DirectorInterface director = new Users(new MySqlBuilder()).setSelect("id", "password");
        ResultSet resultSet = DbSingleton.getInstance(CONNECTION, USER, PASSWORD)
                                         .setDirector(director)
                                         .getAll()
                                         .execute();

        while(resultSet.next()) {
            System.out.println(resultSet.getString(1) + " - " + resultSet.getString(2));
        }
    }

}