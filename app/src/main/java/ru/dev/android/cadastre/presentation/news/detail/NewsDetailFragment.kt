package ru.dev.android.cadastre.presentation.news.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import ru.dev.android.cadastre.databinding.FragmentNewsDetailBinding

class NewsDetailFragment : Fragment() {

    private lateinit var newsId: String

    private var _binding: FragmentNewsDetailBinding? = null
    private val binding: FragmentNewsDetailBinding
        get() = _binding ?: throw RuntimeException("FragmentNewsDetailBinding is null")

    private val viewModel: NewsDetailViewModel by lazy {
        ViewModelProvider(this)[NewsDetailViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parsArgs()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsDetailBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getNewsDetail(newsId)
        viewModel.newsDetail.observe(viewLifecycleOwner) {
            with(binding) {
                Glide
                    .with(requireContext())
                    .load(it.thumbnail)
                    .into(newsImage)
                newsTitle.text = it.title
                newsText.text = it.text
            }
        }
    }

    private fun parsArgs() {
        val id = requireArguments().getString(ARGS_NEWS_ID)
        newsId = id ?: throw RuntimeException("News id not found")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        private const val ARGS_NEWS_ID = "news_id"

        fun newInstance(newsId: String): NewsDetailFragment {
            return NewsDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARGS_NEWS_ID, newsId)
                }
            }
        }
    }
}