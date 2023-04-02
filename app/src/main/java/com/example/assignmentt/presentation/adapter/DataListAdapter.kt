package com.example.assignmentt.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.assignmentt.databinding.ItemDataBinding
import com.example.assignmentt.data.DataResponse

class DataListAdapter (
    private val list:DataResponse,
    private val context: Context
        ):RecyclerView.Adapter<DataListAdapter.DataViewHolder>()
{
         class DataViewHolder(val binding:ItemDataBinding) :
             RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
      return DataViewHolder(
          ItemDataBinding.inflate(
              LayoutInflater.from(parent.context),
              parent,
              false
          )
      )
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {

        with(holder){
            if(list.preview.size>=3)
            {
                Glide.with(context).load(list.preview.get(2)).into(binding.imageView)
            }

            binding.dataTitle.text= list.title
            binding.dataAuthor.text= list.author
            binding.dataDescription.text= list.subreddit
        }
    }

    override fun getItemCount(): Int {
        return 1
        }}
