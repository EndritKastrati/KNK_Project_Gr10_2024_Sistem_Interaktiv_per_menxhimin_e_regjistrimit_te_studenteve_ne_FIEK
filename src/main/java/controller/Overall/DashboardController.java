package controller.Overall;

import app.Navigatior;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class DashboardController {

    @FXML
    private ImageView mainImage;
    @FXML
    private Button buttoni_qasja;

    @FXML
    private void initialize(){
        try {
            this.mainImage.setImage(new Image(new FileInputStream("Images/fieku.jpg")));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void buttoni_qasja_hover(ActionEvent event) {
        buttoni_qasja.setStyle("-fx-opacity: 0.9;");
    }
}
