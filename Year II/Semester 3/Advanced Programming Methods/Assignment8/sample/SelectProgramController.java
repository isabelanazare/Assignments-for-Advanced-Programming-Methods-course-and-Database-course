package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SelectProgramController {

    @FXML
    private ListView<String> listView;

    @FXML
    private Button runProgramBTN;

    public static IStmt statement;
    private List<IStmt> StmtList = new ArrayList<IStmt>();


    @FXML
    public void initialize() {

        // programe
        IStmt ex1 = new CompStmt(new AssignStmt("v", new ConstExp(2)), new PrintStmt(new
                VarExp("v")));
        IStmt ex2 = new CompStmt(new AssignStmt("a", new ArithExp("+", new ConstExp(2), new
                ArithExp("*", new ConstExp(3), new ConstExp(5)))),
                new CompStmt(new AssignStmt("b", new ArithExp("+", new VarExp("a"), new
                        ConstExp(1))), new PrintStmt(new VarExp("b"))));
        IStmt ex3 = new CompStmt(new AssignStmt("a", new ArithExp("-", new ConstExp(2), new
                ConstExp(2))),
                new CompStmt(new IfStmt(new VarExp("a"), new AssignStmt("v", new ConstExp(2)), new
                        AssignStmt("v", new ConstExp(3))), new PrintStmt(new VarExp("v"))));

        IStmt ex4 = new CompStmt(
                new openRFile("var_f", "file2.txt"),
                new CompStmt(
                        new readFile(new VarExp("var_f"), "var_c"),
                        new CompStmt(
                                new PrintStmt(new VarExp("var_c")),
                                new CompStmt(
                                        new IfStmt(
                                                new VarExp("var_c"),
                                                new CompStmt(
                                                        new readFile(new VarExp("var_f"), "var_c"),
                                                        new PrintStmt(new VarExp("var_c"))
                                                ),
                                                new PrintStmt(new ConstExp(0))
                                        ),
                                        new CloseRFile(new VarExp("var_f"))
                                )
                        )
                ));
        IStmt ex5 = new CompStmt(
                new openRFile("var_f", "file3.txt"),
                new CompStmt(
                        new readFile(new ArithExp("+", new VarExp("var_f"), new ConstExp(2)), "var_c"),
                        new CompStmt(
                                new PrintStmt(new VarExp("var_c")),
                                new CompStmt(
                                        new IfStmt(
                                                new VarExp("var_c"),
                                                new CompStmt(
                                                        new readFile(new VarExp("var_f"), "var_c"),
                                                        new PrintStmt(new VarExp("var_c"))
                                                ),
                                                new PrintStmt(new ConstExp(0))
                                        ),
                                        new CloseRFile(new VarExp("var_f"))
                                )
                        )
                )
        );

        IStmt ex6 =
                new CompStmt(
                        new AssignStmt("v", new ConstExp(10)),
                        new CompStmt(
                                new NewStmt("v", new ConstExp(20)),
                                new CompStmt(
                                        new NewStmt("a", new ConstExp(22)),
                                        new CompStmt(
                                                new WriteHeapStmt("a", new ConstExp(30)),
                                                new CompStmt(
                                                        new PrintStmt(new VarExp("a")),
                                                        new CompStmt(
                                                                new PrintStmt(new ReadHeapExp("a")),
                                                                new AssignStmt("a", new ConstExp(0)))))
                                )
                        )
                );
        //v=6; (while (v-4) print(v);v=v-1);print(v)
        IStmt ex7 = new CompStmt(
                new AssignStmt("v", new ConstExp(6)),
                new CompStmt(
                        new WhileStmt(new ArithExp("-", new VarExp("v"), new ConstExp(4)),
                                new CompStmt(
                                        new PrintStmt(new VarExp("v")),
                                        new AssignStmt("v", new ArithExp("-", new VarExp("v"), new ConstExp(1)))
                                )),
                        new PrintStmt(new VarExp("v"))));
        IStmt ex8 = new CompStmt(
                new CompStmt(
                        new AssignStmt("v", new ConstExp(10)),
                        new NewStmt("a", new ConstExp(22))
                ),
                new CompStmt(
                        new ForkStmt(
                                new CompStmt(
                                        new WriteHeapStmt("a", new ConstExp(30)),
                                        new CompStmt(
                                                new AssignStmt("v", new ConstExp(32)),
                                                new CompStmt(
                                                        new PrintStmt(new VarExp("v")),
                                                        new PrintStmt(new ReadHeapExp("a"))
                                                )
                                        )
                                )
                        ),
                        new CompStmt(
                                new PrintStmt(new VarExp("v")),
                                new PrintStmt(new ReadHeapExp("a"))
                        )
                )
        );

        StmtList.add(ex1);StmtList.add(ex2);StmtList.add(ex3);StmtList.add(ex4);StmtList.add(ex5);
        StmtList.add(ex6);StmtList.add(ex7);StmtList.add(ex8);

        ObservableList<String> list = FXCollections.observableArrayList();
        for(IStmt i : StmtList)
            list.add(""+i);

        listView.setItems(list);

        listView.getSelectionModel().selectIndices(0);
    }

    @FXML
    public void buttonRun() throws IOException {

        statement = StmtList.get(listView.getSelectionModel().getSelectedIndex());

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("runProgram.fxml"));
        stage.setTitle("Running Program");
        stage.setScene(new Scene(root, 800, 600));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();

    }

}