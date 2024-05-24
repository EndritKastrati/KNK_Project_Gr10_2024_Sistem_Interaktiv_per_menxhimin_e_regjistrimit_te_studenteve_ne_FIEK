package controller.Student;

import controller.SESSION;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import model.dto.Student.PHDApplicantDto;
import model.dto.Student.StudentApplicantDto;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class EducationalPHDController {

    @FXML
    private AnchorPane addPane;

    @FXML
    private Button btnApply;

    @FXML
    private Button btnGoback;

    @FXML
    private Button chooseImageButton1;

    @FXML
    private Button chooseImageButton2;

    @FXML
    private Button chooseImageButton3;

    @FXML
    private ImageView imgViewfile1;

    @FXML
    private ImageView imgViewfile2;

    @FXML
    private ImageView imgViewfile3;

    @FXML
    private TextField txtDep;

    @FXML
    private TextField txtFaculty;

    @FXML
    private TextField txtSecondYGrade;

    @FXML
    private TextField txtfirstYGrade;
    public File imageFile1;
    public File imageFile2;
    public File imageFile3;
    @FXML
    void handleFile1(ActionEvent event) {
        imageFile1 = chooseImage(imgViewfile1);
    }

    @FXML
    void handleFile2(ActionEvent event) {
        imageFile2 = chooseImage(imgViewfile2);
    }

    @FXML
    void handleFile3(ActionEvent event) {
        imageFile2 = chooseImage(imgViewfile3);
    }

    @FXML
    void handleGoback(MouseEvent event) {

    }

    @FXML
    void handleNext(MouseEvent event) {
        String Fakulteti = txtFaculty.getText();
        Double Mesatarjaviti1 = Double.parseDouble(txtfirstYGrade.getText());
        Double Mesatarjaviti2 = Double.parseDouble(txtSecondYGrade.getText());
        String Departamenti = txtDep.getText();

        // e shtove SESSION para getLoggedUser()
        PHDApplicantDto dto = new PHDApplicantDto(SESSION.getLoggedUser().getId(), Fakulteti,Mesatarjaviti1,Mesatarjaviti2,imageFile2,imageFile1,imageFile3);

        try {

            // Trego një mesazh suksesi
        } catch (Exception e) {
            e.printStackTrace();
            // Trego një mesazh gabimi
        }

    }

    private File chooseImage(ImageView imageView) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Zgjidh Foton");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            try {
                Image image = new Image(new FileInputStream(selectedFile));
                imageView.setImage(image);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return selectedFile;
    }


}
