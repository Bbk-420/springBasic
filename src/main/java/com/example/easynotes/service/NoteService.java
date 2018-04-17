package com.example.easynotes.service;

import com.example.easynotes.dto.NoteDto;
import com.example.easynotes.model.Note;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NoteService {
    //returns findAll
    List<Note> findAll();

    /**
     * This method return note by id
     * @param noteId
     * @return Note
     */
   Note findById(Long noteId);


    Note updateNote(NoteDto noteDto,Long noteId);

    List<Note> getNoteByTitle(String title);

    Note addNewNotes(NoteDto noteDto);

    Note deleteNote(NoteDto noteDto, Long noteId);

}
