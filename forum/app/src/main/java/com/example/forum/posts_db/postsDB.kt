package com.example.forum.posts_db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.forum.PostsInfo

@Database(entities = [PostsInfo::class], version = 1 ,exportSchema = false)
abstract class postsDB : RoomDatabase(){

        abstract fun postsDao(): postsDao

        companion object {
            private var INSTANCE: postsDB? = null

            fun getInstance(context: Context): postsDB? {
                if (INSTANCE == null) {
                    synchronized(postsDB::class) {
                        INSTANCE = Room.databaseBuilder(context.applicationContext,
                            postsDB::class.java, "posts.db")
                            .fallbackToDestructiveMigration()
                            .build()
                    }
                }
                return INSTANCE
            }

            fun destroyInstance() {
                INSTANCE = null
            }
        }
    }