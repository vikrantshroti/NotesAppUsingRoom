package bms.notesappusingroom.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "notes")
public class Note {

  @PrimaryKey(autoGenerate = true)
  private int id;

  @ColumnInfo(name = "title")
  private String title;

  @ColumnInfo(name = "note")
  private String note;

  public Note() {
  }

  public Note(int id, String title, String note) {
    this.id = id;
    this.title = title;
    this.note = note;
  }

  public Note(String title, String note) {
    this.title = title;
    this.note = note;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

}
