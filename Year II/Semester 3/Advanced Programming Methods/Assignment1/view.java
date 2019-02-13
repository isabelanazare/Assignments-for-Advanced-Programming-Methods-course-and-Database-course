import model.AppleTree;
import model.PearTree;
import model.CherryTree;

public class view {
    public static void main(String[] args) throws repoexceptions {
        repository repo= new repository(100);
        controller ctrl = new controller(repo);
        AppleTree t1 = new AppleTree("AppleTree1", 254);
        AppleTree t2 = new AppleTree("AppleTree2", 1);

        PearTree t3 = new PearTree("PearTree1", 23);
        PearTree t4 = new PearTree("PearTree2", 2);

        CherryTree t5 = new CherryTree("CherryTree1", 40);
        CherryTree t6 = new CherryTree("CherryTree2", 34);
        CherryTree t7 = new CherryTree("CherryTree3", 50);

        try {
            ctrl.AddTree(t1);
            ctrl.AddTree(t2);
            ctrl.AddTree(t3);
            ctrl.AddTree(t4);
            ctrl.AddTree(t5);
            ctrl.AddTree(t6);
            ctrl.AddTree(t7);

            ctrl.removeTree("AppleTree1");
            ctrl.removeTree("CherryTree3");

        } catch (repoexceptions e) {
            System.out.print(e);
        }
        System.out.print("Trees(age>=3): \n");
        System.out.print(ctrl.filterByAge());
    }
}
