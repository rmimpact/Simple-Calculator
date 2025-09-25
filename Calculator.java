import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import java.nio.file.Paths;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class Calculator extends Application {

    @Override
    public void start (Stage primaryStage) {
        //First Number Row
        HBox row1 = new HBox(10);
        Label fNumLabel = new Label("First number:");
        TextField fNumField = new TextField("");
        row1.getChildren().addAll(fNumLabel, fNumField);

        //Second Number Row
        HBox row2 = new HBox(10);
        Label sNumLabel = new Label("Second number:");
        TextField sNumField = new TextField("");
        row2.getChildren().addAll(sNumLabel, sNumField);

        //Operation Row
        HBox row3 = new HBox(10);
        Label oLabel = new Label("Operation:");
        Button addButton = new Button("+");
        Button subButton = new Button("-");
        Button mulButton = new Button("*");
        Button divButton = new Button("/");
        row3.getChildren().addAll(oLabel, addButton, subButton, mulButton, divButton);

        //Result Row
        HBox row4 = new HBox(10);
        Label rLabel = new Label("Result:");
        TextField rField = new TextField("");
        row4.getChildren().addAll(rLabel, rField);

        //Clear Button
        Button clearButton = new Button("Clear");


        //Button Actions
        addButton.setOnAction(e -> add(fNumField, sNumField, rField));
        subButton.setOnAction(e -> sub(fNumField, sNumField, rField));
        mulButton.setOnAction(e -> mul(fNumField, sNumField, rField));
        divButton.setOnAction(e -> div(fNumField, sNumField, rField));
        clearButton.setOnAction(e -> {
         fNumField.clear(); sNumField.clear(); rField.clear(); });
        
        //Main Layout
        VBox box = new VBox(10);
        box.getChildren().addAll(row1, row2, row3, row4, clearButton);

        //Styling
        String uri = Paths.get("style.css").toUri().toString();
        
        //Create Scene
        Scene scene = new Scene(box, 300, 200);
        scene.getStylesheets().add(uri);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //Calculator Functions -------------------------------

    //Addition
    public void add (TextField fNumField, TextField sNumField, TextField rField) {
        try {
            double num1 = Double.parseDouble(fNumField.getText());
            double num2 = Double.parseDouble(sNumField.getText());
            double result = num1 + num2;
            rField.setText(String.valueOf(result));
        }
        catch (NumberFormatException e) {
            rField.setText("Error");
        }   
    }

    //Subtraction
    public void sub (TextField fNumField, TextField sNumField, TextField rField) {
        try {
            double num1 = Double.parseDouble(fNumField.getText());
            double num2 = Double.parseDouble(sNumField.getText());
            double result = num1 - num2;
            rField.setText(String.valueOf(result));
        }
        catch (NumberFormatException e) {
            rField.setText("Error");
        }
    }

    //Multiplication
    public void mul (TextField fNumField, TextField sNumField, TextField rField) {
        try {
            double num1 = Double.parseDouble(fNumField.getText());
            double num2 = Double.parseDouble(sNumField.getText());
            double result = num1 * num2;
            rField.setText(String.valueOf(result));
        }   
        catch (NumberFormatException e) {
            rField.setText("Error");
        } 
    }

    //Division
    public void div (TextField fNumField, TextField sNumField, TextField rField) {
        try {
            double num1 = Double.parseDouble(fNumField.getText());
            double num2 = Double.parseDouble(sNumField.getText());
            double result = num1 / num2;
            rField.setText(String.valueOf(result));
        }
        catch (NumberFormatException e) {
            rField.setText("Error");
        }
    }

    //Main Method
    public static void main (String[] args) {
        launch(args);
    }
}