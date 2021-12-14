package com.halil.tugas_final_android.UI.ListCharacter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.halil.tugas_final_android.Model.Character
import com.halil.tugas_final_android.R
import com.halil.tugas_final_android.UI.DetailCharacter.DetailCharacterFragment
import kotlinx.android.synthetic.main.fragment_list_character.*
import kotlinx.coroutines.launch

class ListCharacterFragment : Fragment() {

    private lateinit var viewModel: ListCharacterViewModel
    private lateinit var adapter: CharacterAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(this)[ListCharacterViewModel::class.java]
        return inflater.inflate(R.layout.fragment_list_character, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = CharacterAdapter(object : CharacterAdapter.Listener {
            override fun onItemClick(character: Character) {
                DetailCharacterFragment.selectedCharacter = character
                findNavController().navigate(R.id.action_listCharacterFragment_to_detailCharacterFragment)
            }
        })

        rcView_characters.setHasFixedSize(true)
        rcView_characters.layoutManager = GridLayoutManager(requireContext(), 2)
        rcView_characters.adapter = adapter

        lifecycleScope.launch {
            viewModel.getCharacters(adapter)
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = ListCharacterFragment()
    }
}