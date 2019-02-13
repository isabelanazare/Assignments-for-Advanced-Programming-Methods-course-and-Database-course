import model.Tree;

public class controller {
    private repository repo;

    public controller(repository repo) throws repoexceptions {
        this.repo=repo;
    }
    public Tree[] getRepo(){ return repo.getTrees(); }
    public int getSize(){return repo.getSize();}
    public void AddTree(Tree t) {
        try {
            repo.AddTree(t);
        } catch (repoexceptions e) {
            System.out.print(e);
        }
    }
    public void removeTree(String name) throws repoexceptions {
        repo.removeTree(name);
    }

    public String filterByAge() {
        return repo.filterByAge();
    }
}
