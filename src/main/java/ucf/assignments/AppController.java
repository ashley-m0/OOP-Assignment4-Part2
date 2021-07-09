package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Ashley Mojica
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;


public class AppController {

    private List  mainList = new List();

    @FXML private ChoiceBox TaskSelected;
    @FXML private TableView<Task> taskTable;
    @FXML private TableColumn<Task, String> completedColumn;
    @FXML private TableColumn<Task, LocalDate> dueDateColumn;
    @FXML private TableColumn<Task, String> descriptionColumn;

    @FXML private void initialize(){
        completedColumn.setCellValueFactory(new PropertyValueFactory<Task, String>("completed"));
        dueDateColumn.setCellValueFactory(new PropertyValueFactory<Task, LocalDate>("dueDate"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Task, String>("description"));

        taskTable.setItems(getTaskInfo());
    }

    public ObservableList<Task> getTaskInfo() {
        ObservableList<Task> listInfo = FXCollections.observableArrayList();

        for(int i = 0; i < mainList.getTaskListSize(); i++){
            listInfo.add(mainList.getTask(i));
        }

        return listInfo;
    }

    public void menuButtonPressed(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene menuScene = new Scene(root);

        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(menuScene);
        window.show();
    }

    public void showAllTasksSelected(ActionEvent actionEvent) {
        //initialize root
        //for loop that iterates for the length of main ArrayList
            //get list name
            //create a string TreeItem with the list name

            //for loop that iterates for the length of the task ArrayList
                //get completed, due date, and description
                //compile info into a string
                //create a treeItem with the string and add it as a child of the list

            //add list item to the root item

        //set TreeView's root to the root we made
    }

    public void showCompletedTasksSelected(ActionEvent actionEvent) {
        //initialize root
            //for loop that iterates for the length of main ArrayList
            //get list name
            //create a string TreeItem with the list name

            //for loop that iterates for the length of the task ArrayList
                //get completed, due date, and description
                //if task is completed
                    //compile info into a string
                    //create a treeItem with the string and add it as a child of the list

            //add list item to the root item

        //set TreeView's root to the root we made
    }

    public void showUncompletedTasksSelected(ActionEvent actionEvent) {
        //initialize root
        //for loop that iterates for the length of main ArrayList
            //get list name
            //create a string TreeItem with the list name

            //for loop that iterates for the length of the task ArrayList
                //get completed, due date, and description
                //if task is  not completed
                    //compile info into a string
                    //create a treeItem with the string and add it as a child of the list

            //add list item to the root item

        //set TreeView's root to the root we made
    }

    public void taskCompletedButton(ActionEvent actionEvent) {
        //takes in the list selected by the user
        //takes in the description selected by the user

        //find list
        //find task

        //set task's complete variable to true
    }


}
