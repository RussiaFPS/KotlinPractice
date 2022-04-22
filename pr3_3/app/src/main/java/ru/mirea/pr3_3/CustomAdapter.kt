package ru.mirea.pr3_3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val mList: List<Person>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemsViewModel = mList[position]
        holder.textViewName.text = ItemsViewModel.name
        holder.textViewPhoneNumber.text = ItemsViewModel.phoneNumber
        if (ItemsViewModel.sex=="Mr"){
            holder.imageViewSex.setImageResource(R.drawable.man)
        }else if(ItemsViewModel.sex=="Mrs"){
            holder.imageViewSex.setImageResource(R.drawable.women)
        }else{
            holder.imageViewSex.setImageResource(R.drawable.notinfo)
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textViewName: TextView = itemView.findViewById(R.id.name)
        val textViewPhoneNumber: TextView = itemView.findViewById(R.id.phoneNumber)
        val imageViewSex: ImageView = itemView.findViewById(R.id.sex)
    }
}