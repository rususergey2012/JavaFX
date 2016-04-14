///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package javafxdifferentthings;
//
//import javafx.application.Application;
//import static javafx.application.Application.launch;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.PasswordField;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.Pane;
//import javafx.scene.layout.StackPane;
//import javafx.scene.layout.VBox;
//import javafx.scene.paint.Color;
//import javafx.stage.Stage;
//
///**
// *
// * @author sergey
// */
//public class JavaFXDifferentThings extends Application {
//    
//    @Override
//    public void start(Stage primaryStage) {
//        Button btn = new Button();
//        btn.setText("Say 'Hello World'");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
//            }
//        });
//        
//        StackPane root = new StackPane();
//        root.getChildren().add(btn);
//        
//        Scene scene = new Scene(root, 300, 250);
//        
//        primaryStage.setTitle("Hello World!");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        launch(args);
//    }
//    
//}
package tutorialfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class JavaFXDifferentThings extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Login");
        primaryStage.setWidth(400);
        primaryStage.setHeight(150);
        primaryStage.setMaxWidth(400);
        primaryStage.setMaxHeight(150);

        BorderPane root = new BorderPane();
        

        Button btn1 = addButton("OK");
        Button btn2 = addButton("Edit");
        Button btn3 = addButton("Cancel");
        Button btn4 = addButton("OK");

        btn3.setOnMousePressed(event -> {
            primaryStage.close();
        });

        Label label1 = addLabel("USER");
        Label label2 = addLabel("PASSWORD");
        Label label3 = addLabel("OLD PASSWORD");
        Label label4 = addLabel("NEW PASSWORD");
        Label label5 = addLabel("CONFIRM NEW PASSWORD");

        HBox hboxButton = new HBox(15);
        HBox hboxUser = new HBox(15);
        HBox hboxPass = new HBox(15);

        VBox vboxPassUser = new VBox(15);

        TextField textField1 = addTextField();
        TextField textField2 = addTextField();
        TextField textField3 = addTextField();
        TextField textField4 = addTextField();
        
        
        PasswordField passwordField2 = addPasswordField();

        btn1.setOnMousePressed(event -> {
            if ((!textField1.getText().equals("sergey"))
                    || (!passwordField2.getText().equals("1234"))) {
                System.out.println("Your UserName or password is incorrect!");
            } else {
                System.out.println("Your UserName & password is correct!");
            }
            textField1.clear();
            passwordField2.clear();
        });
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setTitle("Edit Password");
                primaryStage.setWidth(400);
                primaryStage.setHeight(150);
                primaryStage.setMaxWidth(400);
                primaryStage.setMaxHeight(150);
                
                HBox hboxOldPass = new HBox(15);
                HBox hboxNewPass = new HBox(15);
                HBox hboxConfNewPass = new HBox(15);
                hboxOldPass.getChildren().addAll(label3, textField2);
                hboxNewPass.getChildren().addAll(label4, textField3);
                hboxConfNewPass.getChildren().addAll(label5, textField4);
                
                
                Pane root2 = new Pane();
                
                
                
                
                
                
                root2.getChildren().addAll(hboxOldPass, hboxNewPass, hboxConfNewPass, btn4, btn3);
                Scene scene2 = new Scene(root2);
                primaryStage.setScene(scene2);
            }
        });

        btn4.setOnMousePressed( event -> {
                
//            root.st
                    
                    
        });
        
        hboxUser.getChildren().addAll(label1, textField1);
        hboxPass.getChildren().addAll(label2, passwordField2);

        vboxPassUser.getChildren().addAll(hboxUser, hboxPass);
        vboxPassUser.setSpacing(85);

        hboxButton.getChildren().addAll(btn1, btn2, btn3);

        /*
        BorderPane 
         */
        root.setTop(hboxUser);
        root.setCenter(hboxPass);
        root.setBottom(hboxButton);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private Button addButton(String name) {
        Button btn = new Button(name);
        btn.setPrefSize(70, 20);

        btn.setOnMouseEntered(event
                -> {
            btn.setRotate(15);
            btn.setScaleX(1.1);
            btn.setScaleY(1.1);
            btn.setText(name);
        });
        btn.setOnMouseExited(event
                -> {
            btn.setScaleX(1);
            btn.setScaleY(1);
            btn.setText(name);
            btn.setRotate(0);
        });

        return btn;
    }

    private Label addLabel(String name) {
        Label label = new Label(name);
        label.setPrefSize(70, 20);
        label.setTextFill(Color.web("#0076a3"));
        label.setAlignment(Pos.CENTER);
        return label;
    }

    private TextField addTextField() {
        TextField textField = new TextField();
        textField.setPrefSize(120, 20);
//        textField.setAlignment(Pos.CENTER);
        return textField;
    }

    private PasswordField addPasswordField() {
        PasswordField passwordField = new PasswordField();
        passwordField.setPrefSize(120, 20);
        passwordField.setPromptText("Your password");
//        textField.setAlignment(Pos.CENTER);
        return passwordField;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
