package ru.task6.repository;

import ru.task6.model.Note;

import java.util.Optional;

public interface Notes extends DataBase{
    Optional<Note> findByPersonId(int personId);
}
