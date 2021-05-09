package com.example.esiea3a.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.esiea3a.R
import com.example.esiea3a.presentation.Singleton
import com.example.esiea3a.presentation.api.WeatherResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class WeatherListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val adapter= WeatherAdapter(listOf(), :: onClickedCity)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weather_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        recyclerView=view.findViewById(R.id.weather_recyclerview)
        adapter.listener
        recyclerView.apply {
            layoutManager=LinearLayoutManager(context)
            adapter=this@WeatherListFragment.adapter
        }
        //val weatherList: ArrayList<City> = arrayListOf<City>().apply {
          //  add(City("Paris"))
            //add(City("London"))
            //add(City("Mumbai"))
        //}

        //adapter.updateList(weatherList)


        Singleton.WeatherApi.getWeatherList().enqueue(object: Callback<WeatherResponse> {
            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(
                call: Call<WeatherResponse>,
                response: Response<WeatherResponse>
            ) {
                if(response.isSuccessful && response.body() !=null){
                    val weatherResponse : WeatherResponse =response.body()!!
                    adapter.updateList(weatherResponse.data)
                }

            }
            
        })

    }
    private fun onClickedCity(city: City) {
        findNavController().navigate(R.id.navigatetoWeatherDetail)
    }
}