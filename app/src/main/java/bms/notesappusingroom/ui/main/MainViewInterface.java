package bms.notesappusingroom.ui.main;

import bms.notesappusingroom.models.Note;
import java.util.List;

public interface MainViewInterface {

  void onNotesLoaded(List<Note> notes);

  void onNoteAdded();

  void onDataNotAvailable();

}
