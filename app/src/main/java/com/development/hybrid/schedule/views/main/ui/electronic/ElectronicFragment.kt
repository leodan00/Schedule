package com.development.hybrid.schedule.views.main.ui.electronic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.development.hybrid.schedule.databinding.FragmentElectronicBinding

class ElectronicFragment : Fragment() {

    private lateinit var electronicViewModel: ElectronicViewModel
    private var _binding: FragmentElectronicBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        electronicViewModel =
            ViewModelProvider(this).get(ElectronicViewModel::class.java)

        _binding = FragmentElectronicBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textGallery
        electronicViewModel.text.observe(viewLifecycleOwner, {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}