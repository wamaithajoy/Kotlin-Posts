package com.example.mypost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mypost.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fetchPosts()
    }
    fun fetchPosts(){
        val apiClient = APIClient.buildApiClient(APIInterface::class.java)
        var request= apiClient.getPost()
        request.enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
             if (response.isSuccessful){
                 var posts=response.body()
                 Toast.makeText(baseContext,"fetched ${posts!!.size} posts", Toast.LENGTH_LONG)
                     .show()
                 var displayPost=PostRvAdapter(posts)
                 binding.rvPosts.layoutManager=LinearLayoutManager(baseContext)
                 binding.rvPosts.adapter=displayPost
             }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {

            }

        })
    }
}
