/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package SkinBeautyAesthetics;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */

public class SkinBeautyLoginController implements Initializable {

    @FXML
    private TextField password;
    @FXML
    private Button login;
    
    public static final String correctPassword = "admin123";
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickLoginBtn(MouseEvent event) throws IOException {
        validateLogin();
    }
    //Implement validateLogin function  
    void validateLogin() throws IOException { 
        if (correctPassword.equals(password.getText()))   {     
                showMainPage();    
        } else { 
            int attempts = 0;
            attempts++;
 
            if (attempts >= 3) { 
               showAlert("Exiting application."); 
                System.exit(0); 
            } else { 
                showAlert("Incorrect password. Attempts left: " + (3 - attempts)); 
                password.clear(); 
            }
 
        }
 
    } 
    public static void showAlert(String message) { 
        Alert alert = new Alert(Alert.AlertType.WARNING); 
        alert.setTitle("Error Message"); 
        alert.setHeaderText(null); 
        alert.setContentText(message); 
        alert.showAndWait(); 
    }
 
    //Implement showMainPage function in LoginController.java
 
    private void showMainPage() throws IOException{ 
        Parent root = FXMLLoader.load(getClass().getResource("/SkinBeautyAesthetics/SkinBeautyLogin.fxml"));; 
        Stage newStage = new Stage(); 
        Scene scene = new Scene(root); 
        newStage.setTitle("AddyAesthetics"); 
        newStage.setScene(scene); 
        newStage.show(); 
        ((Stage) login.getScene().getWindow()).close();  
    }
}

