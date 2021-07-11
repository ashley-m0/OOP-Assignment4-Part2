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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class MenuController {

    private List  mainList = new List();

    //Insert List from External File Tab
        @FXML private TextField ILFilePath;
        @FXML private TextArea ILUserMessage;
        public void scanListButtonPressed(ActionEvent actionEvent) {
            //open file
            File inText = new File(ILFilePath.getText());
            try {
                Scanner input = new Scanner(inText);
                //while the nextLine does not equal null
                while(input.hasNext()) {
                    //scan in task info
                    String complete = input.next();
                    String date = input.next();
                    String description = input.next();
                    //create task with input and add it to the TaskList of the List
                }
                //prompt user that save was successful
                SLUserMessage.setText("Successfully uploaded information.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

        }

    //Save List to External File Tab
        @FXML private TextField SLFilePath;
        @FXML private TextArea SLUserMessage;
        public void saveListButtonPressed(ActionEvent actionEvent) {
            //open file
            File outText = new File(SLFilePath.getText());
            try {
                FileWriter myWriter = new FileWriter(outText);
                //iterate through Tasks
                for(int i = 0; i < mainList.getTaskListSize(); i++) {
                    String complete = mainList.getTask(i).getCompleted();
                    String date = mainList.getTask(i).getDueDate().toString();
                    String description = mainList.getTask(i).getDescription();
                    String message = String.format("|%10s |%10s |%s ", complete, date, description);
                    myWriter.write(message);
                    myWriter.write("\n");

                    //save Task info to file
                }
                myWriter.close();
                //prompt user that save was successful
                SLUserMessage.setText("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

    //Universally Used Elements
        public void okButtonPressed(ActionEvent actionEvent) throws IOException {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("App.fxml"));
            Parent tableViewParent = loader.load();

            Scene tableViewScene = new Scene(tableViewParent);

            //access the controller and call a method
            AppController controller = loader.getController();
            controller.setAppMainList(mainList);
            controller.updateTable();

            //This line gets the Stage information
            Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

            window.setScene(tableViewScene);
            window.show();
        }

        public void setMenuMainList(List newList){
            for(int i = 0; i < newList.getTaskListSize(); i++){
                mainList.addTask(newList.getTask(i).getDueDate(), newList.getTask(i).getDescription());
            }
        }
}
