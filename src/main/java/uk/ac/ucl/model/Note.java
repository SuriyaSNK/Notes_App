package uk.ac.ucl.model;

public class Note {
    int noteId;
    String noteName;
    String content;
    String imageUrl;

    public int getNoteId() { return noteId; }

    public void setNoteId(int noteId) { this.noteId = noteId; }

    public String getNoteName(){
        return noteName;
    }

    public void setNoteName(String noteName){
        this.noteName = noteName;
    }

    public String getNoteContent(){
        return content;
    }

    public void setContent(String noteId){
        this.content = noteId;
    }

    public String getImageUrl() { return imageUrl; }

    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}
