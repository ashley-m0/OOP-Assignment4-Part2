package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Ashley Mojica
 */

import java.util.ArrayList;

public class List {

    private String title;
    private ArrayList<Task> taskList;

    public List(String title){
        this.title = title;
        this.taskList = new ArrayList<Task>();
    }

    //setter method for title
    public void setTitle(String title){
        this.title = title;
    }

    //getter method for title
    public String getTitle(){
        return title;
    }

    public boolean addTask(String dueDate, String description){
        //search if the task has already been created and put result in a int variable
        //if search variable equals -1
            //create new task variable from input information
            //add task to ArrayList
            //return that the task was successfully added(true = successful add)
        //else
            //indicate that the task has already been previously added (false = unsuccessful add)
            return false;
    }

    public Task getTask(int index){
        //returns a Task Variable from the index in the ArrayList desired
        return null;
    }

    //findTask method that takes in a string for the description of a task and returns the index of the task in the ArrayList
    public int findTask(String description){
        //for loop that iterates through the ArrayList of Tasks
            //String variable set to equal the description of a certain task in the iteration
            //if the description equals the given description
                //return the index of the task in the ArrayList

        //if the method reaches here return a -1 indicating the task was not found
        return -1;
    }


}
