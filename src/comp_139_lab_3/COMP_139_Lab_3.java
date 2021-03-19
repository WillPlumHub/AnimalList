/*
 * AnimalApplicationFX.java
 * @author Jadwiga Downarowicz
 * Created on Dec 11, 2019
 * A JavaFX application for storing animals in a queue
 */
package comp_139_lab_3;        

import Animals.*;
import Exceptions.EmptyQueueException;
import Exceptions.InvalidNameException;
import Exceptions.InvalidWeightException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class COMP_139_Lab_3 extends Application {

    private TextField nameTF = new TextField();
    private TextField weightTF = new TextField();
    private TextField ageTF = new TextField();
    private TextField lengthTF = new TextField();
    private TextField colorTF = new TextField();

    private Button reptileBt = new Button("Add Reptile");
    private Button mammalBT = new Button("Add Mammal");
    private Button removeBT = new Button("Remove");
    private Button nextBT = new Button("Next");
    private Button displayBT = new Button("Display");

    private TextArea textArea = new TextArea();
    /**
     * The Queue of animals
     */
    private final LinkedQueue<Animal> linkedQueue = new LinkedQueue();

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create the user interface
        GridPane infoPane = new GridPane();
        infoPane.setHgap(5);
        infoPane.setVgap(5);
        infoPane.add(new Label("Name"), 0, 0);
        infoPane.add(nameTF, 1, 0);
        infoPane.add(new Label("Weight (lb)"), 0, 1);
        infoPane.add(weightTF, 1, 1);
        infoPane.add(new Label("Age"), 0, 2);
        infoPane.add(ageTF, 1, 2);
        infoPane.add(new Label("Reptiles Length"), 0, 3);
        infoPane.add(lengthTF, 1, 3);
        infoPane.add(new Label("Mammals Color"), 0, 4);
        infoPane.add(colorTF, 1, 4);

        GridPane buttonPane = new GridPane();
        buttonPane.setHgap(15);
        buttonPane.setAlignment(Pos.CENTER);
        buttonPane.add(reptileBt, 0, 0);
        buttonPane.add(mammalBT, 1, 0);
        buttonPane.add(removeBT, 2, 0);
        buttonPane.add(nextBT, 3, 0);
        buttonPane.add(displayBT, 4, 0);
        infoPane.setAlignment(Pos.CENTER);
        nameTF.setAlignment(Pos.BOTTOM_RIGHT);
        weightTF.setAlignment(Pos.BOTTOM_RIGHT);
        ageTF.setAlignment(Pos.BOTTOM_RIGHT);
        lengthTF.setAlignment(Pos.BOTTOM_RIGHT);
        colorTF.setAlignment(Pos.BOTTOM_RIGHT);

        // Process events
        reptileBt.setOnAction(e -> addReptile());
        mammalBT.setOnAction(e -> addMammal());
        displayBT.setOnAction(e -> display());
        removeBT.setOnAction(e -> removeAnimal());
        nextBT.setOnAction(e -> firstAnimal());

        BorderPane pane = new BorderPane();

        // Place nodes in the pane
        pane.setTop(infoPane);
        textArea.prefHeight(400);
        ScrollPane scrollPane = new ScrollPane(textArea);
        // scrollPane.setContent(textArea);
        scrollPane.setFitToWidth(true);

        pane.setBottom(scrollPane);
        // pane.setLeft(new CustomPane("Left"));
        pane.setCenter(buttonPane);
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 600, 400);
        primaryStage.setTitle("Animals Info"); // Set title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

    }

    /**
     * creates a Reptile object and adds to a queue
     */
    private void addReptile() {
        try {
            String name = nameTF.getText();
            //take the users input for the Reptile's name
            int age = Integer.parseInt(ageTF.getText());
            //take the users input for the Reptile's age
            double weight = Double.parseDouble(weightTF.getText());
            //take the users input for the Reptile's weight
            int length = Integer.parseInt(lengthTF.getText());
            //take the users input for the Reptile's length
            Reptile rept = new Reptile(name, weight, age, length);
            //create new Reptile object with the values given by the user
            linkedQueue.enqueue(rept);  //add rept object to queue
        } catch (InvalidNameException | InvalidWeightException
                | NumberFormatException ex) {
            /*catch InvalidNameException, InvalidWeightException, or
      NumberFormatException errors if they appear*/
            System.out.println(ex.getMessage()); //then send error message
        }
    }

    /**
     * creates a Mammal object and adds to a queue
     */
    private void addMammal() {
        try {
            String name = nameTF.getText();
            //take the users input for the Mammal's name
            int age = Integer.parseInt(ageTF.getText());
            //take the users input for the Mammal's age
            double weight = Double.parseDouble(weightTF.getText());
            //take the users input for the Mammal's weight
            String hairColor = colorTF.getText();
            //take the users input for the Mammal's hair color
            Mammal maml = new Mammal(name, weight, age, hairColor);
            //create new Mammal object with the values given by the user
            linkedQueue.enqueue(maml);  //add maml object to queue
        } catch (InvalidNameException | InvalidWeightException
                | NumberFormatException ex) {
            /*catch InvalidNameException, InvalidWeightException, or
      NumberFormatException errors if they appear*/
            System.out.println(ex.getMessage()); //then send an error message
        }
    }

    /**
     * displays the animals stored in the queue
     */
    private void display() {
        textArea.appendText(linkedQueue.toString() + "\n");
        /*display objects from queue*/
    }

    /**
     * Method remove removes an animal from the queue
     */
    private void removeAnimal() {
        try {
            linkedQueue.dequeue(); //remove first object from queue
        } catch (EmptyQueueException ex) {
//catch an error if the queue is empty
            System.out.println(ex.getMessage()); //then send an error message
        }
    }

    /**
     * Method remove removes an animal from the queue
     */
    private void firstAnimal() {
        try {
            linkedQueue.dequeue();  //returns the first object in the queue
        } catch (EmptyQueueException ex) {
//catch an error if the queue is empty
            System.out.println(ex.getMessage()); //then send an error message
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
