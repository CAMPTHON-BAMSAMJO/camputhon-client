package com.dgu.camputhon.presentation.store

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.SurfaceTexture
import android.media.MediaPlayer
import android.media.RouteListingPreference.Item
import android.net.Uri
import android.os.Environment
import android.util.Log
import android.view.LayoutInflater
import android.view.Surface
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.Toast
import androidx.media3.datasource.DataSource
import androidx.media3.datasource.DefaultDataSourceFactory
import androidx.media3.exoplayer.source.ProgressiveMediaSource
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.arthenica.mobileffmpeg.Config
import com.arthenica.mobileffmpeg.FFmpeg
import com.bumptech.glide.Glide
import com.dgu.camputhon.R
import com.dgu.camputhon.databinding.ItemSelectActivityBinding
import com.dgu.camputhon.databinding.ItemStoreShortsBinding
import com.dgu.camputhon.domain.entity.StoredShortsItem
import com.dgu.camputhon.presentation.WebViewActivity
import com.dgu.camputhon.presentation.createshorts.activity.SelectActivityAdapter
import com.dgu.camputhon.util.ItemDiffCallback
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import timber.log.Timber

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

//            var uri: Uri = Uri.parse(data.shortType)

//                val videoUri: Uri = Uri.parse("android.resource://${context.packageName}/${R.raw.testmp4}")
//                val videoUri: Uri = Uri.parse(data.shortUrl)
//                Timber.d("[동영상] format -> $videoUri")
//
//                videoView.setMediaController(MediaController(context))
//                videoView.setVideoURI(videoUri)
//                videoView.requestFocus()
//
//                videoView.setOnPreparedListener {
////                    Toast.makeText(applicationContext, "동영상 재생 준비 완료", Toast.LENGTH_SHORT).show()
//                    Timber.d("[동영상] 동영상 재생 준비 완료")
//                    videoView.start()
//                }
//
//                videoView.setOnCompletionListener {
////                    Toast.makeText(applicationContext, "동영상 시청 완료", Toast.LENGTH_SHORT).show()
//                    Timber.d("[동영상] 동영상 시청 완료")
//                }
//
//                videoView.setOnErrorListener { mp, what, extra ->
////                    Toast.makeText(applicationContext, "동영상 재생 중 오류 발생", Toast.LENGTH_SHORT).show()
//                    Timber.d("[동영상] 동영상 재생 중 오류 발생")
//                    true
//                }

                val videoUri: Uri = Uri.parse(data.shortUrl)
                val outputPath = "${context.getExternalFilesDir(Environment.DIRECTORY_MOVIES)}/converted_${data.id}.mp4"

                convertAndPlayVideo(videoUri, outputPath)
//            }

            binding.tvShortsLocation.text = "장소: ${data.location}"
            binding.tvShortsActivity.text = "활동: ${data.activity}"
        }

        private fun convertAndPlayVideo(videoUri: Uri, outputPath: String) {
            Thread {
                try {
                    // FFMPEG를 사용하여 비디오 변환
                    val ffmpegCommand = arrayOf(
                        "-i", videoUri.toString(),
                        "-c:v", "mpeg4",
                        "-c:a", "aac",
                        "-strict", "experimental",
                        "-y",
                        outputPath
                    )

                    val rc = FFmpeg.execute(ffmpegCommand)
                    val log = Config.getLastCommandOutput()

                    activity.runOnUiThread {
                        if (rc == 0) {
//                            Toast.makeText(context, "동영상 변환 완료", Toast.LENGTH_SHORT).show()
                            Timber.d("[동영상]] 동영상 변환 완료")
                            setupVideoView(outputPath)
                        } else {
//                            Toast.makeText(context, "동영상 변환 실패", Toast.LENGTH_SHORT).show()
                            Timber.d("[동영상]] 동영상 변환 실패 $log")
                        }
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    activity.runOnUiThread {
//                        Toast.makeText(context, "동영상 변환 중 오류 발생", Toast.LENGTH_SHORT).show()
                        Timber.d("[동영상]] 동영상 변환 중 오류 발생")
                    }
                }
            }.start()
        }

        private fun setupVideoView(videoPath: String) {
            with(binding) {
                videoView.setMediaController(MediaController(context))
                videoView.setVideoURI(Uri.parse(videoPath))
                videoView.requestFocus()

                Timber.d("[동영상]] format -> $videoPath")

//                if (videoPath.isNotBlank()) binding.progressbar.visibility = View.GONE

                videoView.setOnPreparedListener {
//                    Toast.makeText(context, "동영상 재생 준비 완료", Toast.LENGTH_SHORT).show()
                    binding.progressbar.visibility = View.GONE
                    Timber.d("[동영상]] 동영상 재생 준비 완료")
                    videoView.start()
                }

                videoView.setOnCompletionListener {
//                    Toast.makeText(context, "동영상 시청 완료", Toast.LENGTH_SHORT).show()
                    Timber.d("[동영상]] 동영상 시청 완료")
                }

                videoView.setOnErrorListener { mp, what, extra ->
//                    Toast.makeText(context, "동영상 재생 중 오류 발생", Toast.LENGTH_SHORT).show()
                    Timber.d("[동영상]] 동영상 재생 중 오류 발생")
                    true
                }
            }
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