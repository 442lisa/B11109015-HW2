package com.example.test3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.test3.databinding.FragmentIntroduction1Binding
import com.example.test3.databinding.FragmentiIntrodution2Binding
import com.google.android.gms.maps.model.LatLng

class Introduction2Fragment:Fragment()
{
    private var _binding: FragmentiIntrodution2Binding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    val sharedViewModel: viewmodel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentiIntrodution2Binding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button2.setOnClickListener {
            // 25.194251,121.5583614

            sharedViewModel.updateLocation( LatLng(25.194343259677744, 121.56089338078797))
            findNavController().navigate(R.id.action_introduction2Fragment_to_thirdFragment)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}