package com.example.currencytracker.cryptodetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.currencytracker.R
import kotlinx.android.synthetic.main.fragment_crypto_details.*
import kotlinx.android.synthetic.main.fragment_crypto_details.view.*

class CryptoDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_crypto_details, container, false)

        val textViewDetailsCurrency: TextView = view.tv_details_currency
        val textViewDetailsPrice: TextView = view.tv_details_price

        textViewDetailsCurrency.text = arguments?.getString("currency")
        textViewDetailsPrice.text = arguments?.getFloat("price").toString()

        return view
    }

}