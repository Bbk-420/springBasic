package com.example.easynotes.resource;

import com.example.easynotes.model.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Setter
@Getter
@Builder
public class NoteResource {
    private Long noteId;
    private String title;
    private String content;
    private Date createdDate;
    private Status status;
}
