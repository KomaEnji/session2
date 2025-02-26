package com.example.session2fx;

import com.example.session2fx.model.Department;
import com.example.session2fx.model.Worker;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.util.Arrays;
import java.util.List;

public class WorkerManagementController{
    @FXML
    public TreeView<Department> treeViewDep;
    @FXML
    public ListView<Worker> listViewWorker;

    private final DataHandler dataHandler = new DataHandler();

    private void buildDepartmentTree(TreeItem<Department> parentItem, List<Department> allDepartments) {
        int parentId = parentItem.getValue().getDepartmet_id();
        for (Department dep : allDepartments) {
            if (dep.getEnclose_code() == parentId) {
                TreeItem<Department> childItem = new TreeItem<>(dep);
                parentItem.getChildren().add(childItem);

                buildDepartmentTree(childItem, allDepartments);
            }
        }
    }

    //    private void buildWorkerList(Department selectedItem, List<Worker> allWorkers) {
//
//        for (Worker workers : allWorkers) {
//            if (selectedItem.getDepartmet_id() == workers.getFk_department_id()) {
//
//            }
//
//        }
//    }


    @FXML
    public void initialize(){
//        TreeItem<String> root = new TreeItem<>("aga");
//        root.getChildren().addAll(
//        new TreeItem<>("1"),
//        new TreeItem<>("2")
//        );
//        treeViewDep.setRoot(root);

        List<Department> departments = dataHandler.selectDepartments();

        Department company = new Department(0, "Компания", "", 0, "Генеральный директор");
        TreeItem<Department> rootItem = new TreeItem<>(company);
        rootItem.setExpanded(true);

        buildDepartmentTree(rootItem, departments);
        treeViewDep.setRoot(rootItem);

       treeViewDep.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
           Department selectedItem = newValue.getValue();
           
           listViewWorker.setItems(dataHandler.selectWorkers(selectedItem.getDepartmet_id()));

       });





//        System.out.println(root.getChildren().indexOf());



//        TreeItem<String> root = new TreeItem<String>("Root Node");
//        root.setExpanded(true);
//        root.getChildren().addAll(
//                new TreeItem<String>("Item 1"),
//                new TreeItem<String>("Item 2"),
//                new TreeItem<String>("Item 3")
//        );
//        treeViewDep = new TreeView<String>(root);




//        List<Department> departments = dataHandler.SelectDepartments();
//        for (Department dep:departments) {
//            if (dep.getEnclose_code() == dep.getDepartmet_id()-1) {
//                TreeItem<String> root = new TreeItem<>(dep.getDepartment());
//                if (dep.getEnclose_code() == dep.getDepartmet_id()){
//                    root.getChildren().add(new TreeItem<String>(dep.getDepartment()));
//                }
//
//            }
//        }

//        TreeItem<String> rootItem = new TreeItem<String>(departments.toString());
//        rootItem.getChildren().addAll(
//                new TreeItem[]{new TreeItem<>(departments)}
//
//        );
//            treeViewDep.setRoot(rootItem);

//        private void buildDepartmentTree(TreeItem<Department> parentItem, Map<Integer, List<Department>> departmentsByParent, int parentId) {
//            List<Department> children = departmentsByParent.get(parentId);
//            if (children != null) {
//                for (Department dep : children) {
//                    TreeItem<Department> childItem = new TreeItem<>(dep);
//                    parentItem.getChildren().add(childItem);
//                    buildDepartmentTree(childItem, departmentsByParent, dep.getId());
//                }
//            }
//        }



    }

}
