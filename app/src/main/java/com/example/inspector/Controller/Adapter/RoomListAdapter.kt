package com.example.inspector.Controller.Adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.inspector.Model.Room
import com.example.inspector.R
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import kotlinx.android.synthetic.main.item_default_form.view.*

/**
 * Created by Lucas Alves dos Santos on 29/07/2020.
 * lucas.alves0828@gmail.com
 * {@see more in https://github.com/lucasalves08}
 */
class RoomListAdapter(options: FirestoreRecyclerOptions<Room>, private val context: Context): FirestoreRecyclerAdapter<Room, RoomListAdapter.ViewHolder>(options) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_default_form, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int, model: Room) {
        holder.let { item ->
            item.bindView(model)
            item.itemView.setOnClickListener {
                val bundle = Bundle()
                bundle.putSerializable("room", model)
                it.findNavController().navigate(R.id.action_nav_my_reports_to_roomDetailsFragment, bundle)
            }
        }
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindView(room: Room){
            val placeName = itemView.placleNameTextView
            val name = itemView.nameTextView
            val date = itemView.dateTextView

            placeName.text = room.placeName
            name.text = room.inspectedName
            date.text = room.getUserDate()
        }
    }
}