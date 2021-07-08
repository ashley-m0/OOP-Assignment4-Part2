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

    //Edit List Tab
        private boolean editTitle;
        private boolean removeTask;
        @FXML
        private ChoiceBox updateList;
        @FXML
        private TextField updateTitleName;
        @FXML
        private ChoiceBox removeTaskSelected;
        @FXML
        private TextArea updateListUserMessage;

        public void editTitleChecked(ActionEvent actionEvent) {
            //set editTitle to true
        }

        public void removeTaskChecked(ActionEvent actionEvent) {
            //set removeTask to true
        }

        public void updateListButtonPressed(ActionEvent actionEvent) {
            //if editTitle and removeTask are checked
                //take in value selected in dropdown menu
                //find which index is associated with the value chosen
                //if editTitle is true
                    //get the title entered into the textField
                    //set the title of the list selected to equal the title entered
                //if removeTask is true
                    //take in value selected
                    //find which index in the list is associated with the value selected
                    //delete list
                //display a message in textArea that the update was successful
            //else
                //display a message in textArea for user to select at least one
        }

    //Add List Tab
        @FXML
        private TextField newTitleName;
        @FXML
        private TextArea addListUserMessage;
        public void addListButtonPressed(ActionEvent actionEvent) {
            //search if the title name has already been added
            //if search equals -1 (name not found)
                //create a new List with the title in the textField and add it to the ArrayList
                //display that the list was successfully added in textArea
            //else
                //display to user in textArea that the list already exists
        }

    //Edit Task Tab
        private boolean editDescription;
        private boolean editDueDate;
        @FXML
        private ChoiceBox ETSelectedList;
        @FXML
        private ChoiceBox ETSelectedTask;
        @FXML
        private DatePicker ETSelectedDate;
        @FXML
        private TextField ETEditedDescription;
        @FXML
        private TextArea ETUserMessage;

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
        @FXML
        private ChoiceBox ATSelectedList;
        @FXML
        private DatePicker ATSelectedDate;
        @FXML
        private TextField ATEnteredDescription;
        @FXML
        private TextArea ATUserMessage;
        public void addTaskButtonPressed(ActionEvent actionEvent) {
            //take in List selected
            //find its index in the ArrayList
            //search if the task has already present in the selected list
            //if search equals -1 (not found)
                //create and add task to the List
            //else
                //display in TextArea that the task has already been added
        }

    //Insert List from External File Tab
        private boolean singleListInsert;
        private boolean multipleListInsert;
        @FXML
        private TextField ILFilePath;
        @FXML
        private TextArea ILUserMessage;
        public void singleListInsertedChecked(ActionEvent actionEvent) {
            //set singleListInsert to equal true
        }

        public void multipleListInsertedChecked(ActionEvent actionEvent) {
            //set multipleListInsert to equal true
        }

        public void scanListButtonPressed(ActionEvent actionEvent) {
            //if singleListInsert or multipleListInserted equals true
                //open file
                //if multipleListInserted equals true and singleListInsert equals false
                    //while the nextLine does not equal null
                        //scan in list name
                        //create list and add it to the ArrayList
                        //scan in number of items
                        //for loop to iterate through items
                            //scan in task info
                            //create task with input and add it to the TaskList of the List
                //if singleListInsert equals true and multipleListInsert equals false
                    //scan in list name
                    //create list and add it to the ArrayList
                    //while the nextLine does not equal null
                        //scan in task information
                        //create task from input
                        //add the task to the List's TaskList
                //else
                    //prompt for user to only check one box
            //else
                //prompt for user to check one box
        }

    //Save List to External File Tab
        static boolean saveOneList;
        static boolean saveAllList;
        @FXML
        private TextField SLFilePath;
        @FXML
        private ChoiceBox SLSelectedList;
        @FXML
        private TextArea SLUserMessage;
        public void saveOneListChecked(ActionEvent actionEvent) {
            //set saveOneList to equal true;
        }

        public void saveAllListChecked(ActionEvent actionEvent) {
            //set saveAllList to equal true;
        }

        public void saveListButtonPressed(ActionEvent actionEvent) {
            //if saveOneList or saveAllListChecked equal true
                //open file
                //if saveAllList is true and saveOneList is false
                    //iterate through ArrayList
                        //iterate through List
                            //save List Name to file
                            //iterate through Tasks
                                //save Task info to file
                    //prompt user that save was successful
                //else if saveOneList is true and saveAllList is false
                    //find List in ArrayList
                    //save list name to file
                    //iterate through tasks
                        //save Task info to file
                    //prompt user that the save was successful
                //else
                    //prompt user to only pick one option in TextArea
            //else
                //prompt user that they need to select one option in TextArea
        }

    //Universally Used Elements
        public void okButtonPressed(ActionEvent actionEvent) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("App.fxml"));
            Scene menuScene = new Scene(root);

            Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            window.setScene(menuScene);
            window.show();
        }

    //Universal Methods
        public int findList(String name){
            //for loop that iterates through all the lists in the ArrayList
                //if the input name equals a list's title
                    //return arrayIndex
                //else
                    //return -1 to inndicate not found
                    return -1;
        }
}
