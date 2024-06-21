package com.example.class1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.class1.database.Item
import com.example.class1.database.ItemDao
import com.example.class1.database.ItemRoomDatabase
import com.example.class1.databinding.ActivityHomeBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {
    var TAG = HomeActivity::class.java.simpleName    //"HomeActivity"
    private lateinit var binding: ActivityHomeBinding
    lateinit var dao: ItemDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var  database = ItemRoomDatabase.getDatabase(this)
        dao = database.itemDao()

        binding.btnDbInsert.setOnClickListener{
            insertDataDb()
        }
    }

    private fun insertDataDb() {
        GlobalScope.launch {
            var item = Item(21,"fruits",11.11,11)
            dao.insert(item)
        }
    }


}