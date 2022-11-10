package com.intermedia.challenge.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.intermedia.challenge.core.isOnline
import com.intermedia.challenge.core.showToast
import com.intermedia.challenge.R
import com.intermedia.challenge.data.model.EventResult
import com.intermedia.challenge.databinding.FragmentEventsBinding
import com.intermedia.challenge.ui.adapters.EventsAdapter
import com.intermedia.challenge.ui.viewmodel.EventsFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EventsFragment : Fragment() {
    private var eventsList : List<EventResult> = emptyList()
    private lateinit var binding : FragmentEventsBinding
    private lateinit var viewModel : EventsFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentEventsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[EventsFragmentViewModel::class.java]

        setObservers()
        getEvents()
    }

    private fun setObservers() {
        viewModel.mldEvents.observe(viewLifecycleOwner) {
            if (!it.isNullOrEmpty()) {
                hideProgressBar()
                eventsList = it
                setRecyclerView()
            } else {
                requireActivity().showToast(resources.getString(R.string.server_error))
            }
        }
    }

    private fun getEvents() {
        if (requireActivity().isOnline()) {
            showProgressBar()
            viewModel.getEvents()
        } else {
            requireActivity().showToast(resources.getString(R.string.no_connection))
        }
    }

    private fun setRecyclerView() {
        val eventsAdapter = EventsAdapter(requireContext(), eventsList)
        binding.recyclerEvents.layoutManager = LinearLayoutManager(
            requireContext(), LinearLayoutManager.VERTICAL, false
        )
        binding.recyclerEvents.adapter = eventsAdapter
    }

    private fun showProgressBar() {
        binding.imgCircleProgress.visibility = View.VISIBLE
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        binding.imgCircleProgress.visibility = View.GONE
        binding.progressBar.visibility = View.GONE
    }

}