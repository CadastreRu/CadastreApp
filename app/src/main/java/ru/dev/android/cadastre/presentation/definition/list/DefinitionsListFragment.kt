package ru.dev.android.cadastre.presentation.definition.list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.dev.android.cadastre.CadastreApp
import ru.dev.android.cadastre.R
import ru.dev.android.cadastre.databinding.FragmentDefinitionsListBinding
import ru.dev.android.cadastre.presentation.ViewModelFactory
import ru.dev.android.cadastre.presentation.definition.detail.DefinitionDetailFragment
import ru.dev.android.cadastre.presentation.definition.list.adapter.DefinitionsListAdapter
import javax.inject.Inject

class DefinitionsListFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy {
        (requireActivity().application as CadastreApp).component
    }

    private var _binding: FragmentDefinitionsListBinding? = null
    private val binding: FragmentDefinitionsListBinding
        get() = _binding ?: throw RuntimeException("FragmentDefinitionsListBinding is null")

    private val viewModel: DefinitionsListViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[DefinitionsListViewModel::class.java]
    }

    private lateinit var adapter: DefinitionsListAdapter

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDefinitionsListBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        observeViewModel()
    }

    private fun setupRecyclerView() {
        adapter = DefinitionsListAdapter()
        binding.rvDefinitionsList.adapter = adapter
        adapter.onDefinitionClickListener = {
            requireActivity().supportFragmentManager.popBackStack()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, DefinitionDetailFragment.newInstance(it.id))
                .addToBackStack(null)
                .commit()
        }
    }

    private fun observeViewModel() {
        viewModel.definitionsList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}