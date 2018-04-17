package com.example.easynotes.controller;


import com.example.easynotes.convert.NoteConvertService;
import com.example.easynotes.dto.NoteDto;
import com.example.easynotes.model.Note;
import com.example.easynotes.repository.NoteRepository;
import com.example.easynotes.resource.NoteResource;
import com.example.easynotes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class NoteController {

    private final NoteService noteService;
    private final NoteConvertService noteConvertService;
    private final NoteRepository noteRepository;

    @Autowired
    public NoteController(NoteService noteService, NoteConvertService noteConvertService, NoteRepository noteRepository) {
        this.noteService = noteService;
       this.noteConvertService = noteConvertService;
       this.noteRepository = noteRepository;
    }

 @GetMapping(value = "/notes")
   public List<Note> getAllNotes() {

        return noteService.findAll();
  }

    @GetMapping(value = "/notes/{noteId}")
    public Note getNoteById(@PathVariable(value = "noteId") Long noteId){

        return noteService.findById(noteId);
    }

   @PostMapping(value = "/notes")
    public NoteResource addNewNote(@RequestBody NoteDto noteDto){
        return noteConvertService.convert(noteService.addNewNotes(noteDto));
    }

    @PutMapping(value = "/notes/{id}")
    public NoteResource updateNote(@PathVariable(value = "id") Long noteId,@RequestBody NoteDto noteDto){
        return noteConvertService.convert(noteService.updateNote(noteDto,noteId));
    }

    @PostMapping(value = "/notes/update/{id}")
    public NoteResource deleteNote(@PathVariable(value = "id") Long noteId,@RequestBody NoteDto noteDto){
        return noteConvertService.convert(noteService.deleteNote(noteDto,noteId));
    }


    @GetMapping(value = "/notes/title")
    public List<NoteResource> getNoteByTitle(@RequestParam(value = "title")String title){
        return noteConvertService.convertNoteList(noteService.getNoteByTitle(title));
    }
}
