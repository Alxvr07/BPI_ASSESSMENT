package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Task {
    private String name;
    private int duration;
    private List<Task> dependencies;
    private LocalDate startDate;
    private LocalDate endDate;

    public Task(String name, int duration) {
        this.name = name;
        this.duration = duration;
        this.dependencies = new ArrayList<>();
    }

    void addDependencies(Task task){
        dependencies.add(task);
    }

    public LocalDate calculateStartDate() {
        if (dependencies.isEmpty()) {
            return LocalDate.now();
        }

        LocalDate latestEndDate = LocalDate.MIN;
        for (Task dependency : dependencies) {
            if (dependency.endDate != null && dependency.endDate.isAfter(latestEndDate)) {
                latestEndDate = dependency.endDate;
            }
        }

        return latestEndDate.plusDays(1);
    }

    public void calculateDates() {
        this.startDate = calculateStartDate();
        this.endDate = this.startDate.plusDays(this.duration - 1);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<Task> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<Task> dependencies) {
        this.dependencies = dependencies;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return duration == task.duration && Objects.equals(name, task.name) && Objects.equals(dependencies, task.dependencies) && Objects.equals(startDate, task.startDate) && Objects.equals(endDate, task.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, duration, dependencies, startDate, endDate);
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", duration=" + duration +
                ", dependencies=" + dependencies +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
