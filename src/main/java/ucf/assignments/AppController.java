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
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;


public class AppController {

    private ArrayList<List>  mainList = new ArrayList<>();

    @FXML
    private ChoiceBox ListSelected;
    @FXML
    private ChoiceBox TaskSelected;
    @FXML
    private TreeView<String> listScreen;

    @FXML
    private void initialize(){
        //just to show what the app is going to look like
        TreeItem<String> root = new TreeItem<String>("Lists:");
        TreeItem<String> list1 = new TreeItem<String>("List 1 Name:");
        TreeItem<String> list2 = new TreeItem<String>("List 2 Name:");

        list1.getChildren().add(new TreeItem<>("Completed - Due Date - Description (Task 1)"));
        list1.getChildren().add(new TreeItem<>("Uncompleted - Due Date - Description (Task 2)"));

        list2.getChildren().add(new TreeItem<>("Completed - Due Date - Description (Task 1)"));
        list2.getChildren().add(new TreeItem<>("Uncompleted - Due Date - Description (Task 2)"));

        root.getChildren().add(list1);
        root.getChildren().add(list2);
        listScreen.setRoot(root);

        //for loop that iterates for the length of main ArrayList
            //get list name
            //create a string TreeItem with the list name

            //for loop that iterates for the length of the task ArrayList
                //get completed, due date, and description
                //compile info into a string
                //create a treeItem with the string and add it as a child of the list

            //add list item to the root item

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
