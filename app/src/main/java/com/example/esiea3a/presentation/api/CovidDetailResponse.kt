package com.example.esiea3a.presentation.api

import com.example.esiea3a.presentation.list.City


//data class CovidDetailResponse (
  //      val code: String ="toto",
    //    val  allLiveFranceData: List<Stats>
//)

//data class Stats(
  //      val code: String,
    //    val nom: String,
//  val date: String,
  //      val hospitalises: Int,
    //    val reanimation: Int,
      //  val nouvellesHospitalisations: Int,
       // val nouvellesReanimations: Int,
        //val deces: Int,
        //val gueris: Int,
        //val source: CovidSource,
        //val sourceType: String
//)

//data class CovidSource(
  //      val nom: String
//)

//data class CovidDetailResponse (
  //      val activeCases:String,
    //    val regionData: List<RegionDetail>,
      //  val region:String
        //)
//data class RegionDetail(
  //      val region: String,
   //     val newInfected:Int
//)

data class CovidDetailResponse(
        //val activeCases:Int,
        //val deaths:String,
        //val regionData:List<City>

        val status: Time

)





data class Time(
        val timestamp: String
)



