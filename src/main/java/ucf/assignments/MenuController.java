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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MenuController {

    private List  mainList = new List();

    @FXML private TextField ILFilePath;
    @FXML private TextArea ILUserMessage;
    @FXML private TextField SLFilePath;
    @FXML private TextArea SLUserMessage;

    /*
    * Insert List from External File Tab
    */

        // Assuming the document lists tasks with the format "completed date description" (Example: Completed 7/11/2021 Finish App)
        public void scanListButtonPressed(ActionEvent actionEvent) {
            //open file
            Scanner input = new Scanner(ILFilePath.getText());
            while (input.hasNextLine()) {
                //read in completed
                String completed = input.next();
                //take care of case if it's "Not Complete
                if(completed.equals("Not")){
                    String completedAdditional = input.next();
                    completed += completedAdditional;
                }
                //read in due date
                String dueDate = input.next();
                //read in description
                String description = input.nextLine();
                //add task to mainList
                mainList.addTask(completed, dueDate, description);
            }
            //close scanner
            input.close();
            //prompt user that the update was successful
            ILUserMessage.setText("Successfully updated list.");

        }

    /*
     * Save List to External File Tab
     */

        public void saveListButtonPressed(ActionEvent actionEvent) {
            //open file
            File outText = new File(SLFilePath.getText());
            try {
                //initialize the file writer
                FileWriter myWriter = new FileWriter(outText);
                //iterate through Tasks
                for(int i = 0; i < mainList.getTaskListSize(); i++) {
                    //get task information
                    String complete = mainList.getTask(i).getCompleted();
                    String date = mainList.getTask(i).getDueDate().toString();
                    String description = mainList.getTask(i).getDescription();
                    //create a string message with the task information
                    String message = String.format("|%10s |%10s |%s ", complete, date, description);
                    //write task information to file
                    myWriter.write(message);
                    myWriter.write("\n");


                }
                //close file writer
                myWriter.close();
                //prompt user that save was successful
                SLUserMessage.setText("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

        public void okButtonPressed(ActionEvent actionEvent) throws IOException {
            //switch screen to the Menu window
            //initialize loader
            FXMLLoader loader = new FXMLLoader();
            //set loader to open the App fxml file
            loader.setLocation(getClass().getResource("App.fxml"));
            //initialize parent value for loader
            Parent tableViewParent = loader.load();
            //initialize scene
            Scene tableViewScene = new Scene(tableViewParent);
            //create a AppController object and let it be a controller
            AppController  controller = loader.getController();
            //call the setAppMainList to transfer the mainList
            controller.setAppMainList(mainList);
            //update the table
            controller.updateTable();
            //get the stage information
            Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            //set scene
            window.setScene(tableViewScene);
            //show scene
            window.show();
        }

        public void setMenuMainList(List newList){
            //for loop that iterates through the tasks in the newList
            for(int i = 0; i < newList.getTaskListSize(); i++){
                //add the tasks to the mainList
                mainList.addTask(newList.getTask(i).getCompleted(), newList.getTask(i).getDueDate(), newList.getTask(i).getDescription());
            }
        }
}
