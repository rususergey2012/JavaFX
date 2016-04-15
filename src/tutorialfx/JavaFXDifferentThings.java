package tutorialfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class JavaFXDifferentThings extends Application {

    private Button btnOKEdit;
    private Button btnOK;
    private Button btnEdit;
    private Button btnCancel;
    private Stage stage;
    private Scene scene1;
    private Scene scene2;

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Login");
        primaryStage.setWidth(400);
        primaryStage.setHeight(250);
        primaryStage.setMaxWidth(400);
        primaryStage.setMaxHeight(250);
        stage = primaryStage;

//        BorderPane root = new BorderPane();
        Pane root = new Pane();

        btnOK = addButton("OK");
        btnEdit = addButton("Edit");
        btnCancel = addButton("Cancel");
        btnOKEdit = addButton("OK");

        btnCancel.setOnMousePressed(event -> {
            primaryStage.close();
        });

        Label labelUSER = addLabel("USER");
        Label labelPASSWORD = addLabel("PASSWORD");
        Label labelOLD_PASSWORD = addLabel("OLD PASSWORD");
        Label labelNEW_PASSWORD = addLabel("NEW PASSWORD");
        Label labelCONFIRM_PASSWORD = addLabel("CONFIRM PASSWORD");

        HBox hboxButton = new HBox(60);
        HBox hboxUser = new HBox(60);
        HBox hboxPass = new HBox(60);

        VBox vboxPassUser = new VBox(15);

        TextField textField1 = addTextField();
        TextField textField2 = addTextField();
        TextField textField3 = addTextField();
        TextField textField4 = addTextField();

        PasswordField passwordField2 = addPasswordField();

        btnOK.setOnMousePressed(event -> {
            if ((!textField1.getText().equals("sergey"))
                    || (!passwordField2.getText().equals("1234"))) {
                System.out.println("Your UserName or password is incorrect!");
            } else {
                System.out.println("Your UserName & password is correct!");
            }
            textField1.clear();
            passwordField2.clear();
        });
        btnEdit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.setTitle("Edit Password");
                primaryStage.setWidth(400);
                primaryStage.setHeight(250);
                primaryStage.setMaxWidth(400);
                primaryStage.setMaxHeight(250);

                HBox hboxOldPass = new HBox(60);
                HBox hboxNewPass = new HBox(60);
                HBox hboxConfNewPass = new HBox(60);
                HBox hboxButton = new HBox(30);

                hboxOldPass.getChildren().addAll(labelOLD_PASSWORD, textField2);
                hboxOldPass.setTranslateX(10);
                hboxOldPass.setTranslateY(10);

                hboxNewPass.getChildren().addAll(labelNEW_PASSWORD, textField3);
                hboxNewPass.setTranslateX(10);
                hboxNewPass.setTranslateY(40);

                hboxConfNewPass.getChildren().addAll(labelCONFIRM_PASSWORD, textField4);
                hboxConfNewPass.setTranslateX(10);
                hboxConfNewPass.setTranslateY(70);

                hboxButton.getChildren().addAll(btnOKEdit, btnCancel);
                hboxButton.setTranslateX(70);
                hboxButton.setTranslateY(120);

                Pane root2 = new Pane();

                root2.getChildren().addAll(hboxOldPass, hboxNewPass, hboxConfNewPass, hboxButton);
                scene2 = new Scene(root2);
//                primaryStage.setScene(scene2);
                stage.setScene(scene2);
            }
        });

        btnOKEdit.setOnAction(e -> HandleButtonAction(e));

//        VGap vgap = new VGap();
        
    final Popup popup = new Popup(); popup.setX(300); popup.setY(200);
//    popup.getContent().addAll(new Circle(25, 25, 50, Color.AQUAMARINE));
    

popup.getContent().addAll();

    Button show = new Button("About Author");
    
    show.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent event) {
        popup.show(primaryStage);
      }
    });
        
        
        hboxUser.getChildren().addAll(labelUSER, textField1);
        hboxUser.setTranslateX(10);
        hboxUser.setTranslateY(10);
        hboxPass.getChildren().addAll(labelPASSWORD, passwordField2);
        hboxPass.setTranslateX(10);
        hboxPass.setTranslateY(40);
//        vboxPassUser.getChildren().addAll(hboxUser, hboxPass);
//        vboxPassUser.setSpacing(85);

        hboxButton.getChildren().addAll(btnOK, btnEdit, btnCancel);
        hboxButton.setTranslateX(10);
        hboxButton.setTranslateY(80);

        /*
                BorderPane
         */
//        root.setTop(hboxUser);
//        root.setCenter(hboxPass);
//        root.setBottom(hboxButton);

        /*
                Pane
         */
        root.getChildren().addAll(hboxUser, hboxPass, hboxButton,show);

        scene1 = new Scene(root);
        primaryStage.setScene(scene1);
        primaryStage.show();

    }

    private Button addButton(String name) {
        Button btn = new Button(name);
        btn.setPrefSize(70, 20);

        btn.setOnMouseEntered(event
                -> {
            btn.setRotate(0);
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
        label.setPrefSize(170, 20);
        label.setTextFill(Color.web("#0076a3"));
        label.setFont(Font.font("Cambria", 14));
        label.setAlignment(Pos.CENTER_LEFT);
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
        passwordField.setPromptText("Enter your password");
//        textField.setAlignment(Pos.CENTER);
        return passwordField;
    }

    private void HandleButtonAction(ActionEvent event) {

        if (event.getTarget() == btnOKEdit) {
            stage.setScene(scene1);
        }
//     else{
//         stage.setScene(scene1);
//     }

    }

    public static void main(String[] args) {
        launch(args);
    }

}
