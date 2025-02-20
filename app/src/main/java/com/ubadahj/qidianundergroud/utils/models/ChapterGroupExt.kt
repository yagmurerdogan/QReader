package com.ubadahj.qidianundergroud.utils.models

import com.ubadahj.qidianundergroud.models.ChapterGroup
import java.util.*

val ChapterGroup.firstChapter: Int
    get() = text.split("-").first().trim().toInt()

val ChapterGroup.lastChapter: Int
    get() = text.split("-").last().trim().toInt()

val ChapterGroup.total: Int
    get() = lastChapter - firstChapter + 1

fun ChapterGroup.isRead() = lastRead == lastChapter


val ChapterGroup.source: String
    get() {
        val source = link.replace(Regex(".+//|www.|\\..+"), "").capitalize(Locale.ROOT)
        return if ("book/" in source) "WebNovel" else source
    }

operator fun ChapterGroup.contains(chapter: Int): Boolean = chapter in firstChapter..lastChapter
