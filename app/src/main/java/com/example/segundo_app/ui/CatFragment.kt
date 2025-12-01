package com.example.segundo_app.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.segundo_app.R
import com.example.segundo_app.databinding.FragmentCatBinding

//
class CatFragment : Fragment(R.layout.fragment_cat) {

    private var _binding: FragmentCatBinding? = null
    private val binding get() = _binding!!
    var curiosity = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        curiosity = requireArguments().getString("CURIOSITY_STR")!!

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        super.onCreateView(inflater, container, savedInstanceState)

        _binding = FragmentCatBinding.inflate(inflater, container, false)
        binding.TextCuriosidade.text = curiosity
        return binding.root
//        val fragView = inflater.inflate(R.layout.fragment_cat, container, false)
//        return fragView

    }
}