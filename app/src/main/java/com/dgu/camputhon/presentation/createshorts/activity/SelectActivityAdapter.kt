package com.dgu.camputhon.presentation.createshorts.activity

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dgu.camputhon.R
import com.dgu.camputhon.databinding.ItemSelectActivityBinding
import com.dgu.camputhon.domain.entity.SelectActivity
import com.dgu.camputhon.util.ItemDiffCallback

class SelectActivityAdapter(private val context: Context) :
    ListAdapter<SelectActivity, SelectActivityAdapter.SelectActivityViewHolder>(
        ItemDiffCallback<SelectActivity>(
            onContentsTheSame = { oldItem, newItem -> oldItem == newItem },
            onItemsTheSame = { oldItem, newItem -> oldItem.activity == newItem.activity }
        )
    ) {

    private var onItemClickListener: OnItemClickListener? = null
    private var selectedPosition: Int = RecyclerView.NO_POSITION

    interface OnItemClickListener {
        fun onItemClick(item: SelectActivity, position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.onItemClickListener = listener
    }

    inner class SelectActivityViewHolder(
        private val binding: ItemSelectActivityBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: SelectActivity) {
            binding.tvActivityItem.text = data.activity

            if (selectedPosition == absoluteAdapterPosition) {
                changeColor(binding, true)
            } else {
                changeColor(binding, false)
            }

            if (onItemClickListener != null) {
                binding.tvActivityItem.setOnClickListener {
                    onItemClickListener?.onItemClick(data, absoluteAdapterPosition)
                    if (selectedPosition != absoluteAdapterPosition) {
                        changeColor(binding, true)
                        notifyItemChanged(selectedPosition)
                        selectedPosition = absoluteAdapterPosition
                    }
                }
            }
        }
    }

    private fun changeColor(
        binding: ItemSelectActivityBinding,
        selected: Boolean
    ) {
        when (selected) {
            true -> {
                binding.tvActivityItem.setTextColor(
                    ContextCompat.getColor(
                        context,
                        R.color.main_brown
                    )
                )
                binding.tvActivityItem.setTextAppearance(R.style.TextAppearance_Camputhon_Title_Semibold_24)
            }

            false -> {
                binding.tvActivityItem.setTextColor(ContextCompat.getColor(context, R.color.gray4))
                binding.tvActivityItem.setTextAppearance(R.style.TextAppearance_Camputhon_Title_Semibold_20)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectActivityViewHolder {
        val binding =
            ItemSelectActivityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SelectActivityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SelectActivityViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}