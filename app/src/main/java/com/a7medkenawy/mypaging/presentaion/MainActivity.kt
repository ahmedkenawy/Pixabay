package com.a7medkenawy.mypaging.presentaion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.a7medkenawy.mypaging.R
import com.a7medkenawy.mypaging.databinding.ActivityMainBinding
import com.a7medkenawy.mypaging.presentaion.adapter.ImagesAdapter
import com.a7medkenawy.mypaging.presentaion.viewmodel.ImageViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var imagesAdapter: ImagesAdapter

    lateinit var imageViewModel: ImageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        imageViewModel = ViewModelProvider(this)[ImageViewModel::class.java]

        lifecycleScope.launch {
            imageViewModel.photoList.collect {
                imagesAdapter.submitData(it)
            }
        }

        binding.imageRecyclerView.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            setHasFixedSize(true)
            adapter = imagesAdapter
        }

    }
}