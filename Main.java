import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import java.nio.file.Paths;

public class Main extends Application {

    @Override
    public void start (Stage primaryStage) {
        Button button = new Button("Hello");
        TextField textfield = new TextField("Enter your name");
        VBox box = new VBox(10);
        box.getChildren().add(textfield);
        box.getChildren().add(button);
        Scene scene = new Scene(box, 300, 200);
        //box.setStyle("-fx-");
        
        String uri = Paths.get("style.css").toUri().toString();
        scene.getStylesheets().add(uri);

        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    public static void main (String[] args) {
        launch(args);
    }
}