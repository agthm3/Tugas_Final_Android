package com.halil.tugas_final_android.UI.DetailCharacter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.halil.tugas_final_android.Model.Ability
import com.halil.tugas_final_android.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_abilities.view.*

class AbilityAdapter(private var abilities: MutableList<Ability>): RecyclerView.Adapter<AbilityAdapter.Holder>() {

    inner class Holder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(ability: Ability) {
            with(itemView) {
                Picasso.get()
                    .load(ability.displayIcon)
                    .into(abilityIcon)

                abilityName.text = ability.displayName
                abilityDesc.text = ability.description
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_abilities, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(abilities[position])
    }

    override fun getItemCount(): Int {
        return abilities.size
    }


}