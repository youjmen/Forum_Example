package com.example.forum

import android.content.Context
import android.content.Intent
import android.system.Os.bind
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import org.jetbrains.anko.startActivity


import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.posts_item.view.*

class PostsInfoAdapter(val context: Context, val items :List<PostsInfo>): RecyclerView.Adapter<PostsInfoAdapter.ViewHolder>() {

   inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var view: View = v
        fun bind(item: PostsInfo) {
            view.postsTitle.text = item.postsTitle
            view.postsView.text = item.postsView.toString()
            view.authorsName.text = item.authorsName
            view.writtenDate.text = item.writtenDate
            view.recommendCount.text = item.recommendCount.toString()


        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflatedView = LayoutInflater.from(context)
            .inflate(R.layout.posts_item, parent, false)
        return ViewHolder(inflatedView)

    }

    override fun getItemCount(): Int {
        Log.d("getItemCount : ", items.size.toString())

        return items.size
    }

    override fun onBindViewHolder(holder: PostsInfoAdapter.ViewHolder, position: Int) {

        holder.bind(items[position])
        Log.d("current postion : ", position.toString())
        Log.d("current info : ", items[position].postsTitle)
        holder.itemView.postsLayout.setOnClickListener{
            val intent = Intent(context, PostsActivity::class.java)
            intent.putExtra("authorsName",items[position].authorsName)
            intent.putExtra("postsContent",items[position].postsContent)
            intent.putExtra("postsTitle",items[position].postsTitle)
            intent.putExtra("recommendCount",items[position].recommendCount)
            intent.putExtra("postsView",items[position].postsView)
            intent.putExtra("writtenDate",items[position].writtenDate)
            context.startActivity(intent)


        }



    }



}