package com.example.forum

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.forum.posts_db.postsDB
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_write_posts.*
import org.jetbrains.anko.startActivity
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class WritePosts : AppCompatActivity() {

    private var postsDb : postsDB? = null
    lateinit var addRunnable : Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write_posts)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        postsDb = postsDB.getInstance(this)

         addRunnable = Runnable {
            val newPostsInfo = PostsInfo()
            newPostsInfo.postsTitle = writtenTitle.text.toString()
            newPostsInfo.authorsName = "ppap"
            newPostsInfo.recommendCount = 0
            newPostsInfo.postsView = 0
            newPostsInfo.writtenDate = getLocalTime()
            postsDb?.postsDao()?.insert(newPostsInfo)
        }



    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId){
            android.R.id.home -> {
                finish() }

            R.id.register -> {
                val addThread = Thread(addRunnable)
                addThread.start()
                val mainIntent = Intent(this, MainActivity::class.java)
                startActivity(mainIntent)
                finish()
            }

        }
        return super.onOptionsItemSelected(item)
    }
    override fun onDestroy() {
        postsDB.destroyInstance()
        super.onDestroy()
    }

        fun getLocalTime(): String? {
            lateinit var formatted: String
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val current = LocalDateTime.now().plusHours(9)
                val formatter = DateTimeFormatter.ofPattern("HH : mm")
                formatted = current.format(formatter)


            }
            return formatted

        }


}
