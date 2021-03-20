package space.basyk.zametki.screens.addnotes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.koin.android.viewmodel.ext.android.viewModel
import space.basyk.zametki.R
import space.basyk.zametki.databinding.FragmentAddNoteBinding
import space.basyk.zametki.models.NoteModel
import space.basyk.zametki.utils.APP_ACTIVITY_MAIN


class AddNoteFragment : Fragment() {

    private var binding: FragmentAddNoteBinding?= null
    private val mBinding get() = binding!!
    private val viewModel: AddNotesViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddNoteBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun initialization() {
        mBinding.addNote.setOnClickListener {
            val noteTitle = mBinding.titleNote.text.toString()
            viewModel.insertNote(NoteModel(titleNote = noteTitle)){}
            APP_ACTIVITY_MAIN.navController.navigate(R.id.action_addNoteFragment_to_noteFragment)
        }
    }

}