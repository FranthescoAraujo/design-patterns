package patterns.builder;

public interface DirectorInterface {

    public String getSqlAll();
    public ModelAbstract setSelect(String ...columns);
    
}
