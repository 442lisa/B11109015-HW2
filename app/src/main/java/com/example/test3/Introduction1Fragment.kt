package com.example.test3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.test3.databinding.FragmentIntroduction1Binding
import com.example.test3.databinding.FragmentIntroductionBinding
import com.google.android.gms.maps.model.LatLng

class Introduction1Fragment:Fragment() {

    private var _binding: FragmentIntroduction1Binding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    val sharedViewModel: viewmodel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentIntroduction1Binding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button2.setOnClickListener {
            //25.033976,121.5645389
            sharedViewModel.updateLocation( LatLng(25.03371609032608, 121.56480550961984))
            findNavController().navigate(R.id.action_introduction1Fragment_to_thirdFragment)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}