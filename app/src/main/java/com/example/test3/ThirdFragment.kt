package com.example.test3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.test3.databinding.FragmentThirdBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class ThirdFragment:Fragment(), OnMapReadyCallback{


    private var _binding: FragmentThirdBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var gMap:GoogleMap

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mapFragment = childFragmentManager.findFragmentById(R.id.id_map) as? SupportMapFragment
        mapFragment?.getMapAsync(this)
    }


    override fun onMapReady(googleMap: GoogleMap) {
        val location = LatLng(25.0355068, 121.5176029)
        googleMap.addMarker(MarkerOptions().position(location).title("中正紀念堂"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 14f)) // Adjust the zoom level as needed
    }
}