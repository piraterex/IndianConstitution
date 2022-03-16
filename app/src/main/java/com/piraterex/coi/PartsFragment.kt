package com.piraterex.coi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.piraterex.coi.databinding.FragmentPartsBinding

/**
 * A simple [Fragment] subclass as the Parts destination in the navigation.
 */
class PartsFragment : Fragment() {

    private var _binding: FragmentPartsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentPartsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*binding.buttonHome.setOnClickListener {
            findNavController().navigate(R.id.action_PartsFragment_to_HomeFragment)
        }
         */
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}