//package com.example.fxdiagramdemo;
//
//import de.fxdiagram.core.XDiagram;
//import de.fxdiagram.core.XNode;
//import de.fxdiagram.core.XRoot;
//import de.fxdiagram.core.anchors.ConnectionRouter;
//import de.fxdiagram.core.connection.XConnection;
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.layout.StackPane;
//import javafx.stage.Stage;
////
//public class FXDiagramApp extends Application {
//    @Override
//    public void start(Stage primaryStage) {
//        // Создаем корневой объект диаграммы
//        XRoot root = new XRoot();
//
//        // Создаем саму диаграмму
//        XDiagram diagram = new XDiagram();
//        root.getDiagramContainer().setDiagram(diagram);
//
//        // Создаем узлы
//        XNode node1 = new XNode("Узел 1");
//        XNode node2 = new XNode("Узел 2");
//
//        // Добавляем узлы в диаграмму
//        diagram.getNodes().add(node1);
//        diagram.getNodes().add(node2);
//
//        // Создаем соединение между узлами
//        XConnection connection = new XConnection(node1, node2);
//        connection.setConnectionRouter(ConnectionRouter.MANHATTAN);
//
//        // Добавляем соединение в диаграмму
//        diagram.getConnections().add(connection);
//
//        // Размещаем диаграмму в окне
//        StackPane rootPane = new StackPane(root);
//        Scene scene = new Scene(rootPane, 800, 600);
//        primaryStage.setTitle("FXDiagram Пример");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}
