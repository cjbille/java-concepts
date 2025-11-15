package com.cjbdevlabs.designpatterns.behavioral;

import java.util.ArrayList;
import java.util.List;

/*
Allows you to perform an operation on all elements of an object without making changes to those elements
 */
public class VisitorPattern {

     interface FileSystemElement {

        String getName();

        void accept(Visitor visitor);
    }

    static class File implements FileSystemElement {

        private final String name;
        private final int size;

        public File(String name, int size) {
            this.name = name;
            this.size = size;
        }

        @Override
        public String getName() {
            return name;
        }

        public int getSize() {
            return size;
        }

        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    static class Directory implements FileSystemElement {

        private final String name;
        private final List<FileSystemElement> elements = new ArrayList<>();

        public Directory(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }

        public void addElement(FileSystemElement element) {
            elements.add(element);
        }

        public List<FileSystemElement> getElements() {
            return elements;
        }

        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    interface Visitor {

         void visit(File file);

         void visit(Directory directory);
    }

    static class CalculateSizeVisitor implements Visitor {

         private int totalSize;

         @Override
         public void visit(File file) {
             totalSize += file.getSize();
         }

         @Override
         public void visit(Directory directory) {
             directory.getElements().forEach(e -> e.accept(this));
         }

         public int getTotalSize() {
             return totalSize;
         }
    }

    static class App {

        public static void main(String[] args) {

            var directory1 = new Directory("Directory1");
            var file1 = new File("file1.txt", 100);
            directory1.addElement(file1);

            var directory2 = new Directory("Directory2");
            var file2 = new File("file2.txt", 200);
            directory2.addElement(file2);

            directory1.addElement(directory2);

            var visitor = new CalculateSizeVisitor();
            directory1.accept(visitor);
            System.out.println("Total size: " + visitor.getTotalSize());
        }
    }
}
