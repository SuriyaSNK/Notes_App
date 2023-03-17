package uk.ac.ucl.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class Model
{
  public static Type type = new TypeToken<List<Note>>(){}.getType();
  public static List<Note> note;
  public int numElements;

  public Object getContent(int noteId)
  {
    return note.get(noteId).content;
  }
  public Object getImageUrl(int noteId)
  {
    return note.get(noteId).imageUrl;
  }

  public List<String> getListNames() throws IOException {
    String string = new String(Files.readAllBytes(Paths.get("data/notes.json")));
    note = new Gson().fromJson(string, type);
    numElements = note.size();

    List<String> noteNames = new java.util.ArrayList<>(Collections.emptyList());
    for (int i = 0; i < numElements; i++){
      noteNames.add(note.get(i).noteName);
    }
    return noteNames;
  }

  public List<Integer> getListIds() throws IOException {
    String string = new String(Files.readAllBytes(Paths.get("data/notes.json")));
    note = new Gson().fromJson(string, type);
    numElements = note.size();

    List<Integer> noteIds = new java.util.ArrayList<>(Collections.emptyList());
    for (int i = 0; i < numElements; i++){
      noteIds.add(note.get(i).noteId);
    }
    return noteIds;
  }

  public void addNote(String noteName, String content, String imageUrl) throws IOException {
    int noteId = note.size() + 1;

    Note newNote = new Note();
    newNote.setNoteId(noteId);
    newNote.setNoteName(noteName);
    newNote.setContent(content);
    newNote.setImageUrl(imageUrl);

    note.add(newNote);

    Gson gson = new Gson();
    Writer writer = Files.newBufferedWriter(Paths.get("data/notes.json"));
    gson.toJson(note, writer);
    writer.close();
  }

  public void deleteNote(Integer noteId) throws IOException {
    numElements = note.size();
    note.remove(noteId - 1);

    if (numElements != 1) {
      for (int i = noteId - 1; i < numElements - 1; i++) {
        note.get(i).setNoteId(i + 1);
      }
    }

    Gson gson = new Gson();
    Writer writer = Files.newBufferedWriter(Paths.get("data/notes.json"));
    gson.toJson(note, writer);
    writer.close();
  }

  public boolean editNote(Integer noteId, String noteContent, String imageUrl) throws IOException {
    String string = new String(Files.readAllBytes(Paths.get("data/notes.json")));
    note = new Gson().fromJson(string, type);

    try {
      noteId--;
      note.get(noteId).setContent(noteContent);
      note.get(noteId).setImageUrl(imageUrl);

      Gson gson = new Gson();
      Writer writer = Files.newBufferedWriter(Paths.get("data/notes.json"));
      gson.toJson(note, writer);
      writer.close();

      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public void renameNote(Integer noteId, String noteName) throws IOException {
    String string = new String(Files.readAllBytes(Paths.get("data/notes.json")));
    note = new Gson().fromJson(string, type);

    noteId--;
    note.get(noteId).setNoteName(noteName);

    Gson gson = new Gson();
    Writer writer = Files.newBufferedWriter(Paths.get("data/notes.json"));
    gson.toJson(note, writer);
    writer.close();
  }

  public Object searchFor(String keyword)
  {
    return note.get(Integer.parseInt(keyword) - 1);
  }
}
