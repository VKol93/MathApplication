package com.vk.mathaplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.math_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.random.Random

class FragmentMath : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        return inflater.inflate(R.layout.math_fragment, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        okButtonMath.setOnClickListener {
            val math = editTextMathNumber.text.toString()
            remoteService.getMathFact(math.toInt()).enqueue(object : Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    mathOutputTextView.text = response.body()
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    mathOutputTextView.text = "Server error"
                    Log.d("mylog",t.message)
                }

            })

        }
        clearButtonMath.setOnClickListener {
            editTextMathNumber.text.clear()
        }
        randomMathButton.setOnClickListener {
            val randomMath = Random.nextInt()
            editTextMathNumber.setText(randomMath.toString())
        }

    }
}
