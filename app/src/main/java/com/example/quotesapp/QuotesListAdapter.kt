package com.example.quotesapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class QuotesListAdapter(val context: Context, val list: List<QuotesResponse> ) : RecyclerView.Adapter<QuotesListAdapter.QuotesViewHolder>()  {




    inner class QuotesViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        var textview_quote = itemView.findViewById<TextView>(R.id.textview_quote)
        var textview_author = itemView.findViewById<TextView>(R.id.textview_author)
        var btn_copy = itemView.findViewById<Button>(R.id.btn_copy)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotesViewHolder {

        val layout = LayoutInflater.from(context).inflate(R.layout.list_quote,parent,false)
        return QuotesViewHolder(layout)

    }

    override fun onBindViewHolder(holder: QuotesViewHolder, position: Int) {
        holder.textview_quote.text = list.get(position).text
        holder.textview_author.text = list.get(position).author

    }

    override fun getItemCount(): Int {
          return  list.size
    }
}