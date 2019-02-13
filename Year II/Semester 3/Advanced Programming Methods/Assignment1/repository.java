import model.Tree;

public class repository {

    private Tree[] trees;
    private int size;
    private int index=0;
    public Tree[] getTrees(){return trees;}
    public int getSize(){return size;}
    public repository (int size) {
        this.size = size;
        trees = new Tree[size];
    }
    public void AddTree(Tree t) throws repoexceptions {
        try {
            trees[index++] = t;
        } catch (Exception ex) {
            Tree[] newL = new Tree[size * 2];
            System.arraycopy(trees, 0, newL, 0, size);
            size *= 2;
            trees = newL;
            trees[index++] = t;
        }
    }
    public void removeTree(String name) throws repoexceptions {
        boolean found = false;
        if (index == 0) {
            throw new repoexceptions("The orchard is empty");
        }
        for (int pos = 0; pos < index; ++pos) {
            if (trees[pos].getName().equals(name)) {
                for (int i = pos; i < index; ++i) {
                    trees[i] = trees[i + 1];
                    found = true;
                }
                index--;
            }
        }
        if (!found) {
            throw new repoexceptions("Nonexistent tree");
    }
    }

    public String filterByAge() {
        StringBuilder result = new StringBuilder();
        for (int pos = 0; pos < index; ++pos) {
            if (trees[pos].getAge() >= 3) {
                result.append(trees[pos].getName());
                result.append("\n");
            }
        }
        return String.valueOf(result);
    }
}
