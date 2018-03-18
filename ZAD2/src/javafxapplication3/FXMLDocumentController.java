/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author Laki
 */
public class FXMLDocumentController implements Initializable {
    
//    @FXML
//    private Label input;

 
    @FXML
    private TextField input;

    @FXML
    private RadioButton fromC;

    @FXML
    private ToggleGroup from;

    @FXML
    private RadioButton fromF;

    @FXML
    private RadioButton fromK;

    @FXML
    private RadioButton toC;

    @FXML
    private ToggleGroup to;

    @FXML
    private RadioButton toF;

    @FXML
    private RadioButton toK;

    @FXML
    private TextField output;
    
    @FXML
    private Button Close;

    @FXML
    private void onMouseEnteredButton() {
        int setX = (int) (Math.floor(Math.random() * (250-50) + 50));  
        int setY = (int) (Math.floor(Math.random() * (350-50) + 50));
        Close.setLayoutX(setX);
        Close.setLayoutY(setY);
    }

    @FXML
    private void whenValueFilled(){
        
        //System.out.println("Toggled: " + from.getSelectedToggle().getUserData().toString());
            RadioButton fromButton = (RadioButton) from.getSelectedToggle();
            String fromWhat = fromButton.getText();
            
            RadioButton toButton = (RadioButton) to.getSelectedToggle();
            String toWhat = toButton.getText();            
            
            String tmp = input.getText();
            
            
        if(tmp != null && tmp.matches("^[-+]?[0-9]+")){
            int tmpNumber = Integer.parseInt(tmp);
                          
            if(fromWhat.equals(toWhat)) output.setText(tmp);
            else if(fromWhat.equals("Celsius") && toWhat.equals("Fahrenheit")){
                int result = tmpNumber + 33;
                String res = Integer.toString(result);
                output.setText(res);    
            }else if(fromWhat.equals("Fahrenheit") && toWhat.equals("Celsius")){
                int result = tmpNumber - 33;
                String res = Integer.toString(result);
                output.setText(res);
            }else if(fromWhat.equals("Celsius") && toWhat.equals("Kelvin")){
                int result = tmpNumber + 273;
                String res = Integer.toString(result);
                output.setText(res);
            }else if(fromWhat.equals("Kelvin") && toWhat.equals("Celsius")){
                int result = tmpNumber - 273;
                String res = Integer.toString(result);
                output.setText(res);}
        } else {output.setText("NaN");}
    }
            
    
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        }    
    

    
}
