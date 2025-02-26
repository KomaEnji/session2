//
//import com.example.dao.DatabaseService;
//import com.example.model.Department;
//import com.example.model.Employee;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TreeItem;
//import javafx.scene.control.TreeView;
//import javafx.scene.control.cell.PropertyValueFactory;
//
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//public class OrgStructureController {
//
//    @FXML
//    private TreeView<Department> departmentsTreeView;
//
//    @FXML
//    private TableView<Employee> employeesTableView;
//
//    @FXML
//    private TableColumn<Employee, String> fullNameColumn;
//    @FXML
//    private TableColumn<Employee, String> departmentColumn;
//    @FXML
//    private TableColumn<Employee, String> positionColumn;
//    @FXML
//    private TableColumn<Employee, String> phoneColumn;
//    @FXML
//    private TableColumn<Employee, String> officeColumn;
//    @FXML
//    private TableColumn<Employee, String> emailColumn;
//
//    private final DatabaseService dbService = new DatabaseService();
//
//    @FXML
//    public void initialize() {
//        // Инициализация таблицы сотрудников
//        fullNameColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));
//        departmentColumn.setCellValueFactory(new PropertyValueFactory<>("departmentName"));
//        positionColumn.setCellValueFactory(new PropertyValueFactory<>("position"));
//        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
//        officeColumn.setCellValueFactory(new PropertyValueFactory<>("office"));
//        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
//
//        // Построение иерархии подразделений
//        List<Department> departments = dbService.getAllDepartments();
//        // Группируем подразделения по родительскому ID; если parentId == null, считаем это корневым
//        Map<Integer, List<Department>> departmentsByParent = departments.stream().collect(Collectors.groupingBy(dep -> dep.getParentId() == null ? 0 : dep.getParentId()));
//
//        // Корневой узел (в макете верхушка – компания)
//        Department company = new Department(0, "Компания", null);
//        TreeItem<Department> rootItem = new TreeItem<>(company);
//        buildDepartmentTree(rootItem, departmentsByParent, 0);
//        departmentsTreeView.setRoot(rootItem);
//        departmentsTreeView.setShowRoot(true);
//
//        // Обработка выбора узла
//        departmentsTreeView.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> {
//            if (newValue != null) {
//                loadEmployees(newValue.getValue().getId());
//            }
//        });
//    }
//
//    // Рекурсивное построение дерева подразделений
//    private void buildDepartmentTree(TreeItem<Department> parentItem, Map<Integer, List<Department>> departmentsByParent, int parentId) {
//        List<Department> children = departmentsByParent.get(parentId);
//        if (children != null) {
//            for (Department dep : children) {
//                TreeItem<Department> childItem = new TreeItem<>(dep);
//                parentItem.getChildren().add(childItem);
//                buildDepartmentTree(childItem, departmentsByParent, dep.getId());
//            }
//        }
//    }
//
//
//    // Загрузка сотрудников для выбранного подразделения (с учетом дочерних подразделений)
//    private void loadEmployees(int departmentId) {
//        List<Employee> employees = dbService.getEmployeesByDepartment(departmentId);
//        ObservableList<Employee> observableEmployees = FXCollections.observableArrayList(employees);
//        employeesTableView.setItems(observableEmployees);
//    }
//}