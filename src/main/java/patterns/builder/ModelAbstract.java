package patterns.builder;

public abstract class ModelAbstract implements DirectorInterface{

    protected BuilderInterface builder;
    protected String table;

    public ModelAbstract(BuilderInterface builder) {
        this.builder = builder;
        setTableName();
    }

    @Override
    public String getSqlAll() {
        builder.setTable(table);
        return builder.getSqlAll();
    }

    @Override
    public ModelAbstract setSelect(String ...columns) {
        builder.setSelect(columns);
        return this;
    }

    protected void setTableName() {
        if (table == null) {
            String[] tableName = getClass().getName().split("\\.");
            table = tableName[tableName.length - 1].toLowerCase();
        }
    }
    
}
