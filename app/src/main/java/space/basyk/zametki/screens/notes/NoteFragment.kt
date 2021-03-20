package space.basyk.zametki.screens.notes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import org.koin.android.viewmodel.ext.android.viewModel
import space.basyk.zametki.R
import space.basyk.zametki.databinding.FragmentNoteBinding
import space.basyk.zametki.models.NoteModel
import space.basyk.zametki.utils.APP_ACTIVITY_MAIN


class NoteFragment : Fragment() {

    private var binding: FragmentNoteBinding?= null
    private val mBinding get() = binding!!
    private val viewModel: NotesViewModel by viewModel()

    lateinit var observer: Observer<List<NoteModel>>
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: NotesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNoteBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
        recyclerView.adapter = null
        viewModel.allNotes.removeObserver(observer)
    }

    private fun initialization() {
        recyclerView = mBinding.recyclerNote
        adapter = NotesAdapter(viewModel)
        recyclerView.adapter = adapter
        observer = Observer {
            val list = it.asReversed()
            adapter.setList(list)
        }
        viewModel.allNotes.observe(this, observer)
        mBinding.addNote.setOnClickListener {
            APP_ACTIVITY_MAIN.navController.navigate(R.id.action_noteFragment_to_addNoteFragment)
        }
    }
}