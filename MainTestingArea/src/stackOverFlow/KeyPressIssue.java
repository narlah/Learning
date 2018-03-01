package stackOverFlow;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;

public class KeyPressIssue extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello World");
        primaryStage.show();
        VBox vBox = new VBox();
        TextField textField = new TextField();
        TextField resultTextField = new TextField();
        Button button = new Button("Enter");
        button.setOnAction(event -> sendKeys(textField.getText()));
        vBox.getChildren().addAll(textField, button, resultTextField);
        primaryStage.setScene(new Scene(vBox, 300, 275));

    }

    private static void sendKeys(String text) {
        try {
            Robot robot = new Robot();
            robot.keyPress(9);
            for (int i = 0; i < text.length(); i++) {
                Thread.sleep(100);
                robot.keyPress((text.charAt(i)));
            }
            robot.keyPress(9);
        } catch (java.awt.AWTException exc) {
            System.out.println("error");
        } catch (InterruptedException e) {
            System.out.println("interrupted!");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

