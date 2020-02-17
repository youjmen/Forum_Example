package com.example.forum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.forum.posts_db.postsDB
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_posts.*
import kotlinx.android.synthetic.main.activity_write_posts.*
import org.jetbrains.anko.toast

class PostsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts)


        if (intent.hasExtra("postsContent")) {
            postsTitle.setText(intent.getStringExtra("postsTitle"))
            PostsContents.setText(intent.getStringExtra("postsContent"))
            postsView.setText(intent.getIntExtra("postsView",0).toString())
            recommendCount.setText(intent.getIntExtra("recommendedCount",0).toString())
            writtenDate.setText(intent.getStringExtra("writtenDate"))
            authorsName.setText(intent.getStringExtra("authorsName"))


        }




    }

}
