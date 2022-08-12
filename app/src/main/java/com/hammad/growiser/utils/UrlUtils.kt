package com.hammad.growiser.utils

import android.net.Uri

object UrlUtils {

    /**
     * This function append the field and query inside the filters query.
     * For Example: Url is https://xyz, then it add the query param in the url like this   `https://xyz?filters[field] = [query]`
     */
    fun appendFilter(url: String, field: String?, query: String?): String {
        if (field.isNullOrEmpty() || query.isNullOrEmpty())
            return url

        return try {
            val uri = Uri.Builder().also {
                it.appendPath(url)
                it.appendQueryParameter("filters[$field]", query)
            }.build()
            Uri.decode(uri.toString())
        } catch (e: Exception) {
            e.printStackTrace()
            url
        }
    }
}
