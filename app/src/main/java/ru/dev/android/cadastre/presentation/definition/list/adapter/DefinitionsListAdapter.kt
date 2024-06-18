package ru.dev.android.cadastre.presentation.definition.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.dev.android.cadastre.databinding.ItemDefinitionBinding
import ru.dev.android.cadastre.domain.definitions.entity.Definition

class DefinitionsListAdapter :
    ListAdapter<Definition, DefinitionsViewHolder>(DefinitionsListDiffCallback) {

    var onDefinitionClickListener: ((Definition) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DefinitionsViewHolder {
        val binding = ItemDefinitionBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return DefinitionsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DefinitionsViewHolder, position: Int) {
        val definition = getItem(position)
        holder.binding.definitionTitle.text = definition.title
        holder.binding.root.setOnClickListener {
            onDefinitionClickListener?.invoke(definition)
        }
    }
}