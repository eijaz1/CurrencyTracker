package com.example.currencytracker.cryptolist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.currencytracker.CryptoRepository
import com.example.currencytracker.R
import com.example.currencytracker.models.Cryptocurrency

import kotlinx.android.synthetic.main.fragment_crypto_list.view.*

class CryptoListFragment : Fragment() {

    private val cryptoRepository = CryptoRepository()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_crypto_list, container, false)

        val cryptoList: RecyclerView = view.rv_crypto_list
        cryptoList.layoutManager = LinearLayoutManager(requireContext())

        val cryptoAdapter = CryptoAdapter() { cryptoItem ->
            showCryptoDetails(cryptoItem)
        }

        cryptoList.adapter = cryptoAdapter

        val cryptoObserver = Observer<List<Cryptocurrency>> {cryptoItems ->
            cryptoAdapter.submitList(cryptoItems)
        }

        cryptoRepository.cryptocurrency.observe(viewLifecycleOwner, cryptoObserver)
        cryptoRepository.loadCrypto()

        return view
    }

    fun showCryptoDetails(cryptocurrency: Cryptocurrency) {
        val currency: String = cryptocurrency.currency
        val price: Float = cryptocurrency.price
//        requireView().findNavController().navigate(R.id.action_cryptoListFragment_to_cryptoDetailsFragment)
//        val action = CryptoListFragmentDirections.actionCryptoListFragmentToCryptoDetailsFragment()
//        view.findNavController().navigate(action)
        val bundle = bundleOf("currency" to currency, "price" to price )
        requireView().findNavController().navigate(R.id.action_cryptoListFragment_to_cryptoDetailsFragment, bundle)
    }

}