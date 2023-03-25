package ru.task6.service;

import ru.task6.model.Note;

import java.util.HashSet;
import java.util.Optional;

public interface NoteService {
    int addNote(Note note);
    Optional<Note> findByPersonId(int personId);
    HashSet<Note> findAll();
    void removeNote(Note note);
}
