package com.example.currencytracker

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.currencytracker.models.Cryptocurrency
import kotlin.random.Random

class CryptoRepository {

    private val _cryptocurrency = MutableLiveData<List<Cryptocurrency>>()
    val cryptocurrency: LiveData<List<Cryptocurrency>> = _cryptocurrency

    fun loadCrypto() {
        val randomValues = List(15) { Random.nextFloat().rem(100) * 100 }
        val cryptoItems = randomValues.map { price ->
            Cryptocurrency("BTC", price)
        }
        _cryptocurrency.value = cryptoItems
    }

}