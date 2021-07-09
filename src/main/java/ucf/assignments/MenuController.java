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

public class MenuController {

    //Edit Task Tab
        private boolean editDescription;
        private boolean editDueDate;
        @FXML private ChoiceBox ETSelectedTask;
        @FXML private DatePicker ETSelectedDate;
        @FXML private TextField ETEditedDescription;
        @FXML private TextArea ETUserMessage;

        public void editDescriptionChecked(ActionEvent actionEvent) {
            //set editDescription to equal true
        }

        public void editDateChecked(ActionEvent actionEvent) {
            //set editDueDate to equal true
        }

        public void updateTaskButtonPressed(ActionEvent actionEvent) {
            //if editDescription or editDueDate is true
                //take in the list selected
                //find the index of the array of the selected list and store it
                //take in the task selected
                //find the index of the task in the list and store it
                //if editDescription is true
                    //set the description of the task to equal the input from the textField
                //if editDueDate is true
                    //set the due date of the task to equal the input from the datePicker
            //else
                //display in textArea that the user needs to select at least one option
        }

    //Add Task Tab
        @FXML private DatePicker ATSelectedDate;
        @FXML private TextField ATEnteredDescription;
        @FXML private TextArea ATUserMessage;
        public void addTaskButtonPressed(ActionEvent actionEvent) {
            //take in List selected
            //find its index in the ArrayList
            //search if the task has already present in the selected list
            //if search equals -1 (not found)
                //create and add task to the List
            //else
                //display in TextArea that the task has already been added
        }

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
