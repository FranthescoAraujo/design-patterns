package patterns.builder;

import patterns.strategy.Sql;

public class SqlBuilder implements BuilderInterface {

    protected Sql query;

    public SqlBuilder() {
        query = new Sql();
    }

    @Override
    public BuilderInterface setTable(String table) {
        query.table(table);
        return this;
    }

    @Override
    public BuilderInterface setSelect(String... columns) {
        query.select(columns);
        return this;
    }

    @Override
    public String getSqlAll() {
        return query.getQuery();
    }

}
