package com.dgu.camputhon.presentation

import android.app.Activity
import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import android.widget.Toast
import com.dgu.camputhon.R
import com.dgu.camputhon.databinding.ActivityWebviewBinding
import com.dgu.camputhon.util.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class WebViewActivity : BaseActivity<ActivityWebviewBinding>(R.layout.activity_webview) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var uri: Uri = Uri.parse(intent.getStringExtra("SHORT_URL"))
        with (binding) {

            val videoUri: Uri = Uri.parse("android.resource://" + packageName + "/" + R.raw.testmp4 )

            videoView.setMediaController(MediaController(this@WebViewActivity))
            videoView.setVideoURI(videoUri)
            videoView.requestFocus()

            videoView.setOnPreparedListener {
                Toast.makeText(applicationContext, "동영상 재생 준비 완료", Toast.LENGTH_SHORT).show()
                Timber.d("[동영상] 동영상 재생 준비 완료")
                videoView.start()
            }

            videoView.setOnCompletionListener {
                Toast.makeText(applicationContext, "동영상 시청 완료", Toast.LENGTH_SHORT).show()
                Timber.d("[동영상] 동영상 시청 완료")
            }

            videoView.setOnErrorListener { mp, what, extra ->
                Toast.makeText(applicationContext, "동영상 재생 중 오류 발생", Toast.LENGTH_SHORT).show()
                Timber.d("[동영상] 동영상 재생 중 오류 발생")
                true
            }
        }

    }
}