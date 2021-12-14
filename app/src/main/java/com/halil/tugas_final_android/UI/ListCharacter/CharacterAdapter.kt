package com.halil.tugas_final_android.UI.ListCharacter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.halil.tugas_final_android.Model.Character
import com.halil.tugas_final_android.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_character.view.*

class CharacterAdapter(private val listener: CharacterAdapter.Listener): RecyclerView.Adapter<CharacterAdapter.Holder>() {

    interface Listener {
        fun onItemClick(character: Character)
    }

    private var listCharacter = mutableListOf<Character>()

    inner class Holder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(character: Character, listener: Listener) {
            with(itemView) {
                Picasso.get()
                    .load(character.fullPortrait)
                    .into(img)

                name.text = character.displayName
                this.setOnClickListener {
                    listener.onItemClick(character)
                }
            }
        }
    }

    fun setData(list: MutableList<Character>) {
        this.listCharacter = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        return holder.bind(listCharacter[position], listener)
    }

    override fun getItemCount(): Int {
        return listCharacter.size
    }

}