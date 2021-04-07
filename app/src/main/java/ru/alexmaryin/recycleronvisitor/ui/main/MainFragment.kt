package ru.alexmaryin.recycleronvisitor.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.alexmaryin.recycleronvisitor.R
import ru.alexmaryin.recycleronvisitor.data.HasStringId
import ru.alexmaryin.recycleronvisitor.data.ui_models.RecyclerHeader
import ru.alexmaryin.recycleronvisitor.ui.adapter.AdapterClickListenerById
import ru.alexmaryin.recycleronvisitor.ui.adapter.BaseListAdapter
import ru.alexmaryin.recycleronvisitor.ui.adapter.ViewHoldersManager
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var recycler: RecyclerView
    @Inject lateinit var viewHoldersManager: ViewHoldersManager

    private val items = mutableListOf<HasStringId>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        requireActivity().findViewById<FloatingActionButton>(R.id.shuffleButton)
            .setOnClickListener { shuffle() }

        recycler = requireActivity().findViewById(R.id.recycller)
        val itemsAdapter = BaseListAdapter(AdapterClickListenerById {}, viewHoldersManager)
        itemsAdapter.submitList(items)
        recycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(DividerItemDecoration(requireContext(), (layoutManager as LinearLayoutManager).orientation))
            adapter = itemsAdapter
        }
        populateRecycler()
    }

    private fun populateRecycler() {
        lifecycleScope.launch {
            viewModel.getItems().flowWithLifecycle(lifecycle, Lifecycle.State.RESUMED)
                .collect { items.add(it) }
        }
    }

    private fun shuffle() {
        (recycler.adapter as BaseListAdapter).submitList(items.apply {
            removeAll { it is RecyclerHeader }
            shuffle()
        })
        recycler.scrollToPosition(0)
    }
}