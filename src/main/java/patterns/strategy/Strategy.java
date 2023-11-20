package patterns.strategy;

public interface Strategy {
    public Strategy table(String table);
    public Strategy select(String ...columns);
    public String getQuery();
}