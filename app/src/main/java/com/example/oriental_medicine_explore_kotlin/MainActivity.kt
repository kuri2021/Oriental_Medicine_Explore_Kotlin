package com.example.oriental_medicine_explore_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.oriental_medicine_explore_kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.viewModel = viewModel

        val mAdapter = RecyclerViewAdapter(this, viewModel)
        recyclerview.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(applicationContext)
        }

        viewModel.allUsers.observe(this, Observer { users ->
            // Update the cached copy of the users in the adapter.
            users?.let { mAdapter.setUsers(it) }
        })
        // 버튼 클릭시 edit에 적혀있는 텍스트를 db에 저장
        button.setOnClickListener{
            lifecycleScope.launch(Dispatchers.IO) {
                viewModel.insert(
                    Entity(
                        0, edit.text.toString())
                )
            }

        }

    }
}