package com.vk.mathaplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.date_fragment.*
import kotlinx.android.synthetic.main.trivia_fragment.*
import kotlinx.android.synthetic.main.year_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.random.Random

class FragmentTrivia : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        return inflater.inflate(R.layout.trivia_fragment, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        okButtonTrivia.setOnClickListener {
            val year = EditTextTrivia.text.toString()
            remoteService.getYearFact(year.toInt()).enqueue(object : Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    triviaoutputtextView.text = response.body()
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    triviaoutputtextView.text = "Server error bye"
                    Log.d("mylog",t.message)
                }

            })

        }
        clearButtonTrivia.setOnClickListener {
            EditTextTrivia.text.clear()
        }
        randomTriviaButton.setOnClickListener {
            val randomYear = Random.nextInt(0,2021)
            EditTextTrivia.setText(randomYear.toString())
        }

    }
}
