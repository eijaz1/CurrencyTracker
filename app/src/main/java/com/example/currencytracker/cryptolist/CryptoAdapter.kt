package com.example.currencytracker.cryptolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.currencytracker.R
import com.example.currencytracker.models.Cryptocurrency
import kotlinx.android.synthetic.main.list_item_crypto.view.*

class CryptoViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val textViewCurrency: TextView = view.tv_currency
    private val textViewPrice: TextView = view.tv_price

    fun bind(cryptocurrency: Cryptocurrency) {
        textViewCurrency.text = cryptocurrency.currency
        textViewPrice.text = cryptocurrency.price.toString()
    }

}

class CryptoAdapter(private val clickHandler: (Cryptocurrency) -> Unit) : ListAdapter<Cryptocurrency, CryptoViewHolder>(CryptoDiffUtilCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_crypto, parent, false)
        return CryptoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener {
            clickHandler(getItem(position))
        }
    }

}


class CryptoDiffUtilCallback: DiffUtil.ItemCallback<Cryptocurrency>() {
    override fun areItemsTheSame(oldItem: Cryptocurrency, newItem: Cryptocurrency): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Cryptocurrency, newItem: Cryptocurrency): Boolean {
        return oldItem == newItem
    }
}