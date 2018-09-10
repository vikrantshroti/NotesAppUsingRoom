package bms.notesappusingroom.ui.add_note;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;
import bms.notesappusingroom.R;
import bms.notesappusingroom.database.LocalCacheManager;
import bms.notesappusingroom.ui.main.MainActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class AddNoteActivity extends AppCompatActivity implements AddNoteViewInterface {


  @BindView(R.id.etTitle)
  EditText etTitle;

  @BindView(R.id.etNote)
  EditText etNote;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activitiy_add_note);
    ButterKnife.bind(this);
  }

  private void saveNote() {
    String title = etTitle.getText().toString();
    String note_text = etNote.getText().toString();

    if (title.equals("") || note_text.equals("")) {
      Toast.makeText(this, "Please fill all the fields before saving", Toast.LENGTH_SHORT).show();
    } else {
      //call method to add note
      LocalCacheManager.getInstance(this).addNotes(this, title, note_text);
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_add_note, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();
    if (id == R.id.action_save) {
      saveNote();
    }
    return super.onOptionsItemSelected(item);
  }

  @Override
  public void onNoteAdded() {
    Toast.makeText(this, "Note Added", Toast.LENGTH_SHORT).show();

    Intent i = new Intent(AddNoteActivity.this, MainActivity.class);
    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    startActivity(i);
  }

  @Override
  public void onDataNotAvailable() {
    Toast.makeText(this, "Could not add note", Toast.LENGTH_SHORT).show();
  }
}
