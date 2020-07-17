package com.example.qkc.data.network

import android.content.Context
import android.net.ConnectivityManager
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.qkc.ui.util.NoInternetException
import okhttp3.Interceptor
import okhttp3.Response

class NetworkConnectionInterceptor(
    context: Context
) : Interceptor {

    private val applicationContext = context.applicationContext

    @RequiresApi(Build.VERSION_CODES.M)
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!isInternetAvailable())
            throw NoInternetException("Make sure you have an active data connection")
        return chain.proceed(chain.request())
    }

//    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
//    @RequiresApi(Build.VERSION_CODES.M)
//    private fun isInternetAvailable(): Boolean {
//        var result = false
//        val connectivityManager =
//            applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
//
//    if(Build.VERSION.SDK_INT<=Build.VERSION_CODES.LOLLIPOP){
//        connectivityManager?.activeNetworkInfo?.also {
//            return it!=null && it.isConnected
//        }
//    }
//    if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
//        connectivityManager?.let {
//            it.getNetworkCapabilities(connectivityManager.activeNetwork)?.apply {
//                result = when {
//                    hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
//                    hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
//                    else -> false
//                }
//            }
//        }
//    }
//
//        return result
//    }

//    @RequiresApi(Build.VERSION_CODES.M)
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun isInternetAvailable():Boolean{
        val connectivityManager = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//        connectivityManager.allNetworks.isNotEmpty()
//        val networkInfo = connectivityManager.activeNetwork
        return connectivityManager.allNetworks.isNotEmpty()
    }

}