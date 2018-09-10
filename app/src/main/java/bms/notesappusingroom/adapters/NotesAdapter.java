package bms.notesappusingroom.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import bms.notesappusingroom.R;
import bms.notesappusingroom.models.Note;
import bms.notesappusingroom.ui.edit_note.RecyclerViewListener;
import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {

  Context context;
  List<Note> noteList = new ArrayList<>();
  RecyclerViewListener recyclerViewListener;


  public NotesAdapter(Context context, List<Note> noteList, RecyclerViewListener listener) {
    this.recyclerViewListener = listener;
    this.context = context;
    this.noteList = noteList;
  }

  @NonNull
  @Override
  public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(context).inflate(R.layout.row_note, parent, false);
    NotesViewHolder notesViewHolder = new NotesViewHolder(v, recyclerViewListener);
    return notesViewHolder;
  }

  @Override
  public void onBindViewHolder(@NonNull NotesViewHolder notesViewHolder, int position) {
    notesViewHolder.tvTitle.setText(noteList.get(position).getTitle());
    notesViewHolder.tvNote.setText(noteList.get(position).getNote());
  }

  @Override
  public int getItemCount() {
    return noteList.size();
  }

  public class NotesViewHolder extends RecyclerView.ViewHolder implements
      View.OnClickListener {

    TextView tvTitle, tvNote;

    public NotesViewHolder(@NonNull View itemView, RecyclerViewListener listener) {
      super(itemView);
      recyclerViewListener = listener;
      itemView.setOnClickListener(this);

      tvNote = itemView.findViewById(R.id.tvNoteText);
      tvTitle = itemView.findViewById(R.id.tvNoteTitle);
    }

    @Override
    public void onClick(View v) {
      recyclerViewListener.onClick(v, getAdapterPosition());
    }
  }
}
