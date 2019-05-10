// Assignment #: Arizona State University CSE205
//         Name: Zak Sakata
//    StudentID: 1214985785
//      Lecture: 10:30am
//  Description: The DrawingPane class creates a canvas where we can use
//               mouse key to draw lines with different colors and widths.
//               We can also use the the two buttons to erase the last
//				     drawn line or clear them all.

//import any classes necessary here
//----
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Orientation;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class DrawingPane extends BorderPane {
  private Button undoButton, eraseButton;
  private ComboBox<String> colorCombo, widthCombo;
  private ArrayList<Line> lineList;
  private Pane canvas;
  // declare any other necessary instance variables here
  Color selectedColor;
  int selectedWidth;
  Line newLine;

  // Constructor

  public DrawingPane() {
    // Step #1: initialize instance variable and set up layout
    undoButton = new Button("Undo");
    eraseButton = new Button("Erase");
    undoButton.setMinWidth(80.0);
    eraseButton.setMinWidth(80.0);

    // Create the color comboBox and width comboBox,
    colorCombo = new ComboBox<>();
    widthCombo = new ComboBox<>();
    // Set choices for comboBox
    colorCombo.getItems().addAll("Black", "Blue", "Red", "Yellow", "Green");
    widthCombo.getItems().addAll("1", "3", "5", "7");
    // Set initial choice for comboBox
    colorCombo.setValue("Black");
    widthCombo.setValue("1");
    selectedColor = Color.web(colorCombo.getValue().toUpperCase());
    selectedWidth = Integer.parseInt(widthCombo.getValue());

    // initialize lineList, it is a data structure we used
    // to track the lines we created
    lineList = new ArrayList<Line>();

    // topPane should contain two combo boxes and two buttons
    HBox topPane = new HBox();
    topPane.setSpacing(40);
    topPane.setPadding(new Insets(10, 10, 10, 10));
    topPane.setStyle("-fx-border-color: black");
    topPane.getChildren().addAll(colorCombo, widthCombo, undoButton, eraseButton);

    // canvas is a Pane where we will draw lines
    canvas = new Pane();
    canvas.setStyle("-fx-background-color: white;");

    // add the canvas at the center of the pane and top panel
    // should have two combo boxes and two buttons
    this.setCenter(canvas);
    this.setTop(topPane);

    // Step #3: Register the source nodes with its handler objects
    // MouseHandler lineHandler = new MouseHandler();
    canvas.setOnMousePressed(new MouseHandler());
    canvas.setOnMouseDragged(new MouseHandler());
    canvas.setOnMouseReleased(new MouseHandler());

    undoButton.setOnAction(new ButtonHandler());
    eraseButton.setOnAction(new ButtonHandler());
    colorCombo.setOnAction(new ColorHandler());
    widthCombo.setOnAction(new WidthHandler());
  }

  // Step #2(A) - MouseHandler
  private class MouseHandler implements EventHandler<MouseEvent> {
    public void handle(MouseEvent event) {
      // handle MouseEvent here
      // Note: you can use if(event.getEventType()== MouseEvent.MOUSE_PRESSED)
      // to check whether the mouse key is pressed, dragged or released
      // write your own codes here
      
      if(event.getEventType() == MouseEvent.MOUSE_PRESSED) {
        newLine = new Line(event.getX(), event.getY(), event.getX(), event.getY());

        newLine.setStrokeWidth(selectedWidth);
        newLine.setStroke(selectedColor);

        canvas.getChildren().addAll(newLine);
      } else if(event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
        newLine.setEndX(event.getX());
        newLine.setEndY(event.getY());
      } else if(event.getEventType() == MouseEvent.MOUSE_RELEASED) {
        lineList.add(newLine);
      }

    }// end handle()
  }// end MouseHandler

  // Step #2(B)- A handler class used to handle events from Undo & Erase buttons
  private class ButtonHandler implements EventHandler<ActionEvent> {
    public void handle(ActionEvent event) {
      if (event.getSource() == undoButton) {
        Line lastLine = lineList.get(lineList.size() - 1);
        canvas.getChildren().remove(lastLine);
      } else if (event.getSource() == eraseButton){
        canvas.getChildren().clear();
      }

    }
  }// end ButtonHandler

  // Step #2(C)- A handler class used to handle colors
  private class ColorHandler implements EventHandler<ActionEvent> {
    public void handle(ActionEvent event) {
      // write your own codes here
      selectedColor = Color.web(colorCombo.getValue().toUpperCase());
    }
  }// end ColorHandler

  // Step #2(D)- A handler class used to handle widths of lines
  private class WidthHandler implements EventHandler<ActionEvent> {
    public void handle(ActionEvent event) {
      // write your own codes here
      selectedWidth = Integer.parseInt(widthCombo.getValue());
    }
  }// end WidthHandler
}// end class DrawingPane
