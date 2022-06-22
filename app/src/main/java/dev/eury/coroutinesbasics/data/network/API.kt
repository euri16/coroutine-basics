package dev.eury.coroutinesbasics.data.network

import dev.eury.coroutinesbasics.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object API {
    private val interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val httpInterceptor = Interceptor { chain ->
        val request = chain.request()
            .newBuilder()
            .header("Content-type", "application/json")
            .header("charset", "UTF-8")
            .build()

        chain.proceed(request)
    }

    // OkhttpClient for building http request url
    private val okHttpClient = OkHttpClient().newBuilder()
        .addInterceptor(interceptor)
        .addNetworkInterceptor(httpInterceptor)
        .build()

    private fun retrofit(): Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: APIService = retrofit().create(APIService::class.java)

}