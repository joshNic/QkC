package com.example.qkc

import android.app.Application
import com.example.qkc.data.db.AppDatabase
import com.example.qkc.data.network.ApiService
import com.example.qkc.data.network.NetworkConnectionInterceptor
import com.example.qkc.data.repository.UserRepository
import com.example.qkc.ui.auth.AuthViewModelFactory
import com.example.qkc.ui.home.profile.ProfileViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class QkCApplication: Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@QkCApplication))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { ApiService(instance()) }
        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { UserRepository(instance(), instance()) }
        bind() from provider { AuthViewModelFactory(instance()) }
        bind() from provider { ProfileViewModelFactory(instance()) }

    }

}