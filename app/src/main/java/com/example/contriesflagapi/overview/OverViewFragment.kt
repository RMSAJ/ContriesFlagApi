package com.example.contriesflagapi.overview

import PhotoGridAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.contriesflagapi.databinding.FragmentOverViewBinding
import com.example.contriesflagapi.databinding.GridViewItemBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [OverViewFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OverViewFragment : Fragment() {

    private val viewModel: OverViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentOverViewBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel
//        binding.photosGrid.adapter = PhotoGridAdapter()
        return binding.root
    }
}


