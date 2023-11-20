package patterns.strategy;

public class MySql extends Sql {

    @Override
    public Strategy table(String table) {
        this.table = "`" + table + "`";
        return this;
    }

    @Override
    public Strategy select(String ...columns) {
        String[] columnsArray;
        if (columns.length == 0) {
            return this;
        } else if (columns.length == 1)  {
            columnsArray = columns[0].split(",");
        } else {
            columnsArray = columns;
        }
        String retorno = "";
        for(String column: columnsArray) {
            if (column.equals("*")) {
                retorno += column + ", ";
                continue;
            }
            retorno += "`" + column.trim() + "`, ";
        }
        this.columns = retorno.substring(0, retorno.length() - 2);
        return this;
    }

}