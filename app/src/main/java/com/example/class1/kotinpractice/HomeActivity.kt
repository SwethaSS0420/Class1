package com.example.class1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.class1.database.Item
import com.example.class1.database.ItemDao
import com.example.class1.database.ItemRoomDatabase
import com.example.class1.databinding.ActivityHomeBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import com.example.class1.database.HomeViewModel

class HomeActivity : AppCompatActivity() {
    var TAG = HomeActivity::class.java.simpleName    //"HomeActivity"
    private lateinit var binding: ActivityHomeBinding
    lateinit var dao: ItemDao
    lateinit var viewModel: HomeViewModel
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var  database = ItemRoomDatabase.getDatabase(this)
        dao = database.itemDao()
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        binding.tvHome.setText(""+count)
        binding.btnDbInsert.setOnClickListener{
            insertDataDb()
        }
        binding.btnFind.setOnClickListener{
            findItemDb(21)
        }
        binding.btnInc.setOnClickListener{
            count++
            //viewModel.incrementCount()
            binding.tvHome.setText(""+count)
            //+viewModel.count)
        }
    }

    fun add(a:Int,b:Int):Int{
        return a+b
    }

    private fun findItemDb(id: Int) {
        GlobalScope.launch(Dispatchers.Main) {
            var item = dao.getItem(id).first()
            binding.tvHome.setText(item.itemName)
        }
    }

    private fun insertDataDb() {
        GlobalScope.launch {
            var item = Item(21,"fruits",11.11,11)
            dao.insert(item)
        }
    }

}