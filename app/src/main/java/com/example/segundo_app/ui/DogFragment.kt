package com.example.segundo_app.ui


import android.os.Bundle
import androidx.fragment.app.Fragment

import com.example.segundo_app.R

class DogFragment : Fragment(R.layout.fragment_dog) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val curiosity = requireArguments().getInt("CURIOSITY_STR")

    }
}