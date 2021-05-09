package com.example.esiea3a

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.esiea3a.presentation.Singleton
import com.example.esiea3a.presentation.api.CovidDetailResponse
import com.example.esiea3a.presentation.list.WeatherAdapter
import retrofit2.Call
import retrofit2.Response


class CovidDetailFragment : Fragment() {
    private val adapter= WeatherAdapter(listOf())

    private lateinit var textViewValue: TextView
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_covid_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textViewValue=view.findViewById(R.id.covid_detail_value)
        callCovidAPi()

    }

    private fun callCovidAPi() {
        Singleton.WeatherApi.getCovidDetail().enqueue(object: retrofit2.Callback<CovidDetailResponse> {
            override fun onResponse(
                call: Call<CovidDetailResponse>,
                response: Response<CovidDetailResponse>
            ) {
                if(response.isSuccessful && response.body() !=null)  {
                    textViewValue.text= response.body()!!.status.timestamp



                }
            }

            override fun onFailure(call: Call<CovidDetailResponse>, t: Throwable) {

            }

        })
    }
}
