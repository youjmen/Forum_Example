package com.example.forum.posts_db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.forum.PostsInfo

@Dao
interface postsDao {

    @Query("SELECT * FROM posts_info")
    fun getAll(): List<PostsInfo>

    /* import android.arch.persistence.room.OnConflictStrategy.REPLACE */
    @Insert(onConflict = REPLACE)
    fun insert(postsInfo: PostsInfo)

    @Query("DELETE from posts_info")
    fun deleteAll()
}