package com.example.mypost

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mypost.databinding.PostListItemsBinding

class PostRvAdapter(var context: Context,var postList: List<Post>):
RecyclerView.Adapter<PostRvAdapter.PostsViewHolder>(){

    class PostsViewHolder(var binding: PostListItemsBinding):
            RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
      var binding=PostListItemsBinding.inflate(LayoutInflater.from(context),parent,false)
        return PostsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        var postDisplay=postList.get(position)
        with(holder.binding){
            tvUserId.text=postDisplay.userId.toString()
            tvId.text=postDisplay.Id.toString()
            tvBody.text=postDisplay.body
            tvTitle.text=postDisplay.title
        }
    }

    override fun getItemCount(): Int {
        return postList.size
    }
}