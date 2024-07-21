package com.dgu.camputhon.presentation.createshorts.location


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dgu.camputhon.R
import com.dgu.camputhon.databinding.ItemSelectLocationBinding
import com.dgu.camputhon.domain.entity.SelectLocation
import com.dgu.camputhon.util.ItemDiffCallback

class SelectLocationAdapter(private val context: Context) : ListAdapter<SelectLocation, SelectLocationAdapter.SelectLocationViewHolder>(
    ItemDiffCallback<SelectLocation>(
        onContentsTheSame = { oldItem, newItem -> oldItem == newItem },
        onItemsTheSame = { oldItem, newItem -> oldItem.location == newItem.location }
    )
) {

    private var onItemClickListener: OnItemClickListener? = null
    private var selectedPosition: Int = RecyclerView.NO_POSITION

    interface OnItemClickListener {
        fun onItemClick(item: SelectLocation, position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.onItemClickListener = listener
    }

    inner class SelectLocationViewHolder(
        private val binding: ItemSelectLocationBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: SelectLocation) {
            binding.tvLocationItem.text = data.location

            if (selectedPosition == absoluteAdapterPosition) {
                changeColor(binding, true)
            } else {
                changeColor(binding, false)
            }

            if (onItemClickListener != null) {
                binding.tvLocationItem.setOnClickListener {
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
        binding: ItemSelectLocationBinding,
        selected: Boolean
    ) {
        when (selected) {
            true -> {
                binding.tvLocationItem.setTextColor(ContextCompat.getColor(context, R.color.main_brown))
                binding.tvLocationItem.setTextAppearance(R.style.TextAppearance_Camputhon_Title_Semibold_24)
            }
            false -> {
                binding.tvLocationItem.setTextColor(ContextCompat.getColor(context, R.color.gray4))
                binding.tvLocationItem.setTextAppearance(R.style.TextAppearance_Camputhon_Title_Semibold_20)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectLocationViewHolder {
        val binding =
            ItemSelectLocationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SelectLocationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SelectLocationViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}