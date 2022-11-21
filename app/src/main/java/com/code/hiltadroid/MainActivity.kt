package com.code.hiltadroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.code.hiltadroid.db.UserEntity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        save.setOnClickListener {
            val user = UserEntity(name = name_et.text.toString().trim())
            viewModel.insertRecord(user)
            name_et.setText("")
        }
        viewModel.getRecordObserver().observe(this) { t ->
            name_tv.text = ""
            t?.forEach {
                name_tv.append("${it.name} \n")
            }
        }
    }
}