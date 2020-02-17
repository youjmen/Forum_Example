package com.example.forum

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "posts_info")
data class PostsInfo @Ignore constructor(@PrimaryKey(autoGenerate = true) var id: Long?,
                @ColumnInfo(name = "posts_title")var postsTitle: String?,
                @ColumnInfo(name = "posts_view")var postsView : Int?,
                @ColumnInfo(name = "authors_name")var authorsName : String?,
                @ColumnInfo(name = "recommend_count")var recommendCount: Int?,
                @ColumnInfo(name = "written_date")var writtenDate : String? ,
                                    @ColumnInfo(name = "posts_content")var postsContent : String?) {

    constructor(): this(null,"", 0,"",0,"","")



}