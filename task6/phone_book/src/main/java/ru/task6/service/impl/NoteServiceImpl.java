package ru.task6.service.impl;

import ru.task6.model.Note;
import ru.task6.repository.Notes;
import ru.task6.repository.impl.NotesImpl;
import ru.task6.service.NoteService;

import java.util.HashSet;
import java.util.Optional;

public class NoteServiceImpl implements NoteService {
    private static Notes notes = NotesImpl.getInstance();
    @Override
    public int addNote(Note note) {
        return notes.add(note);
    }

    @Override
    public Optional<Note> findByPersonId(int personId) {
        return notes.findByPersonId(personId);
    }

    @Override
    public HashSet<Note> findAll() {
        return notes.findAll();
    }

    @Override
    public void removeNote(Note notes) {
        this.notes.delete(notes);
    }
}
