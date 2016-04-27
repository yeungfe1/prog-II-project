package ch.fhnw.project;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.function.Supplier;

public final class App extends Application {

    @Override

    public void start(Stage stage) throws Exception{

        TextField inputTextField = new TextField();

        Button konvFahreinheit = new Button("von Celsius nach Fahreinheit");
        Button konvCelsius = new Button("von Fahreinheit nach Celsius");

        CheckBox checkbox = new CheckBox("Use Approximation");

        Label inputLabel = new Label("Bitte Temperatur eingeben");
        Label label = new Label();

        Label resultTemp = new Label();

// in action
        konvFahreinheit.setOnAction( actionEvent -> {
            double wert;
            if(checkbox.isSelected()==true){
                wert =2;
            }else{
                wert = 1.8;
            };

            double result= wert*Double.parseDouble(inputTextField.getText())+32;

            label.setText(inputTextField.getText() + "°C ist gleich ");
            resultTemp.setText(String.valueOf(result)+ "°F");

        });

        konvCelsius.setOnAction( actionEvent -> {
            double wert;
            if(checkbox.isSelected()==true){
                wert =2;
            }else{
                wert = 1.8;
            };

            double result= (Double.parseDouble(inputTextField.getText())-32)/wert;
            label.setText(inputTextField.getText() + "°F ist gleich ");
            resultTemp.setText(String.valueOf(result)+ "°C");

        });

        HBox firstLine = new HBox();
        firstLine.getChildren().addAll(inputLabel,inputTextField,checkbox);
        firstLine.setAlignment(Pos.CENTER);
        firstLine.setSpacing(10);
        firstLine.setPadding(new Insets(5, 5, 5, 5));

        HBox secondLine = new HBox();
        secondLine.getChildren().addAll(konvCelsius,konvFahreinheit);
        secondLine.setAlignment(Pos.CENTER);
        secondLine.setSpacing(10);
        secondLine.setPadding(new Insets(5, 5, 5, 5));

        HBox thirdLine = new HBox();
        thirdLine.getChildren().addAll(label, resultTemp);
        thirdLine.setAlignment(Pos.CENTER);
        thirdLine.setSpacing(20);
        secondLine.setPadding((new Insets(5,5,5,5)));


        VBox vBox = new VBox();
        vBox.getChildren().addAll(firstLine,secondLine,thirdLine);

        StackPane pane = new StackPane();
        pane.getChildren().add(vBox);



        stage.setTitle("Temperaturkonverter");
        Scene scene = new Scene(pane, 500, 400);


        stage.setScene(scene);
        stage.show();

    }

    void approx(){

    }



    public static void main(String[] args) {
        launch(args);
    }
}
