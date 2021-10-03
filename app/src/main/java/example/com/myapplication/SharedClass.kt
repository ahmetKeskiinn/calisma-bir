package example.com.myapplication

import android.content.Context
import android.content.SharedPreferences

class SharedClass {
    private val sharedPrefFile = "sharedPrefExample"
    private lateinit var context: Context
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor:SharedPreferences.Editor

    private var SOME_KEY_STRING:String = ""
    private val SOME_KEY_INT : Int =0

    fun instancePref(context: Context){
        sharedPreferences =  context.getSharedPreferences(sharedPrefFile,Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
    }

    fun addString(key:String){
        editor.putString(SOME_KEY_STRING,key)
        editor.apply()
        editor.commit()
    }
    fun addInt(key:Int){
        editor.putInt(SOME_KEY_INT.toString(),key)
        editor.apply()
        editor.commit()

    }

    fun getString(): String? {
        val sharedValue = sharedPreferences.getString(SOME_KEY_STRING,"")
        return sharedValue
    }
    fun getInt() : Int{
        val sharedValue = sharedPreferences.getInt(SOME_KEY_INT.toString(),0)
        return sharedValue
    }


}