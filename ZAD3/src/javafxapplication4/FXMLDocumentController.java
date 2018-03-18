/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication4;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;


public class FXMLDocumentController implements Initializable {


    @FXML
    TextField showName;

    @FXML
    TextField showPhone;

    @FXML
    TableView<Record> phoneListView;

    @FXML
    Button addButton;

    @FXML
    Button updateButton;

    @FXML
    Button deleteButton;

    @FXML
    Label label;

    @FXML
    Label phone;
    
    

    @FXML
    void onMouseClickedAdd(MouseEvent event) {
        
        ObservableList<Record> data = phoneListView.getItems();
        data.add(new Record(showName.getText().toString(), showPhone.getText().toString()));
        showName.setText("");
        showPhone.setText("");
        saveToFile();
        
    }

    @FXML
    void onMouseClickedDelete(MouseEvent event) {

        ObservableList<Record> data = phoneListView.getItems();
        data.remove(phoneListView.getSelectionModel().getSelectedIndex());

        showName.setText("");
        showPhone.setText("");
        saveToFile();
        
    }

    @FXML
    void onMouseClickedUpdate(MouseEvent event) {

        ObservableList<Record> data = phoneListView.getItems();
        data.remove(phoneListView.getSelectionModel().getSelectedIndex());
        onMouseClickedAdd(null);
        saveToFile();
        
    }

    @FXML 
    void loadDataToTextField(MouseEvent event){
        Record tempRecord = phoneListView.getSelectionModel().getSelectedItem();
        showName.setText(tempRecord.getName());
        showPhone.setText(tempRecord.getPhone());
    }
        
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            File file = new File("ksiazka.csv");
            if (file.exists()) {
                Scanner scanner = new Scanner(file);

                ObservableList<Record> data = phoneListView.getItems();

                while(scanner.hasNext()) {
                    data.add(new Record(scanner.nextLine(), scanner.nextLine()));
                }

                scanner.close();
            } else {showName.setText("Brak pliku");}
        }
        catch (IOException error) {
            showName.setText("Odczyt nieudany");
            showPhone.setText(error.getMessage());
        }
        
        } 
    
    
    
    public void saveToFile(){
        try {
            PrintWriter printWriter = new PrintWriter("ksiazka.csv");

            ObservableList<Record> data = phoneListView.getItems();
            data.forEach(item -> { printWriter.println(item.getName()); printWriter.println(item.getPhone());});

            printWriter.close();
        }
        catch (IOException err) {
            showName.setText("Zapis nieudany");
        }
    }

    

    
}
