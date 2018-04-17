package com.example.easynotes.convert;

import com.example.easynotes.model.Note;
import com.example.easynotes.resource.NoteResource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NoteConvertService {

    NoteResource convert(Note note);

    List<NoteResource> convertNoteList(List<Note> noteByTitle);

}
