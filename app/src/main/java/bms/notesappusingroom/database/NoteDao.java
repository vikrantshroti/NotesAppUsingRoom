package bms.notesappusingroom.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import bms.notesappusingroom.models.Note;
import io.reactivex.Maybe;
import java.util.List;

@Dao
public interface NoteDao {

  @Query("SELECT * fROM notes")
  Maybe<List<Note>> getAll();

  @Insert
  void insertAll(Note... notes);

}
