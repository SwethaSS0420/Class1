package com.example.class1
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //inflate this xml
        setContentView(R.layout.activity_main)
        Log.i(TAG,"activity is getting created")

    }

    //activity is visible to the user to interact - click
    override fun onStart() {
        super.onStart()
        Log.e(TAG,"activity is started")
    }

    //sleep night -- incomming call ur activity goes into the background for sometime
    override fun onPause() {
        super.onPause()
        Log.w(TAG,"activity has paused")

    }

    // activity no longer exists in the ram -- pushed to hdd[hibernate]
    override fun onStop() {
        super.onStop()
        Log.d(TAG,"activity is stopped")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(TAG,"activity is destroyed")
    }

    fun Createlog(view: View) {
        Log.i("MainActivity-clickMethod","button clicked")
        var c = 10 + 20
        add(10,20)
    }
    private fun add(i: Int, i1: Int):Int {
        var c = 20
        var d = 20 * i
        mul(5,4)
        return i +i1

    }

    private fun mul(i: Int, i1: Int) {
        val d = i * i1
        div(6,3)

    }

    private fun div(i: Int, i1: Int) {
        add(10,20)
    }

}