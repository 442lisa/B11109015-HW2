package com.example.test3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.test3.R
import com.example.test3.databinding.FragmentMapBinding
import com.example.test3.viewmodel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class ThirdFragment : Fragment(), OnMapReadyCallback {

    private val sharedViewModel: viewmodel by viewModels()

    private var _binding: FragmentMapBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMapBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mapFragment =
            childFragmentManager.findFragmentById(R.id.id_map) as? SupportMapFragment
        mapFragment?.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        googleMap.setOnMapLoadedCallback {
            // Get the location from the sharedViewModel
            val location = sharedViewModel.locationLiveData.value

            println(location)

            // Update the map with the new location
            googleMap.clear()
            googleMap.addMarker(MarkerOptions().position(LatLng(25.035625072789692, 121.52026754823773)).title("中正紀念堂"))
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(25.035625072789692, 121.52026754823773), 14f))

            // Check if location is not null
            location?.let {


                // Update the map with the new location
                googleMap.clear()
                googleMap.addMarker(MarkerOptions().position(location).title("中正紀念堂"))
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 14f))
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
