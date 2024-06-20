package com.example.class1
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.class1.network.PhotoAdapter
import com.example.class1.network.RetrofitInstance
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class HomeActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var photoAdapter: PhotoAdapter
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        progressBar = findViewById(R.id.progress_bar)

        recyclerView.layoutManager = LinearLayoutManager(this)
        photoAdapter = PhotoAdapter(this, listOf())
        recyclerView.adapter = photoAdapter

        fetchPhotos()
    }

    private fun fetchPhotos() {
        progressBar.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE

        lifecycleScope.launch {
            try {
                val photos = RetrofitInstance.api.getPhotos()
                photoAdapter.updatePhotos(photos)
                progressBar.visibility = View.GONE
                recyclerView.visibility = View.VISIBLE
            } catch (e: IOException) {
                progressBar.visibility = View.GONE
                Toast.makeText(this@HomeActivity, "Network error: ${e.message}", Toast.LENGTH_SHORT).show()
            } catch (e: HttpException) {
                progressBar.visibility = View.GONE
                Toast.makeText(this@HomeActivity, "Server error: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

