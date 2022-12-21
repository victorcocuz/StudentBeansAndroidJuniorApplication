package com.example.studentbeansandroidjuniorapplication.fragments.photos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.studentbeansandroidjuniorapplication.R
import com.example.studentbeansandroidjuniorapplication.databinding.FragmentPhotosBinding
import com.example.studentbeansandroidjuniorapplication.utils.ViewModelFactory

class PhotosFragment : Fragment() {
    private lateinit var photosVm: PhotosViewModel
    private var _binding: FragmentPhotosBinding? = null
    private val binding: FragmentPhotosBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        photosVm = ViewModelProvider(this, ViewModelFactory(this, null))[PhotosViewModel::class.java]

        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_photos, container, false)
        _binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            varPhotosVm = this@PhotosFragment.photosVm
            fPhotosRecyclerView.adapter = PhotoAdapter()
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}