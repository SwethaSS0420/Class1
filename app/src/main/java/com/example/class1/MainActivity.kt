package com.example.class1
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // var myEmp = Employee("abdul")
    }

    fun clickHandler(view: View) {
        Log.i("MainActivity-clickhandler","button clicked")
        var hIntent:Intent = Intent(this,HomeActivity::class.java)
        hIntent.putExtra("mykey","android-vit-abdul")
        startActivity(hIntent)
    }
}