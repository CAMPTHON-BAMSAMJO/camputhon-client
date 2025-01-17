package com.dgu.camputhon.util.base

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.decode.SvgDecoder
import coil.load
import com.bumptech.glide.Glide

object BaseAdapter {

    @BindingAdapter("setImage")
    @JvmStatic
    fun ImageView.setImage(imgUrl: String?) {
        this.let {
            Glide.with(context).load(imgUrl).into(this)
        }
    }

    @BindingAdapter("setCoilImage")
    @JvmStatic
    fun ImageView.setCoilImage(imgUrl: String?) {
        this.let {
            it.load(imgUrl) {
                if (imgUrl?.endsWith(".svg") == true) {
                    decoderFactory { result, options, _ -> SvgDecoder(result.source, options) }
                }
                crossfade(true)
            }
        }
    }
}