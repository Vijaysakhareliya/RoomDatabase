package com.roomdatabase.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.roomdatabase.R
import com.roomdatabase.databinding.ItemUserBinding

class UserAdapter(private var listUser: List<UserModel>, var mPresenter : MainContract.MainPresenter) :
    RecyclerView.Adapter<UserAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(
        private val parent: ViewGroup,
        private val binding: ItemUserBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_user,
            parent,
            false
        )
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int, item: UserModel) {
            binding.position = position
            binding.userModel = item
            binding.presenter = mPresenter
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(position, listUser[position])
    }
}