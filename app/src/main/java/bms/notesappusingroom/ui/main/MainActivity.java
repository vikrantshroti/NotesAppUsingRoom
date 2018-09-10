package bms.notesappusingroom.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;
import bms.notesappusingroom.R;
import bms.notesappusingroom.adapters.NotesAdapter;
import bms.notesappusingroom.database.LocalCacheManager;
import bms.notesappusingroom.models.Note;
import bms.notesappusingroom.ui.add_note.AddNoteActivity;
import bms.notesappusingroom.ui.edit_note.RecyclerViewListener;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainViewInterface {

  @BindView(R.id.rvNotes)
  RecyclerView rvNotes;

  RecyclerView.Adapter adapter;
  List<Note> notesList;
  RecyclerViewListener listener;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ButterKnife.bind(this);

    initViews();
    loadNotes();
  }

  private void initViews() {
    rvNotes.setLayoutManager(new LinearLayoutManager(this));
  }

  private void loadNotes() {
    //call method to get notes
    LocalCacheManager.getInstance(this).getNotes(this);
  }

  @OnClick(R.id.fabAddNote)
  public void addNote() {
    Intent i = new Intent(MainActivity.this, AddNoteActivity.class);
    startActivity(i);
  }

  @Override
  public void onNotesLoaded(List<Note> notes) {

    notesList = notes;

    if (notesList.size() == 0) {
      onDataNotAvailable();
    } else {
      listener = new RecyclerViewListener() {
        @Override
        public void onClick(View view, int position) {
          Toast.makeText(MainActivity.this, "position " + position, Toast.LENGTH_SHORT).show();
          //assignment - use this method and put edit note functionality
        }
      };
      adapter = new NotesAdapter(this, notes, listener);
      rvNotes.setAdapter(adapter);
    }

  }

  @Override
  public void onNoteAdded() {
    Toast.makeText(this, "Note Added", Toast.LENGTH_SHORT).show();
  }

  @Override
  public void onDataNotAvailable() {
    Toast.makeText(this, "No Notes yet", Toast.LENGTH_SHORT).show();
  }
}
