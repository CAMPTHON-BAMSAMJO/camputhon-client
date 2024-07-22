package com.dgu.camputhon.presentation.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.dgu.camputhon.R
import com.dgu.camputhon.databinding.FragmentHomeBinding
import com.dgu.camputhon.databinding.ItemStoreShortsBinding
import com.dgu.camputhon.presentation.store.StoreShortsAdapter
import com.dgu.camputhon.util.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val viewModel by viewModels<HomeViewModel>()
//    private lateinit var circleBarViewActivity: CustomCircleBarView
//    private lateinit var circleBarViewLocation: CustomCircleBarView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel

//        circleBarViewActivity = view.findViewById(R.id.customCircleBarView_activity)
//        circleBarViewLocation = view.findViewById(R.id.customCircleBarView_location)

        viewModel.getHomeAPIData()

        setData()
    }

    private fun setData() {
        viewModel.homeData.observe(viewLifecycleOwner) { homeItem ->
            binding.tvHomeAdvantage.text = homeItem.advantage
            binding.tvHomeDevelop.text = homeItem.develop
            matchShorType(homeItem.shortType)

//            circleBarViewActivity.setProgress(homeItem.mostActivity.percentage.toFloat())
//            circleBarViewLocation.setProgress(homeItem.mostLocation.percentage.toFloat())
        }
    }

    private fun matchShorType(shorType: String) {
        with(binding) {
            when (shorType) {
                StoreShortsAdapter.NONE -> {
                    tvHomeTypeText.text = "이제 막 시작한"
                    ivShortsType.setImageResource(R.drawable.ic_type_7)
                }
                StoreShortsAdapter.THINKING -> {
                    tvHomeTypeText.text = "별빛 속 깊은 사색의"
                    ivShortsType.setImageResource(R.drawable.ic_type_1)
                }
                StoreShortsAdapter.SUNSET -> {
                    tvHomeTypeText.text = "노을과 함께 페이지를 넘기는"
                    ivShortsType.setImageResource(R.drawable.ic_type_6)
                }
                StoreShortsAdapter.SUNSHINE -> {
                    tvHomeTypeText.text = "햇살 아래 맛있는 점심을 즐기는"
                    ivShortsType.setImageResource(R.drawable.ic_type_8)
                }
                StoreShortsAdapter.HARDWORK -> {
                    tvHomeTypeText.text = "새벽 기운을 품은 열공 숏다리"
                    ivShortsType.setImageResource(R.drawable.ic_type_3)
                }
                StoreShortsAdapter.SWEAT -> {
                    tvHomeTypeText.text = "저녁 빛에 땀을 흘리는"
                    ivShortsType.setImageResource(R.drawable.ic_type_2)
                }
                StoreShortsAdapter.LAUGHTER -> {
                    tvHomeTypeText.text = "오후 햇살 속 웃음 가득한"
                    ivShortsType.setImageResource(R.drawable.ic_type_4)
                }
                StoreShortsAdapter.DREAMS -> {
                    tvHomeTypeText.text = "밤의 영화관에서 꿈을 꾸는"
                    ivShortsType.setImageResource(R.drawable.ic_type_5)
                }
            }
        }
    }
}