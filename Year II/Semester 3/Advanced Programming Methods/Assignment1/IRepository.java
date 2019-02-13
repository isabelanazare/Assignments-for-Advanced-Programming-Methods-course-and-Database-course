import model.Tree;

public interface IRepository {
    void AddTree(Tree t);
    void removeTree(String name);
    String filterByAge();
}
