package ru.skypro.lessons.SpringBoot.exceptions;


public class IdNotFoundException extends RuntimeException {
    private int id;

    public IdNotFoundException(int id) {
        this.id = id;
    }
    public IdNotFoundException() {
    }

    public int getId() {
        return id;
    }
}
