package space.basyk.zametki.screens.notes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_note.view.*
import space.basyk.zametki.R
import space.basyk.zametki.models.NoteModel
import space.basyk.zametki.utils.showToast

class NotesAdapter(private val viewModel: NotesViewModel): RecyclerView.Adapter<NotesAdapter.MyViewHolder>() {

    private var listNotes = emptyList<NoteModel>()
    private lateinit var deleteViewModel: NotesViewModel

    class MyViewHolder(view: View):RecyclerView.ViewHolder(view) {
        var noteTitle: TextView = view.item_title_note
        var btnDel: ImageView = view.img_delete_note
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.noteTitle.text = listNotes[position].titleNote
        holder.btnDel.setOnClickListener {
            showToast("Заметка удалена")
            deleteViewModel.deleteNote(listNotes[position])
        }
    }

    override fun getItemCount(): Int {
        return listNotes.size
    }

    fun setList(list: List<NoteModel>){
        listNotes = list
        deleteViewModel = viewModel
        notifyDataSetChanged()
    }
}