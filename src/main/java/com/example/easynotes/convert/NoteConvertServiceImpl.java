package com.example.easynotes.convert;

import com.example.easynotes.model.Note;
import com.example.easynotes.resource.NoteResource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteConvertServiceImpl implements NoteConvertService{

    @Override
    public NoteResource convert(Note note) {

        return NoteResource.builder()
                .content(note.getContent())
                .createdDate(note.getCreatedAt())
                .noteId(note.getId())
                .status(note.getStatus())
                .title(note.getTitle())
                .build();
    }

    @Override
    public List<NoteResource> convertNoteList(List<Note> noteByTitle) {
        List<NoteResource> noteResources=new ArrayList<>();
        for(Note note:noteByTitle){
            noteResources.add(convert(note));
        }
        return noteResources;
    }


}

