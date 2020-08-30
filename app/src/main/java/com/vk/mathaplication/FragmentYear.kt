package com.vk.mathaplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.data_fragment.okButton
import kotlinx.android.synthetic.main.data_fragment.yearEditText
import kotlinx.android.synthetic.main.year_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FragmentYear : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        return inflater.inflate(R.layout.year_fragment, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        okButton.setOnClickListener {
            val year = yearEditText.text.toString()
            remoteService.getYearFact(year.toInt()).enqueue(object : Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    yearoutputtextView.text = response.body()
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    yearoutputtextView.text = "Server error bye"
                    Log.d("mylog",t.message)
                }

            })

        }
        clearButton.setOnClickListener {
            yearEditText.text.clear()
        }


    }


}

