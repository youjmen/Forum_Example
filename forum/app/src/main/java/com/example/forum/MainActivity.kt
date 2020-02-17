package com.example.forum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.forum.posts_db.postsDB
import com.example.forum.posts_db.postsDao
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    var list = listOf<PostsInfo>()
    private var postsDb : postsDB? = null
    lateinit var mAdapter : PostsInfoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        postsDb = postsDB.getInstance(this)
        mAdapter = PostsInfoAdapter(this, list)

        val r = Runnable {
            try {
                list = postsDb?.postsDao()?.getAll()!!
                mAdapter = PostsInfoAdapter(this, list)
                mAdapter.notifyDataSetChanged()

                recyclerView.adapter = mAdapter
                recyclerView.layoutManager = LinearLayoutManager(this)
                recyclerView.setHasFixedSize(true)
            } catch (e: Exception) {
                Log.d("tag", "Error - $e")
            }
        }

        val thread = Thread(r)
        thread.start()

        setSupportActionBar(toolbar2)


        val adapter = PostsInfoAdapter(this,list)
        recyclerView.adapter = adapter

        writingButton.setOnClickListener {
            startActivity<WritePosts>()


        }
    }

    override fun onDestroy() {
        postsDB.destroyInstance()
        postsDb = null
        super.onDestroy()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_delete,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId){

            R.id.deleteall -> {
                val r = Runnable {
                    try {
                        postsDb?.postsDao()?.deleteAll()
                    }
                    catch(e: Exception) {
                        Log.d("tag", "Error - $e")

                    }

                }
                val thread = Thread(r)
                thread.start()

            }

        }
        return super.onOptionsItemSelected(item)
    }



        /*recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        var adapter = PostsInfoAdapter()
        val a = PostsInfo("ㄲ",2,"ㅎ",5,"ㄴㅇ")
        adapter.addItem(a)

        recyclerView.adapter= adapter
        */
       /* writingButton.setOnClickListener{
            startActivity<>()
        }*/




}
