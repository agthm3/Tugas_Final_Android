package com.halil.tugas_final_android.UI.DetailCharacter

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.halil.tugas_final_android.Model.Ability
import com.halil.tugas_final_android.Model.Character
import com.halil.tugas_final_android.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail_character.*

class DetailCharacterFragment : Fragment() {
    private val TAG = "DetailCharacterFragment"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_character, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbarDetail.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }

        Picasso.get()
            .load(selectedCharacter!!.fullPortrait)
            .into(detailThumb)

        detailName.text = selectedCharacter!!.displayName
        detailDesc.text = selectedCharacter!!.description

        Picasso.get()
            .load(selectedCharacter!!.role.displayIcon)
            .into(roleIcon)

        roleTxt.text = selectedCharacter!!.role.displayName
        roleDesc.text = selectedCharacter!!.role.description

        rcView_abilities.setHasFixedSize(true)
        rcView_abilities.layoutManager = LinearLayoutManager(requireContext())
        val abilities = selectedCharacter!!.abilities as MutableList<Ability>
        Log.d(TAG, "abilities : ${abilities.size}")
        rcView_abilities.adapter = AbilityAdapter(abilities)

    }

    companion object {
        @JvmStatic
        fun newInstance() = DetailCharacterFragment()
        var selectedCharacter: Character? = null
    }
}