package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Ashley Mojica
 */

public class Task {

    private String dueDate;
    private String description;
    private boolean completed;

    public Task(String dueDate, String description){
        this.dueDate = dueDate;
        this.description = description;
        this.completed = false;
    }

    //getter for due date
    public String getDueDate(){
        return dueDate;
    }

    public void setDueDate(String dueDate){
        this.dueDate = dueDate;
    }

    //getter for description
    public String getDescription(){
        return description;
    }

    //setter for description
    public void setDescription(String description){
        this.description = description;
    }

    //getter for completed
    public boolean getCompleted(){
        return completed;
    }

    //setter for completed
    public void setCompleted(boolean completed){
        this.completed = completed;
    }
}
