package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printError() {
        System.out.println("Active: " + active);
        System.out.println("Status: " + status);
        System.out.println("Message: " + message);
    }

    public static void main(String[] args) {
        Error unknown = new Error();
        Error error500 = new Error(true, 500, "Internal Server Error");
        Error error501 = new Error(true, 501, "Not Implemented");
        unknown.printError();
        error500.printError();
        error501.printError();
    }
}
