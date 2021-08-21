package com.example.adventuredemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.bumptech.glide.Glide
import com.example.adventuredemo.databinding.FragmentBannerBinding

class BannerFragment : Fragment() {
    private lateinit var binding: FragmentBannerBinding
    companion object {
        private const val ARG_POSITION = "ARG_POSITION"

        fun getInstance(position: Int) = BannerFragment().apply {
            arguments = bundleOf(ARG_POSITION to position)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBannerBinding.inflate(inflater, container, false)

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val position = requireArguments().getInt(ARG_POSITION)
        //get image from viewmodel main ac
        val imageUrl = "https://locate.apple.com/resources/images/widgets/AppleAuthorizedResellers_long.png"
        Glide.with(requireContext()).load(imageUrl).into(binding.image)
    }
}