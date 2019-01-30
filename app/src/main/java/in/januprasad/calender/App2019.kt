package `in`.januprasad.calender

import android.app.Application
import android.preference.PreferenceManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

import java.util.ArrayList

class App2019 : Application() {


    override fun onCreate() {
        super.onCreate()
    }


    fun set(json: ArrayList<Photo>) {
        PreferenceManager.getDefaultSharedPreferences(this).edit().putString("JSON", Gson().toJson(json)).apply()
    }

    fun get(): ArrayList<Photo> {
        val json = PreferenceManager.getDefaultSharedPreferences(this).getString("JSON", "[]")
        return Gson().fromJson(json, object : TypeToken<ArrayList<Photo>>() {

        }.type)
    }

}
