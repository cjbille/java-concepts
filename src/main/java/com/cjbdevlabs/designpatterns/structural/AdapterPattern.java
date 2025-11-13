package com.cjbdevlabs.designpatterns.structural;

/*
A structural design pattern that allows incompatible interfaces to work together by creating a middle layer, the
adapter, which acts a translator. It is commonly used when you need to integrate existing classes with a new system
without modifying their source code.
 */
public class AdapterPattern {

    public interface DocumentUploader {

        void upload();
    }

    static class OnlineApplication {

        private final DocumentUploader documentUploader;

        public OnlineApplication(DocumentUploader documentUploader) {
            this.documentUploader = documentUploader;
        }

        public void uploadDocument() {
            documentUploader.upload();
        }
    }

    static class PdfDocumentUploader implements DocumentUploader {

        @Override
        public void upload() {
            System.out.println("Preparing PDF document...");
            System.out.println("Uploading PDF document");
        }
    }

    static class WordDocumentUploader {

        public void uploadWordDocument() {
            System.out.println("Preparing Word document");
            System.out.println("Uploading Word document");
        }
    }

    static class WordDocumentUploaderAdapter extends WordDocumentUploader implements DocumentUploader {

        @Override
        public void upload() {
            uploadWordDocument();
        }

        @Override
        public void uploadWordDocument() {
            System.out.println("Preparing Word document...");
            System.out.println("Uploading Word document");
        }
    }

    static class App {

        public static void main(String[] args) {
            var pdfDocumentUploader = new PdfDocumentUploader();
            var onlineApplication = new OnlineApplication(pdfDocumentUploader);
            var wordDocumentUploader = new WordDocumentUploaderAdapter();
            var onlineApplication2 = new OnlineApplication(wordDocumentUploader);
            onlineApplication.uploadDocument();
            onlineApplication2.uploadDocument();
        }
    }
}
