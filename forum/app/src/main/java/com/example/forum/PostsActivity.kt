package com.example.forum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.forum.posts_db.postsDB
import kotlinx.android.synthetic.main.activity_write_posts.*

class PostsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts)



    }

}
