
// Assignment #: 12
//         Name: Zak Sakata
//    StudentID: 1214985785
//      Lecture: 10:30am
//  Description: FireworkPane class that hanldes all animations and changes to the firework.

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class FireworkPane extends Pane {
  private double centerX;
  private double centerY;
  private double radius = 25.0;
  private double radiusLimit;
  private Color color;
  private int beamNum;
  private double step = 2.0;
  private double angleSize;
  private Timeline timeline1;

  public FireworkPane(Color color, int width) {
    this.color = color;
    this.centerX = width / 2;
    this.centerY = width / 2;
    this.radiusLimit = (width - 10) / 4;
    this.radius = 25;
    this.beamNum = 8;
    this.angleSize = 360 / (beamNum * 2);
    setStyle("-fx-background-color: black;");

    for (int currentAngle = 0; currentAngle <= 360; currentAngle += 2 * angleSize) {
      Arc arc1 = new Arc(centerX, centerY, radius, radius, currentAngle, angleSize);
      arc1.setFill(color);
      arc1.setStroke(color);
      arc1.setType(ArcType.ROUND);
      this.getChildren().add(arc1);
    }

    KeyFrame kf = new KeyFrame(Duration.millis(500), new FireworkHandler());
    timeline1 = new Timeline(kf);
    timeline1.setCycleCount(Timeline.INDEFINITE);
    timeline1.setRate(20); // default rate = 20
    timeline1.play();
  }

  public void resume() {
    timeline1.play();
  }

  public void suspend() {
    timeline1.pause();
  }

  public void changeColor(Color anotherColor) {
    this.color = anotherColor;
  }

  public void setBeamNumber(int beam) {
    this.beamNum = beam;
    this.angleSize = 360 / (beamNum * 2);
  }

  public void setRate(int rate1) {
    this.setRate(rate1);
  }

  private class FireworkHandler implements EventHandler<ActionEvent> {
    public void handle(ActionEvent event) {
      getChildren().clear();

      angleSize = 360 / (beamNum * 2);
      for (int currentAngle = 0; currentAngle <= 360; currentAngle += 2 * angleSize) {
        Arc arc1 = new Arc(centerX, centerY, radius, radius, currentAngle, angleSize);
        arc1.setFill(color);
        arc1.setStroke(color);
        arc1.setType(ArcType.ROUND);
        getChildren().add(arc1);
      }

      radius += step;
      radius = radius >= radiusLimit ? 0 : radius;
    }
  }
}