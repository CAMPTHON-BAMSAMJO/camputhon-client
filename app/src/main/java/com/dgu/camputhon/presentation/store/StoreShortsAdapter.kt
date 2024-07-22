package com.dgu.camputhon.presentation.store

import android.app.Activity
import android.content.Context
import android.media.RouteListingPreference.Item
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.MediaController
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dgu.camputhon.R
import com.dgu.camputhon.databinding.ItemSelectActivityBinding
import com.dgu.camputhon.databinding.ItemStoreShortsBinding
import com.dgu.camputhon.domain.entity.StoredShortsItem
import com.dgu.camputhon.presentation.createshorts.activity.SelectActivityAdapter
import com.dgu.camputhon.util.ItemDiffCallback

class StoreShortsAdapter(private val context: Context, private val activity: Activity) : ListAdapter<StoredShortsItem, StoreShortsAdapter.StoredShortsViewHolder>(
    ItemDiffCallback<StoredShortsItem>(
        onContentsTheSame = { oldItem, newItem -> oldItem == newItem },
        onItemsTheSame = { oldItem, newItem -> oldItem.id == newItem.id }
    )
) {

    inner class StoredShortsViewHolder(
        private val binding: ItemStoreShortsBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: StoredShortsItem) {

            matchShorType(binding, data.shortType)

            val videoView = binding.ivShortsUrl
//            var mediaController = MediaController(context)
//            mediaController.setAnchorView(videoView)
//            binding.ivShortsUrl.setMediaController(mediaController)
//            binding.ivShortsUrl.setVideoURI(Uri.parse(data.shortUrl))
//            binding.ivShortsUrl.start()

//            Glide.with(activity).load(Uri.parse(data.shortUrl)).into(binding.ivShortsUrl)


            binding.ivShortsUrl.setVideoURI(Uri.parse("https://camputhon-resouce.s3.amazonaws.com/1.mp4"))
            binding.ivShortsUrl.setMediaController(MediaController(context))
            binding.ivShortsUrl.requestFocus()
            binding.ivShortsUrl.setOnPreparedListener { mp ->
                mp.start()
            }

            binding.tvShortsLocation.text = "장소: ${data.location}"
            binding.tvShortsActivity.text = "활동: ${data.activity}"
        }
    }

    private fun matchShorType(binding: ItemStoreShortsBinding, shorType: String) {
        with(binding) {
            when (shorType) {
                NONE -> {
                    tvShortType.text = "이제 막 시작한 숏다리"
                    ivShortsType.setImageResource(R.drawable.ic_type_7)
                }
                THINKING -> {
                    tvShortType.text = "별빛 속 깊은 사색의 숏다리"
                    ivShortsType.setImageResource(R.drawable.ic_type_1)
                }
                SUNSET -> {
                    tvShortType.text = "노을과 함께 페이지를 넘기는 숏다리"
                    ivShortsType.setImageResource(R.drawable.ic_type_6)
                }
                SUNSHINE -> {
                    tvShortType.text = "햇살 아래 맛있는 점심을 즐기는 숏다리"
                    ivShortsType.setImageResource(R.drawable.ic_type_8)
                }
                HARDWORK -> {
                    tvShortType.text = "새벽 기운을 품은 열공 숏다리 캐릭터"
                    ivShortsType.setImageResource(R.drawable.ic_type_3)
                }
                SWEAT -> {
                    tvShortType.text = "저녁 빛에 땀을 흘리는 숏다리"
                    ivShortsType.setImageResource(R.drawable.ic_type_2)
                }
                LAUGHTER -> {
                    tvShortType.text = "오후 햇살 속 웃음 가득한 숏다리"
                    ivShortsType.setImageResource(R.drawable.ic_type_4)
                }
                DREAMS -> {
                    tvShortType.text = "밤의 영화관에서 꿈을 꾸는 숏다리"
                    ivShortsType.setImageResource(R.drawable.ic_type_5)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoredShortsViewHolder {
        val binding =
            ItemStoreShortsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StoredShortsViewHolder (binding)
    }

    override fun onBindViewHolder(holder: StoredShortsViewHolder , position: Int) {
        holder.onBind(getItem(position))
    }

    companion object {
        const val NONE = "NONE"
        const val THINKING = "THINKING"
        const val SUNSET = "SUNSET"
        const val SUNSHINE = "SUNSHINE"
        const val HARDWORK = "HARDWORK"
        const val SWEAT = "SWEAT"
        const val LAUGHTER = "LAUGHTER"
        const val DREAMS = "DREAMS"
    }
}