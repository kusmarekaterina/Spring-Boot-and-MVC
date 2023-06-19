package ru.skypro.lessons.SpringBoot.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class IdNotFoundException extends RuntimeException {
    private final int id;
}
