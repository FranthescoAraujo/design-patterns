package patterns.builder;

import patterns.strategy.MySql;

public class MySqlBuilder extends SqlBuilder {

    public MySqlBuilder() {
        query = new MySql();
    }
    
}
