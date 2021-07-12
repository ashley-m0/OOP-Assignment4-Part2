package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Ashley Mojica
 */

import java.time.LocalDate;

public class Task {

    private String dueDate;
    private String description;
    private String completed;

    public Task(String completed, String dueDate, String description){
        this.completed = completed;
        this.dueDate = dueDate;
        this.description = description;
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
    public String getCompleted(){
        return completed;
    }

    //setter for completed
    public void setCompleted(boolean complete){
        if (complete){
            this.completed = "Completed";
        } else {
            this.completed = "Not Completed";
        }

    }

}
