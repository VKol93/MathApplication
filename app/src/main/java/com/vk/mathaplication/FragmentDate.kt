package com.vk.mathaplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.date_fragment.*
import kotlinx.android.synthetic.main.math_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.random.Random

class FragmentDate : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        return inflater.inflate(R.layout.date_fragment, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        okButtonDate.setOnClickListener {
            val date = editTextDate.text.toString()
            val month = editTextMonth.text.toString()
            remoteService.getDateFact(month.toInt(), date.toInt()).enqueue(object : Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    dateOutPuttextView.text = response.body()
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    dateOutPuttextView.text = "Server error bye"
                    Log.d("mylog",t.message)
                }

            })

        }
        clearButtonDate.setOnClickListener {
            editTextDate.text.clear()
            editTextMonth.text.clear()
        }

        randomDateButton.setOnClickListener {

            val randomMonth = Random.nextInt(1,13)
            editTextMonth.setText(randomMonth.toString())
            val randomDate = getRandomDate(randomMonth)
            editTextDate.setText(randomDate.toString())
        }

    }
    fun getRandomDate (month:Int): Int{
        return Random.nextInt(1,29)
        // needs fix
    }
}

