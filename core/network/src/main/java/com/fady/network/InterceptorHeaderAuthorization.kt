package com.fady.network

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import javax.inject.Provider

class InterceptorHeaderAuthorization (private val provider: Provider<String>) : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        builder.addHeader(
            "Authorization",
            "Bearer " + provider.get()
        )
        builder.addHeader(
            "Content-Type",
            "application/json",
        )

        val request = builder.build()

        return chain.proceed(request)
    }
}
