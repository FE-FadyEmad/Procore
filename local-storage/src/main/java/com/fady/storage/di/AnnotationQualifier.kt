package com.fady.storage.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DataBaseName

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class SharedPrefName