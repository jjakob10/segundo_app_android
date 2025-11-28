package com.example.segundo_app.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.segundo_app.R

//
class CatFragment : Fragment(R.layout.fragment_cat) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val curiosity = requireArguments().getInt("CURIOSITY_STR")

    }
}