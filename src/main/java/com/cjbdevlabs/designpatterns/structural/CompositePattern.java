package com.cjbdevlabs.designpatterns.structural;

import java.util.ArrayList;
import java.util.List;

/*
Treat objects and groups of objects in the same way
 */
public class CompositePattern {

    interface Completable {
        void isCompleted();
    }

    static class TodoItem implements Completable {

        private final String description;
        private boolean completed = false;

        public TodoItem(String description) {
            this.description = description;
        }

        public void complete() {
            completed = true;
        }

        @Override
        public void isCompleted() {
            System.out.println("Todo complete");
        }
    }

    static class Checklist implements Completable {

        List<TodoItem> todoItems = new ArrayList<>();

        public void addTodoItem(TodoItem todoItem) {
            todoItems.add(todoItem);
        }

        @Override
        public void isCompleted() {
            System.out.println("Checklist complete");
        }
    }

    static class App {

        public static void main(String[] args) {
            Checklist checklist = new Checklist();
            var todoItem1 = new TodoItem("Do this");
            var todoItem2 = new TodoItem("Do that");
            var todoItem3 = new TodoItem("Do something else");

            checklist.addTodoItem(todoItem1);
            checklist.addTodoItem(todoItem2);
            checklist.addTodoItem(todoItem3);

            todoItem1.complete();

        }
    }
}
