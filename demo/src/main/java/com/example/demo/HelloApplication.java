package com.example.demo;//package com.example.demo;
//
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//
//public class HelloApplication extends Application {
//    @Override
//    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    public static void main(String[] args) {
//        launch();
//    }
//}
//
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.layout.Background;
//import javafx.scene.layout.BackgroundFill;
//import javafx.scene.layout.Pane;
//import javafx.scene.layout.VBox;
//import javafx.scene.paint.Color;
//import javafx.stage.Stage;
//
//public class HelloApplication extends Application {
//
//    @Override
//    public void start(Stage primaryStage) {
//        VBox vBox = createVBoxWithSections();
//
//        Scene scene = new Scene(vBox, 400, 300);
//        primaryStage.setTitle("VBox with Sections");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    private VBox createVBoxWithSections() {
//        VBox vBox = new VBox();
//
//        // Create four Panes for each section
//        Pane section1 = createSection(Color.RED);
//        Pane section2 = createSection(Color.GREEN);
//        Pane section3 = createSection(Color.BLUE);
//        Pane section4 = createSection(Color.YELLOW);
//
//        // Add the Panes to the VBox
//        vBox.getChildren().addAll(section1, section2, section3, section4);
//
//        return vBox;
//    }
//
//    private Pane createSection(Color color) {
//        Pane section = new Pane();
//        section.setBackground(new Background(new BackgroundFill(color, null, null)));
//        section.setMinHeight(75); // Set the desired height for each section
//
//        // Add your content or elements to each section if needed
//
//        return section;
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    private HBox flagContainer;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Flag Display App");

        // Create buttons for different countries
        Button btnCountry1 = createCountryButton("Lesotho", Color.GREEN, Color.WHITE, Color.BLUE);
        Button btnCountry2 = createCountryButton("Armenia", Color.RED, Color.BLUE, Color.YELLOW);
        Button btnCountry3 = createCountryButton("Bulgaria", Color.WHITE, Color.GREEN, Color.RED);

        // Create a container for the flag display
        flagContainer = new HBox(10);
        flagContainer.setPadding(new Insets(10));

        // Add buttons and the flag container to the main layout
        HBox mainLayout = new HBox(20);
        mainLayout.getChildren().addAll(btnCountry1, btnCountry2, btnCountry3, flagContainer);

        // Set up the scene
        Scene scene = new Scene(mainLayout, 500, 200);
        primaryStage.setScene(scene);

        // Show the stage
        primaryStage.show();
    }

    private Button createCountryButton(String countryName, Color... colors) {
        Button button = new Button(countryName);
        button.setOnAction(e -> displayCountryFlag(colors));
        return button;
    }

    private void displayCountryFlag(Color... colors) {
        flagContainer.getChildren().clear();

        for (Color color : colors) {
            Pane colorPane = createColorPane(color);
            flagContainer.getChildren().add(colorPane);
        }
    }

    private Pane createColorPane(Color color) {
        Pane colorPane = new Pane();
        colorPane.setBackground(new Background(new BackgroundFill(color, null, null)));
        colorPane.setMinSize(50, 50); // Set the desired size for each color
        return colorPane;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
