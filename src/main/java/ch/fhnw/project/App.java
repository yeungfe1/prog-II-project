package ch.fhnw.project;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.function.Supplier;

public final class App extends Application {

    @Override
    public void start(Stage stage) {

      /*  //test commit
        //testtst
        // Asserts correct project setup (will only compile with Java 8)
        Supplier<String> helloWorldSupplier = () -> "Hello World";
        System.out.println(helloWorldSupplier.get());*/
        Button button = new Button("click me...");

        button.setOnAction(event -> {
            System.out.println("hey :D");
            button.setStyle("-fx-background-color: blue");

        });

// was isch los?!
        //nüt isch los!!!!
        //was nit? weisch wer am sunntig nochhilf git ;)

        //Button button2 =new Button("Button2");



        Pane pane = new Pane();
        pane.getChildren().add(button);

        Scene scence = new Scene(pane,300,200);


        stage.setTitle("hellllouuuuuu");
        stage.setScene(scence);
        stage.show();

    }

}
