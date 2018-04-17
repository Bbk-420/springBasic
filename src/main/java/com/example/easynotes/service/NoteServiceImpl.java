package com.example.easynotes.service;

import com.example.easynotes.dto.NoteDto;
import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Note;
import com.example.easynotes.model.Status;
import com.example.easynotes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    @Autowired
    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    @Override
    public Note findById(Long noteId) {
        return noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
    }

    @Override
    public Note updateNote(NoteDto noteDto, Long noteId) {
        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
        note.setTitle(noteDto.getTitle());
        note.setContent(noteDto.getContent());
        return noteRepository.save(note);
    }

    @Override
    public List<Note> getNoteByTitle(String title) {
        return noteRepository.getNoteByTitle(title);
    }

    @Override
    public Note addNewNotes(NoteDto noteDto) {
        Note note = new Note();
        note.setTitle(noteDto.getTitle());
        note.setContent(noteDto.getContent());
        note.setStatus(Status.ACTIVE);
        return noteRepository.save(note);
    }

    @Override
    public Note deleteNote(NoteDto noteDto, Long noteId) {
        Note note=noteRepository.findById(noteId)
                .orElseThrow(()-> new ResourceNotFoundException("Note","id", noteId));
        note.setStatus(Status.ACTIVE);
        return noteRepository.save(note);
    }

}




