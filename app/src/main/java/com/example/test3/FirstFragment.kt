package com.example.test3

import android.os.Bundle
import android.text.Layout.Directions
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test3.databinding.Fragment11Binding
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment(), Adapter.OnClickListener {

    private var _binding: Fragment11Binding? = null
    private val binding get() = _binding!!

    val locations_names = arrayListOf("中正紀念堂","台北101","陽明山國家公園",)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

      _binding = Fragment11Binding.inflate(inflater, container, false)
      return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize the RecyclerView and set its layout manager
        binding.recyclerView.layoutManager = LinearLayoutManager(context)

        // Initialize the adapter and set it to the RecyclerView
        val adapter = Adapter(itemlist = locations_names, this@FirstFragment )
        binding.recyclerView.adapter = adapter
    }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(item: String) {
        if(item == locations_names[0])
        {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        else if(item == locations_names[1]){
            findNavController().navigate(R.id.action_FirstFragment_to_introduction1Fragment)
        }
        else if(item == locations_names[2])
        {
            findNavController().navigate(R.id.action_FirstFragment_to_introduction2Fragment)
        }
    }
}

