package io.legado.app.ui.book.search

import android.os.Bundle
import androidx.recyclerview.widget.DiffUtil
import io.legado.app.data.entities.SearchBook

class DiffCallBack(private val oldItems: List<SearchBook>, private val newItems: List<SearchBook>) :
    DiffUtil.Callback() {

    override fun getNewListSize(): Int {
        return newItems.size
    }

    override fun getOldListSize(): Int {
        return oldItems.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return true
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldItems[oldItemPosition]
        val newItem = newItems[newItemPosition]
        if (oldItem.name != newItem.name) {
            return false
        }
        if (oldItem.author != newItem.author) {
            return false
        }
        if (oldItem.origins?.size != newItem.origins?.size) {
            return false
        }
        if (oldItem.coverUrl != newItem.coverUrl) {
            return false
        }
        if (oldItem.kind != newItem.kind) {
            return false
        }
        if (oldItem.latestChapterTitle != newItem.latestChapterTitle) {
            return false
        }
        if (oldItem.intro != newItem.intro) {
            return false
        }
        return true
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        val oldItem = oldItems[oldItemPosition]
        val newItem = newItems[newItemPosition]
        val payload = Bundle()
        if (oldItem.name != newItem.name) {
            payload.putString("name", newItem.name)
        }
        if (oldItem.author != newItem.author) {
            payload.putString("author", newItem.author)
        }
        if (oldItem.origins?.size != newItem.origins?.size) {
            payload.putInt("origins", newItem.origins?.size ?: 1)
        }
        if (oldItem.coverUrl != newItem.coverUrl) {
            payload.putString("group", newItem.coverUrl)
        }
        if (oldItem.kind != newItem.kind) {
            payload.putString("enabled", newItem.kind)
        }
        if (oldItem.latestChapterTitle != newItem.latestChapterTitle) {
            payload.putString("enabled", newItem.latestChapterTitle)
        }
        if (oldItem.intro != newItem.intro) {
            payload.putString("enabled", newItem.intro)
        }
        return payload
    }
}