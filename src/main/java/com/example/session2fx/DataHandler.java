package com.example.session2fx;

import com.example.session2fx.model.Department;
import com.example.session2fx.model.Worker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;


public class DataHandler {
Connection connection;
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5431/postgres", "postgres", "postgres");
        return connection;
    }

   public static DataHandler dataHandler = new DataHandler();

    public ObservableList<Department> selectDepartments() {
        ObservableList<Department> departmentList = FXCollections.observableArrayList();
        try {

            Connection connection1 = dataHandler.getConnection();
            Statement st = connection1.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.department");
            while(rs.next()){
                departmentList.add(new Department(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5)
                        )
                );
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return departmentList;
    }
    public ObservableList<Worker> selectWorkers(int id) {
    ObservableList<Worker> workerList = FXCollections.observableArrayList();
        try {
            Connection connection1 = dataHandler.getConnection();
            Statement statement = connection1.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM public.worker" +
                    " WHERE fk_departament_id = "+id+";");
            while(rs.next()){
                workerList.add(new Worker(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8)
                ));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return workerList;
    }
}
