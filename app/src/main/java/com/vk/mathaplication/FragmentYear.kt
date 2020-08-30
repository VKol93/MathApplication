package com.vk.mathaplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.data_fragment.*
import kotlinx.android.synthetic.main.data_fragment.okButton
import kotlinx.android.synthetic.main.data_fragment.yearEditText
import kotlinx.android.synthetic.main.year_fragment.*

class FragmentYear : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        return inflater.inflate(R.layout.year_fragment, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        okButton.setOnClickListener {
            val year = yearEditText.text.toString()
        }
        clearButton.setOnClickListener {
            yearEditText.text.clear()
        }

    }


}

