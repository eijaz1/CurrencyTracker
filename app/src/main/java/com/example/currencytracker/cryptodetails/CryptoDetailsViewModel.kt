package com.example.currencytracker.cryptodetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class CryptoDetailsViewModelFactory(private val args: CryptoDetailsFragmentArgs) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CryptoDetailsViewModel::class.java)) {
            return CryptoDetailsViewModel(args) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}

class CryptoDetailsViewModel(args: CryptoDetailsFragmentArgs) : ViewModel() {

    private val _viewState: MutableLiveData<CryptoDetailsViewState> = MutableLiveData()
    val viewState: LiveData<CryptoDetailsViewState> = _viewState

    init {
        // Use .value when updating mutable live data
        _viewState.value = CryptoDetailsViewState(args.currency, args.price)
    }

//    fun processArgs(args: CryptoDetailsFragmentArgs) {
//        // since new viewmodel isn't created everytime a new fragment is created,
//        // you don't need to update variables each time a fragment is created
//        // since the data will already be there
//        if (_viewState.value != null) return
//
//    }

}