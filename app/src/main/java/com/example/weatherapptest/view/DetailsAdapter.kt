package com.example.weatherapptest.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapptest.R
import com.example.weatherapptest.data.model.DataList
import com.example.weatherapptest.data.model.SingleDayForecast
import com.example.weatherapptest.viewmodel.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint

class DetailsAdapter : RecyclerView.Adapter<DetailsViewHolder>() {
    private var list: List<DataList> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsViewHolder {
        val holder = LayoutInflater.from(parent.context)
            .inflate(R.layout.detail_item_view, parent, false)
        return DetailsViewHolder(holder)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: DetailsViewHolder, position: Int) {
        val item = list[position]
        holder.bindDetails(item)
    }

    fun setList(list: List<DataList>) {
        this.list = list
    }
}