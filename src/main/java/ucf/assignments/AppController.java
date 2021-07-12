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
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;


public class AppController implements Initializable {

    private List  mainList = new List();
    private int viewControl = 0;

    @FXML private TableView<Task> taskTable;
    @FXML private TableColumn<Task, String> completedColumn;
    @FXML private TableColumn<Task, String> dueDateColumn;
    @FXML private TableColumn<Task, String> descriptionColumn;
    @FXML private DatePicker dueDateField;
    @FXML private TextField descriptionField;

    /*
     * Change View DropDown
     */
    public void showAllTasksSelected(ActionEvent actionEvent) {
        //set viewControl to 0 and update table
        viewControl = 0;
        updateTable();
    }

    public void showCompletedTasksSelected(ActionEvent actionEvent) {
        //set viewControl to 1 and update table
        viewControl = 1;
        updateTable();
    }

    public void showUncompletedTasksSelected(ActionEvent actionEvent) {
        //set viewControl to 2 and update table
        viewControl = 2;
        updateTable();
    }

    /*
     * ActionEvent Methods
     */

    public void menuButtonPressed(ActionEvent actionEvent) throws IOException {
        //switch screen to the Menu window
        //initialize loader
        FXMLLoader loader = new FXMLLoader();
        //set loader to open the Menu fxml file
        loader.setLocation(getClass().getResource("Menu.fxml"));
        //initialize parent value for loader
        Parent tableViewParent = loader.load();
        //initialize scene
        Scene tableViewScene = new Scene(tableViewParent);
        //create a MenuController object and let it be a controller
        MenuController controller = loader.getController();
        //call the setMenuMainList to transfer the mainList
        controller.setMenuMainList(mainList);
        //get the stage information
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        //set scene
        window.setScene(tableViewScene);
        //show scene
        window.show();
    }

    public void dueDateEditAsserted(TableColumn.CellEditEvent editCell) {
        //get the selected task
        Task taskSelected =  taskTable.getSelectionModel().getSelectedItem();
        //find the selected task in the mainList
        int search = mainList.findTask(taskSelected.getDescription());
        //get the newly inserted date
        String newDueDate = editCell.getNewValue().toString();
        //set the new dueDate
        mainList.getTask(search).setDueDate(newDueDate);
    }

    public void descriptionEditAsserted(TableColumn.CellEditEvent editCell) {
        //get selected task
        Task taskSelected =  taskTable.getSelectionModel().getSelectedItem();
        //find the selected task in the mainlist
        int search = mainList.findTask(taskSelected.getDescription());
        //set the description to the newly inserted description
        mainList.getTask(search).setDescription(editCell.getNewValue().toString());
    }

    public void completeTaskButtonPressed(ActionEvent actionEvent) {
        //get selected tasks
        ObservableList<Task> selectedTasks = taskTable.getSelectionModel().getSelectedItems();
        //call setTasksComplete method
        setTasksComplete(selectedTasks, true);
        //call the updateTable method
        updateTable();
    }

    public void incompleteTaskAsserted(ActionEvent actionEvent) {
        //get selected tasks
        ObservableList<Task> selectedTasks = taskTable.getSelectionModel().getSelectedItems();
        //call setTasksComplete method
        setTasksComplete(selectedTasks, false);
        //call the updateTable method
        updateTable();
    }

    public void removeTaskButtonPressed(ActionEvent actionEvent) {
        //get selected tasks
        ObservableList<Task> selectedTasks = taskTable.getSelectionModel().getSelectedItems();
        //for loop that iterates through selected tasks
        for (Task task: selectedTasks)
        {
            //find task in mainList
            int searchIndex = mainList.findTask(task.getDescription());
            //remove task from mainList
            mainList.removeTask(searchIndex);
        }
        //call the updateTable method
        updateTable();
    }

    public void clearListButtonAsserted(ActionEvent actionEvent) {
        //call clearList method
        clearList();
        //call updateTable method
        updateTable();
    }

    public void createTaskButtonPressed(ActionEvent actionEvent) {
        //get user inserted date
        LocalDate date = dueDateField.getValue();
        //make localDate into a string
        String newDueDate = date.toString();
        //get user inserted description
        String newDescription = descriptionField.getText();
        //call the createNewTask method
        createNewTask(newDueDate, newDescription);
    }

    /*
     * Methods
     */

    public void createNewTask(String newDueDate, String newDescription){
        //call addTask method and set values to be the input values
        mainList.addTask("Not Complete", newDueDate, newDescription);
        //call the updateTable method
        updateTable();
    }

    public void setTasksComplete(ObservableList<Task> selectedTasks, boolean complete){
        //for loop that iterates through all of the tasks selected
        for (Task task: selectedTasks)
        {
            //find the selected task in the mainList
            int search = mainList.findTask(task.getDescription());
            //set task's complete to false
            mainList.getTask(search).setCompleted(complete);
        }
    }

    public void clearList(){
        //for loop that iterates through the mainList's taskList from top to bottom
        for(int i = (mainList.getTaskListSize() - 1); i >= 0 ; i--){
            //remove each task
            mainList.removeTask(i);
        }
    }

    public void setAppMainList(List newList){
        //for loop that iterates through all of the tasks in the newList's taskList
        for(int i = 0; i < newList.getTaskListSize(); i++){
            //add tasks to the mainList
            mainList.addTask(newList.getTask(i).getCompleted(), newList.getTask(i).getDueDate(), newList.getTask(i).getDescription());
        }
    }

    public void updateTable(){
        //initialize the cell values of the columns
        completedColumn.setCellValueFactory(new PropertyValueFactory<Task, String>("completed"));
        dueDateColumn.setCellValueFactory(new PropertyValueFactory<Task, String>("dueDate"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Task, String>("description"));

        //set description column to be able to be typed in when user clicks on a cell
        descriptionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        dueDateColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        //set the items in the table by calling the getAllTaskInfo function
        taskTable.setItems(getAllTaskInfo());
    }

    public ObservableList<Task> getAllTaskInfo() {
        //initialize a string of values to compare the completions to
        //each index corresponds to a certain view
        String[] views = {"", "Not Completed", "Completed"};
        //initialize an ObservableList that will contain the information that will be added into the table
        ObservableList<Task> listInfo = FXCollections.observableArrayList();
        //for loop that iterates from 0 to the size of the taskList
        for(int i = 0; i < mainList.getTaskListSize(); i++){
            //if the task's completion doesn't equal the value in views at index of ViewControl
            if (!mainList.getTask(i).getCompleted().equals(views[viewControl])){
                //add Task to the ObservableList
                listInfo.add(mainList.getTask(i));
            }
        }
        //return ObservableList
        return listInfo;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //call updateTable function
        updateTable();
        //set table to be editable and all for items to be selected
        taskTable.setEditable(true);
        taskTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }


}
