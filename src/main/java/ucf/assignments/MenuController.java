package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Ashley Mojica
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDate;

public class MenuController {


    //Remove Task
        @FXML private ChoiceBox removeSelectedTask;
        @FXML private TextArea RTUserMessage;
        public void removeTaskButtonPressed(ActionEvent actionEvent){

        }


    //Insert List from External File Tab
        @FXML private TextField ILFilePath;
        @FXML private TextArea ILUserMessage;
        public void scanListButtonPressed(ActionEvent actionEvent) {
            //open file
            //while the nextLine does not equal null
                //scan in list name
                //create list and add it to the ArrayList
                //scan in number of items
                //for loop to iterate through items
                //scan in task info
                //create task with input and add it to the TaskList of the List
        }

    //Save List to External File Tab
        @FXML private TextField SLFilePath;
        @FXML private TextArea SLUserMessage;
        public void saveListButtonPressed(ActionEvent actionEvent) {
            //open file
            //iterate through List
                //iterate through Tasks
                    //save Task info to file
            //prompt user that save was successful
        }

    //Universally Used Elements
        public void okButtonPressed(ActionEvent actionEvent) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("App.fxml"));
            Scene menuScene = new Scene(root);

            Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            window.setScene(menuScene);
            window.show();
        }
}
