package com.example.mypost

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mypost.databinding.PostListItemsBinding

 class PostRvAdapter(var postList: List<Post>):
RecyclerView.Adapter<PostRvAdapter.PostsViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
      var binding=PostListItemsBinding.
      inflate(LayoutInflater.from(parent.context),parent,false)
        return PostsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        var postDisplay=postList.get(position)
        with(holder.binding){
            tvUserId.text=postDisplay.userId.toString()
            tvId.text=postDisplay.Id.toString()
            tvBody.text=postDisplay.body
            tvTitle.text=postDisplay.title

            val context=holder.itemView.context
            holder.binding.cvPosts.setOnClickListener {
                val intent=Intent(context,CommentActivity::class.java)
                intent.putExtra("POST_ID",postDisplay.Id)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    class PostsViewHolder (var binding: PostListItemsBinding) :
        RecyclerView.ViewHolder(binding.root){

    }
}