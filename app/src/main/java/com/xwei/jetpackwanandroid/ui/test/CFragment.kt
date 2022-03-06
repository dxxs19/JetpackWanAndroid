package com.xwei.jetpackwanandroid.ui.test

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.xwei.jetpackwanandroid.R
import kotlinx.android.synthetic.main.fragment_c.*

class CFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_c, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_c.text = "${arguments?.getString("BB")} ${arguments?.getString("CC")}"
        tv_c.setOnClickListener { v ->
            Navigation.findNavController(v).navigate(R.id.action_CFragment_to_AFragment)
        }
    }
}