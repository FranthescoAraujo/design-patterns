package patterns.builder;

public interface BuilderInterface {

    public BuilderInterface setTable(String table);
    public BuilderInterface setSelect(String ...columns);
    public String getSqlAll();

}
