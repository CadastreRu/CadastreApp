package ru.dev.android.cadastre.presentation.news.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.dev.android.cadastre.R
import ru.dev.android.cadastre.databinding.FragmentNewsListBinding
import ru.dev.android.cadastre.presentation.news.detail.NewsDetailFragment
import ru.dev.android.cadastre.presentation.news.list.adapter.NewsListAdapter

class NewsListFragment : Fragment() {

    private var _binding: FragmentNewsListBinding? = null
    private val binding: FragmentNewsListBinding
        get() = _binding ?: throw RuntimeException("FragmentShopListBinding is null")

    private val viewModel: NewsListViewModel by lazy {
        ViewModelProvider(this)[NewsListViewModel::class.java]
    }

    private lateinit var adapter: NewsListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.newsList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        viewModel.newsLoadProgress.observe(viewLifecycleOwner) {
            changeVisibleLoadProgress(it)
        }
    }

    private fun setupRecyclerView() {
        adapter = NewsListAdapter(requireContext())
        binding.rvNewsList.adapter = adapter
        setupClickListener()
    }

    private fun setupClickListener() {
        adapter.onNewsItemClickListener = {
            requireActivity().supportFragmentManager.popBackStack()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, NewsDetailFragment.newInstance(it.id))
                .addToBackStack(null)
                .commit()
        }
    }

    private fun changeVisibleLoadProgress(isLoad: Boolean) {
        if (isLoad) {
            binding.loadProgress.visibility = View.VISIBLE
        } else {
            binding.loadProgress.visibility = View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}