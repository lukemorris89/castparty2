package com.example.castparty2.di

import androidx.room.Room
import com.example.castparty2.database.CastParty2DB
import com.example.castparty2.database.DataRepository
import com.example.castparty2.datasource.local.LocalDataSource
import com.example.castparty2.datasource.remote.RemoteDataSource
import com.example.castparty2.ui.MainViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single {
        Room.databaseBuilder(
            androidApplication(),
            CastParty2DB::class.java,
            "CastParty2Db"
        )
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    single { LocalDataSource(get()) }
    single { RemoteDataSource() }
    single { DataRepository(get(), get()) }

    viewModel { MainViewModel(get()) }
}