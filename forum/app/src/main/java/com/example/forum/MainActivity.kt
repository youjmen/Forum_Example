package com.example.forum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.forum.posts_db.postsDB
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

    override fun onResume() {
        super.onResume()
        createPosts()
    }
    override fun onDestroy() {
        postsDB.destroyInstance()
        postsDb = null
        super.onDestroy()
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



    public fun createPosts(){





            /* "nameKey"라는 이름의 key에 저장된 값이 있다면
               textView의 내용을 "nameKey" key에서 꺼내온 값으로 바꾼다 */


    }
}
