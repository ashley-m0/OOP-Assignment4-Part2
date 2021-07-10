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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDate;


public class AppController {

    private List  mainList = new List();
    private int viewControl = 0;

    @FXML private TableView<Task> taskTable;
    @FXML private TableColumn<Task, String> completedColumn;
    @FXML private TableColumn<Task, LocalDate> dueDateColumn;
    @FXML private TableColumn<Task, String> descriptionColumn;
    @FXML private DatePicker dueDateField;
    @FXML private TextField descriptionField;


    @FXML private void initialize(){
        //call updateTable function
        updateTable();
        //set table to be editable and all for items to be selected
        taskTable.setEditable(true);
        taskTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    public void menuButtonPressed(ActionEvent actionEvent) throws IOException {
        //switch screen to the Menu window
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Menu.fxml"));
        Parent AppParent = loader.load();

        Scene tableViewScene = new Scene(AppParent);
        MenuController myMenuController = loader.getController();
        myMenuController.setMenuMainList(mainList);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }

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

    //Edit Table
    public void dueDateEditAsserted(TableColumn.CellEditEvent editCell) {
        Task taskSelected =  taskTable.getSelectionModel().getSelectedItem();
        int search = mainList.findTask(taskSelected.getDescription());
        String newDueDate = editCell.getNewValue().toString();
        LocalDate localDate = LocalDate.parse(newDueDate);
        mainList.getTask(search).setDueDate(localDate);
    }

    public void descriptionEditAsserted(TableColumn.CellEditEvent editCell) {
        Task taskSelected =  taskTable.getSelectionModel().getSelectedItem();
        int search = mainList.findTask(taskSelected.getDescription());
        mainList.getTask(search).setDescription(editCell.getNewValue().toString());
    }


    //Mark Selected Task as Complete
    public void completeTaskButtonPressed(ActionEvent actionEvent) {
        ObservableList<Task> selectedTasks = taskTable.getSelectionModel().getSelectedItems();
        for (Task task: selectedTasks)
        {
            int searchIndex = mainList.findTask(task.getDescription());
            mainList.getTask(searchIndex).setCompleted();
        }
        updateTable();
    }

    public void removeTaskButtonPressed(ActionEvent actionEvent) {
        ObservableList<Task> selectedTasks = taskTable.getSelectionModel().getSelectedItems();
        for (Task task: selectedTasks)
        {
            int searchIndex = mainList.findTask(task.getDescription());
            mainList.removeTask(searchIndex);
        }
        updateTable();
    }

    //Add New Task
    public void createTaskButtonPressed(ActionEvent actionEvent) {
        LocalDate newDueDate = dueDateField.getValue();
        String newDescription = descriptionField.getText();
        createNewTask(newDueDate, newDescription);
    }

    public void createNewTask(LocalDate newDueDate, String newDescription){
        mainList.addTask(newDueDate, newDescription);
        updateTable();
    }

    public void setAppMainList(List newList){
        mainList = newList;
    }

    public void updateTable(){
        //initialize the cell values of the columns
        completedColumn.setCellValueFactory(new PropertyValueFactory<Task, String>("completed"));
        dueDateColumn.setCellValueFactory(new PropertyValueFactory<Task, LocalDate>("dueDate"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Task, String>("description"));

        //set description column to be able to be typed in when user clicks on a cell
        descriptionColumn.setCellFactory(TextFieldTableCell.forTableColumn());

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

}
