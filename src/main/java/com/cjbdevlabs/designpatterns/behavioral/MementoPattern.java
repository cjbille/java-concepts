package com.cjbdevlabs.designpatterns.behavioral;

/*
Allows you to save the state of an object without breaking the principle of encapsulation.
Originator and caretaker objects. Memento object is in between the originator and caretaker
 */
public class MementoPattern {

    static class DocumentViewer {

        public static void main(String[] args) {
            var textDocument = new TextDocument();
            textDocument.write("Hello, world! ");
            textDocument.save();
            textDocument.print();
            textDocument.write("How are you?");
            textDocument.print();
            textDocument.undo();
            textDocument.print();
        }
    }

    static class TextDocument {

        private String text = "";
        private TextDocumentState state = new TextDocumentState(text);

        public void write(String text) {
            this.text += text;
        }

        public void print() {
            System.out.println(text);
        }

        public void save() {
            state.setState(text);
        }

        public void undo() {
            text = state.getState();
        }
    }

    static class TextDocumentState {

        private String state;

        public TextDocumentState(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }
    }
}
