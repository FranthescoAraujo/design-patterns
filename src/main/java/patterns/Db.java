package patterns;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import patterns.builder.DirectorInterface;

public class Db {

    private Connection connection;
    private DirectorInterface director;
    private String sql;

    public Db(String connection, String user, String password) throws SQLException {
        this.connection = DriverManager.getConnection(connection, user, password);
    }

    public Db setDirector(DirectorInterface director) {
        this.director = director;
        return this;
    }

    public Connection getConnection() {
        return connection;
    }

    public Db getAll() {
        sql = director.getSqlAll();
        return this;
    }

    public ResultSet execute() throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(sql);
    }

}