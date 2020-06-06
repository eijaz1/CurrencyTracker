package com.example.currencytracker.cryptodetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.currencytracker.R
import com.example.currencytracker.databinding.FragmentCryptoDetailsBinding
import kotlinx.android.synthetic.main.fragment_crypto_details.*
import kotlinx.android.synthetic.main.fragment_crypto_details.view.*

class CryptoDetailsFragment : Fragment() {

    private var _binding: FragmentCryptoDetailsBinding? = null
    // This property only valid between onCreateView and onDestroyView
    private val binding: FragmentCryptoDetailsBinding get() = _binding!!



    private val args: CryptoDetailsFragmentArgs by navArgs()

    private lateinit var viewModelFactory: CryptoDetailsViewModelFactory

    // use by viewModels delagate so that a new view model isn't created when each fragment is created
    private val viewModel: CryptoDetailsViewModel by viewModels(
        factoryProducer = { viewModelFactory }
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCryptoDetailsBinding.inflate(inflater, container, false)
        viewModelFactory = CryptoDetailsViewModelFactory(args)
//        val view = inflater.inflate(R.layout.fragment_crypto_details, container, false)

//        val textViewDetailsCurrency: TextView = view.tv_details_currency
//        val textViewDetailsPrice: TextView = view.tv_details_price

//        binding.tvDetailsCurrency.text = arguments?.getString("currency")
//        binding.tvDetailsPrice.text = arguments?.getFloat("price").toString()

//        binding.tvDetailsCurrency.text = args.currency
//        binding.tvDetailsPrice.text = args.price.toString()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewStateObserver = Observer<CryptoDetailsViewState> { viewState ->
            //updateUI
            binding.tvDetailsCurrency.text = viewState.currency
            binding.tvDetailsPrice.text = viewState.price.toString()
        }
        viewModel.viewState.observe(viewLifecycleOwner, viewStateObserver)
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}