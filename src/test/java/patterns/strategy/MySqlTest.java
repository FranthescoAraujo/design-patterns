package patterns.strategy;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MySqlTest {

    @Test
    public void testSelectQuery() {
        Sql sql = new MySql();
        String query = sql.table("users")
                          .getQuery();
        assertEquals("SELECT * FROM `users`;", query);
    }

    @Test
    public void testSelectQueryWithNoSelect() {
        Sql sql = new MySql();
        String query = sql.table("users")
                          .select()
                          .getQuery();
        assertEquals("SELECT * FROM `users`;", query);
    }

    @Test
    public void testSelectQueryWithColumns() {
        Sql sql = new MySql();
        String query = sql.table("users")
                          .select("username, password")
                          .getQuery();
        assertEquals("SELECT `username`, `password` FROM `users`;", query);
    }

    @Test
    public void testSelectQueryWithArray() {
        Sql sql = new MySql();
        String query = sql.table("users")
                          .select("username", "password")
                          .getQuery();
        assertEquals("SELECT `username`, `password` FROM `users`;", query);
    }

}