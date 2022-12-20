package com.example.studentbeansandroidjuniorapplication.fragments.photos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.studentbeansandroidjuniorapplication.R
import com.example.studentbeansandroidjuniorapplication.databinding.FragmentLoginBinding
import com.example.studentbeansandroidjuniorapplication.databinding.FragmentPhotosBinding
import timber.log.Timber

class PhotosFragment : Fragment() {
    private val photosVm: PhotosViewModel by viewModels()
    private var _binding: FragmentPhotosBinding? = null
    private val binding: FragmentPhotosBinding = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_photos, container, false)
        _binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            varPhotosVm = this@PhotosFragment.photosVm
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}