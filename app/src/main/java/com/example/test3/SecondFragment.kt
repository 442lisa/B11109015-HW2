package com.example.test3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.test3.databinding.FragmentIntroductionBinding
import com.google.android.gms.maps.model.LatLng

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

private var _binding: FragmentIntroductionBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    val sharedViewModel: viewmodel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

      _binding = FragmentIntroductionBinding.inflate(inflater, container, false)
      return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button2.setOnClickListener {
            sharedViewModel.updateLocation( LatLng(25.035625072789692, 121.52026754823773))
            findNavController().navigate(R.id.action_SecondFragment_to_thirdFragment)
        }
    }
override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}