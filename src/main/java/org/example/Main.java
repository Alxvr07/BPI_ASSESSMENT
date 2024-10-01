package org.example;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Task task1 = new Task("Task 1", 3);
        Task task2 = new Task("Task 2", 7);
        Task task3 = new Task("Task 3", 14);
        Task task4 = new Task("Task 3", 5);

        task2.addDependencies(task1);
        task3.addDependencies(task2);

        List<Task> taskList = Arrays.asList(task1, task2, task3, task4);

        for (Task task: taskList){
            task.calculateDates();
            System.out.println(task);
        }

    }
}