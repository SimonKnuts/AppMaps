package com.example.test2

import java.util.*
import kotlin.collections.ArrayList

class Persoon(naam:String, code:String) {
    val naam: String = naam
    val code: String = code
    var landenLijst: ArrayList<Land> = ArrayList()
    var behaaldeAchievements: ArrayList<Int> = ArrayList()
    var besteLand: Land = Land("",0,"",0,0,0)
    var slechtsteLand: Land = Land("",0,"",0,0,0)

    fun isBesteLand(nieuwLand:Land, voorlopigBesteLand: Land){
        val besteRating = voorlopigBesteLand.rating;
        val dezeRating = nieuwLand.rating;
        if(dezeRating > besteRating){
            besteLand = nieuwLand;
        }
    }

    fun isSlechtsteLand(nieuwLand:Land, voorlopigSlechtsteLand: Land){
        val slechtsteRating = voorlopigSlechtsteLand.rating;
        val dezeRating = nieuwLand.rating;
        if(dezeRating > slechtsteRating){
            slechtsteLand = nieuwLand;
        }
    }

    fun voegLandToe(nieuwLand:Land){
        landenLijst.add(nieuwLand);
    }

    fun aantalLandenBezocht():Int{
        return landenLijst.size;
    }

    fun aantalLandenBezochtIn1Jaar():Int{
        var lijstJaren: ArrayList<Int> = ArrayList()
        var maxInJaar: Int = 0;
        for (Land in landenLijst){
            lijstJaren.add(Land.jaar)
        }
        for (jaar in lijstJaren){
            if (Collections.frequency(lijstJaren, jaar) > maxInJaar){
                maxInJaar = Collections.frequency(lijstJaren, jaar)
            }
        }
        return maxInJaar
    }

    fun achievementCheck(){
        if (aantalLandenBezocht() >= 10){
            behaaldeAchievements.add(1);
        }
        if (aantalLandenBezocht() >= 5 /* && methode implementeren om te kijken of deze landen binnen europa liggen*/){
            behaaldeAchievements.add(2);
        }
        if (aantalLandenBezochtIn1Jaar() > 5){
            behaaldeAchievements.add(3)
        }
        if (besteLand.rating == 5){
            behaaldeAchievements.add(4)
        }
        if (slechtsteLand.rating == 0){
            behaaldeAchievements.add(5)
        }
        //if (//zelfde doen als max in een jaar maar eerst methode implementeren voor continent, dan dus lijst met continenten en kijken of freq van elk continent groter is dan 0){
            //behaaldeAchievements.add(6);
        //}
    }

}

