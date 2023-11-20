package patterns.strategy;

public class Sql implements Strategy {

    protected String table;
    protected String columns = "*";

    @Override
    public Strategy table(String table) {
        this.table = table;
        return this;
    }

    @Override
    public Strategy select(String ...columns) {
        if (columns.length == 0) {
            return this;
        }
        String retorno = "";
        for(String column: columns) {
            retorno += column + ", ";
        }
        this.columns = retorno.substring(0, retorno.length() - 2);
        return this;
    }

    @Override
    public String getQuery() {
        return "SELECT " + columns + " FROM " + table + ";";
    }

}