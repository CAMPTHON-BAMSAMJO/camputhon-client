package com.dgu.camputhon.presentation.createshorts.location

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.dgu.camputhon.databinding.BottomsheetSelectLocationBinding
import com.dgu.camputhon.domain.entity.SelectLocation
import com.dgu.camputhon.presentation.createshorts.CreateShortsViewModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import timber.log.Timber

class SelectLocationBottomSheet : BottomSheetDialogFragment() {

    private val viewModel by activityViewModels<CreateShortsViewModel>()

    private var _binding: BottomsheetSelectLocationBinding? = null
    val binding: BottomsheetSelectLocationBinding
        get() = requireNotNull(_binding as BottomsheetSelectLocationBinding)

    private var _selectLocationAdapter: SelectLocationAdapter? = null
    private val selectLocationAdapter
        get() = requireNotNull(_selectLocationAdapter)

    override fun onStart() {
        super.onStart()

        val behavior = BottomSheetBehavior.from(requireView().parent as View)
        behavior.state = BottomSheetBehavior.STATE_EXPANDED
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = BottomsheetSelectLocationBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel

        initSetAdapter()
        initSetLocationList()
    }

    private fun initSetAdapter() {
        _selectLocationAdapter = SelectLocationAdapter(requireContext()).apply {
            setOnItemClickListener(object : SelectLocationAdapter.OnItemClickListener {
                override fun onItemClick(item: SelectLocation, position: Int) {
//                    Timber.d("[숏폼 생성] 제작 장소 바텀시트 -> ${item.location}")
                    viewModel.setSelectedLocation(item.location)
                }
            })
        }
        binding.rcvSelectLocation.adapter = selectLocationAdapter
    }

    private fun initSetLocationList() {
        viewModel.locationList.observe(viewLifecycleOwner) {
            selectLocationAdapter.submitList(it)
        }
    }

    private fun clickConfirmBtn() {
        // TODO 장소 입력 버튼 구현
    }

}