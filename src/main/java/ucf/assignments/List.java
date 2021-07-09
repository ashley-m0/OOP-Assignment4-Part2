package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Ashley Mojica
 */

import java.time.LocalDate;
import java.util.ArrayList;

public class List {

    private ArrayList<Task> taskList;

    public boolean addTask(LocalDate dueDate, String description){
        //initialize the boolean statement for whether the task was successfully uploaded
        //set to false to take care of the chance that the task already exists
        boolean addSuccessful = false;
        //search if the task has already been created and put result in a int variable
        int taskIndex = findTask(description);
        //if search variable equals -1
        if(taskIndex == -1) {
            //create new task variable from input information
            Task newTask = new Task(dueDate, description);
            //add task to ArrayList
            taskList.add(newTask);
            //return that the task was successfully added(true = successful add)
            addSuccessful = true;
        }
        return addSuccessful;
    }

    public Task getTask(int index){
        //returns a Task Variable from the index in the ArrayList desired
        return taskList.get(index);
    }

    //findTask method that takes in a string for the description of a task and returns the index of the task in the ArrayList
    public int findTask(String description){
        //for loop that iterates through the ArrayList of Tasks
        for(int i = 0; i < taskList.size(); i++) {
            //String variable set to equal the description of a certain task in the iteration
            String currDescription = taskList.get(i).getDescription();
            //if the description equals the given description
            if(currDescription.equals(description)) {
                //return the index of the task in the ArrayList
                return i;
            }
        }
        //if the method reaches here return a -1 indicating the task was not found
        return -1;
    }

    public int getTaskListSize(){
        return taskList.size();
    }
}
