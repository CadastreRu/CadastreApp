package ru.dev.android.cadastre.presentation.definition.list.adapter

import androidx.recyclerview.widget.DiffUtil
import ru.dev.android.cadastre.domain.definitions.entity.Definition

object DefinitionsListDiffCallback : DiffUtil.ItemCallback<Definition>() {

    override fun areItemsTheSame(oldItem: Definition, newItem: Definition): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Definition, newItem: Definition): Boolean {
        return oldItem == newItem
    }
}