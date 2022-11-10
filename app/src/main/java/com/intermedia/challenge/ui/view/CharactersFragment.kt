package com.intermedia.challenge.ui.view

import android.content.Intent
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
import com.intermedia.challenge.data.model.Result
import com.intermedia.challenge.databinding.FragmentCharactersBinding
import com.intermedia.challenge.ui.adapters.CharactersAdapter
import com.intermedia.challenge.ui.interfaces.CharactersInterface
import com.intermedia.challenge.ui.viewmodel.CharactersFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharactersFragment : Fragment(), CharactersInterface {

    private var charactersList : List<Result> = emptyList()

    private lateinit var binding : FragmentCharactersBinding
    private lateinit var viewModel : CharactersFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharactersBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[CharactersFragmentViewModel::class.java]

        setObservers()
        getCharacters()
    }

    private fun setObservers() {
        viewModel.mldCharacters.observe(viewLifecycleOwner) {
            if (!it.isNullOrEmpty()) {
                hideProgressBar()
                charactersList = it
                setRecyclerView()
            } else {
                requireActivity().showToast(resources.getString(R.string.server_error))
            }
        }
    }

    private fun getCharacters() {
        if (requireActivity().isOnline()) {
            showProgressBar()
            viewModel.getCharacters()
        } else {
            requireActivity().showToast(resources.getString(R.string.no_connection))
        }
    }

    private fun setRecyclerView() {
        val charactersAdapter = CharactersAdapter(requireContext(), this, charactersList)
        binding.recyclerCharacters.layoutManager = LinearLayoutManager(
            requireContext(), LinearLayoutManager.VERTICAL, false
        )
        binding.recyclerCharacters.adapter = charactersAdapter
    }

    private fun showProgressBar() {
        binding.imgCircleProgress.visibility = View.VISIBLE
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        binding.imgCircleProgress.visibility = View.GONE
        binding.progressBar.visibility = View.GONE
    }

    override fun onCharacterClicked(character: Result) {
        val intent = Intent (activity, CharacterDetailsActivity::class.java)
        intent.putExtra("character", character)

        activity?.startActivity(intent)
    }
}