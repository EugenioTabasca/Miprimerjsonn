package com.example.jsonporfavor

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jsonporfavor.Adapter.MyMovieAdapter
import com.example.jsonporfavor.Common.Common
import com.example.jsonporfavor.Interface.RetrofitService
import com.example.jsonporfavor.Model.Movie
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var mService: RetrofitService
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter : MyMovieAdapter
    lateinit var dialog : AlertDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mService = Common.retrofitService

        recyclearList.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclearList.layoutManager = layoutManager

        dialog = SpotsDialog.Builder().setCancelable(false).setContext(this).build()

        getAllMovieList()

    }

    private fun getAllMovieList() {
        dialog.show()

        mService.getMovieList().enqueue(object:Callback<MutableList<Movie>>{
            override fun onResponse(call: Call<MutableList<Movie>>, response: Response<MutableList<Movie>>, ) {
               adapter = MyMovieAdapter(baseContext,response.body() as MutableList<Movie>)
               adapter.notifyDataSetChanged()
               recyclearList.adapter = adapter
               dialog.dismiss()
            }

            override fun onFailure(call: Call<MutableList<Movie>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}

