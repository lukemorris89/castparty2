package com.example.castparty2.di

import androidx.room.Room
import com.example.castparty2.database.CastPartyDB
import com.example.castparty2.database.DataRepository
import com.example.castparty2.datasource.local.LocalDataSource
import com.example.castparty2.datasource.remote.RemoteDataSource
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val appModule = module {

    single {
        Room.databaseBuilder(
            androidApplication(),
            CastPartyDB::class.java,
            "CastPartyDb"
        )
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    single { LocalDataSource(get()) }
    single { RemoteDataSource() }
    single { DataRepository(get(), get()) }

//    viewModel { MainViewModel(get()) }
}