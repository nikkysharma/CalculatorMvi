package com.example.myapplication.di

import com.example.myapplication.domain.CalculateValue
import com.example.myapplication.data.CalculateValueImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class CalculatorModule {
    @Binds
    @Singleton
    abstract fun bindCalRepository(
        calculateValueImpl: CalculateValueImpl
    ): CalculateValue
}