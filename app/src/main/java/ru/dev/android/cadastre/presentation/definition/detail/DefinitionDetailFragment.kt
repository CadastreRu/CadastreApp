package ru.dev.android.cadastre.presentation.definition.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.dev.android.cadastre.databinding.FragmentDefinitionDetailBinding

class DefinitionDetailFragment : Fragment() {

    private var _binding: FragmentDefinitionDetailBinding? = null
    private val binding: FragmentDefinitionDetailBinding
        get() = _binding ?: throw RuntimeException("FragmentDefinitionDetailBinding is null")

    private val viewModel: DefinitionDetailViewModel by lazy {
        ViewModelProvider(this)[DefinitionDetailViewModel::class.java]
    }

    private lateinit var definitionId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArgs()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDefinitionDetailBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.getDefinition(definitionId)
        viewModel.definition.observe(viewLifecycleOwner) {
            binding.definitionTitle.text = it.title
            binding.definitionText.text = it.text
        }
    }

    private fun parseArgs() {
        val defId = requireArguments().getString(ARGS_DEFINITION_ID)
        definitionId = defId ?: throw RuntimeException("Definition id not found")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        private const val ARGS_DEFINITION_ID = "definition_id"

        fun newInstance(defId: String): DefinitionDetailFragment {
            return DefinitionDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARGS_DEFINITION_ID, defId)
                }
            }
        }
    }
}