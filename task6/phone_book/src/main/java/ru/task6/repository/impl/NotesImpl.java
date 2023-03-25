package ru.task6.repository.impl;

import ru.task6.config.AppConfig;
import ru.task6.model.Note;
import ru.task6.repository.Notes;
import ru.task6.utils.FileUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;

public class NotesImpl implements Notes {
    private static HashSet<Note> notes = initCollection();

    private static NotesImpl instance;

    private NotesImpl(){}

    public static NotesImpl getInstance() {
        if (instance == null) {
            instance = new NotesImpl();
        }
        return instance;
    }


    @Override
    public int add(Object entity) {
        this.notes.add((Note) entity);
        FileUtils.writeFile("\n" + ((Note) entity).toString(), AppConfig.getProperty("file.notes"), true);
        return ((Note) entity).personId();
    }

    @Override
    public Optional findById(int id) {
        return Optional.empty();
    }

    @Override
    public Optional<Note> findByPersonId(int personId) {
        return this.notes.stream().filter(note -> note.personId() == personId).findAny();
    }

    @Override
    public void delete(Object entity) {
        this.notes.remove((Note) entity);
        var data = new StringBuilder();
        this.notes.stream()
                .sorted((note1, note2) -> note1.personId() - note2.personId())
                .forEach(note -> data.append(note.toString() + "\n"));
        data.deleteCharAt(data.length()-1);
        FileUtils.writeFile(data.toString(), AppConfig.getProperty("file.notes"), false);
    }

    @Override
    public HashSet<Note> findAll() {
        return this.notes;
    }

    private static HashSet<Note> initCollection() {
        HashSet<Note> notes = new HashSet<>();
        ArrayList<String> data = FileUtils.readFile(AppConfig.getProperty("file.notes"));

        for (String line: data) {
            String[] values = line.split(";");
            int personId = Integer.parseInt(values[0]);
            String note = values[1];
            notes.add(new Note(personId, note));
        }

        return notes;
    }

}
