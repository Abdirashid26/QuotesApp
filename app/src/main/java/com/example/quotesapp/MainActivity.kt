package com.example.quotesapp

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainActivity : AppCompatActivity() {

    var dialog: ProgressDialog? = null
    lateinit var recycler_home : RecyclerView;

    private val listener = object : QuotesResponseListener {
        override fun didFetch(response: List<QuotesResponse>, message: String) {
            dialog?.dismiss()
            recycler_home.setHasFixedSize(true)
            recycler_home.layoutManager = StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL)
            val adapter = QuotesListAdapter(this@MainActivity,response)
            recycler_home.adapter = adapter
        }

        override fun didError(message: String) {
            dialog?.dismiss()
            Toast.makeText(this@MainActivity,message,Toast.LENGTH_SHORT).show()
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_home = findViewById<RecyclerView>(R.id.recycler_home)

        RequestManager(this@MainActivity).getAllQuotes(listener)
        dialog = ProgressDialog(this@MainActivity)
        dialog?.setTitle("Loading ...")
        dialog?.show()



    }
}