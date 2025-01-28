package com.fady.network

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BaseUrl

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class NonAuthHttpClient

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AuthHttpClient

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class NonAuthRetrofit

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AuthRetrofit
