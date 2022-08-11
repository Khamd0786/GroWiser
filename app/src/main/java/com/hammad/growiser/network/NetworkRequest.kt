package com.hammad.growiser.network

import org.json.JSONObject
import retrofit2.Response

object NetworkRequest {

    suspend fun <T> process(api: suspend () -> Response<T>): ApiResponse<T> {
        return try {
            val response = api()
            val code = response.code()
            val message = response.message()
            val body = response.body()

            if (response.isSuccessful) {
                ApiResponse.Success(code, message, body)
            } else {
                val rawRes = response.errorBody()?.string() ?: "{}"
                val json = JSONObject(rawRes)
                val m = json.optString("message")
                ApiResponse.Failure(code, m, body)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            return ApiResponse.Failure(-1, "Oops, Something went wrong", null, e)
        }
    }

    sealed class ApiResponse<out T> {
        data class Success<out T>(val code: Int, val message: String, val data: T?) :
            ApiResponse<T>()

        data class Failure<out T>(
            val code: Int,
            val message: String,
            val data: T? = null,
            val throwable: Throwable? = null
        ) : ApiResponse<Nothing>()
    }
}
