package hust.soict.dsai.javafx;

public class PainterController {
    @FXML
    private Pane drawingAreaPane;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
        drawingAreaPane.getChildren().add(newCircle);
    }

}

