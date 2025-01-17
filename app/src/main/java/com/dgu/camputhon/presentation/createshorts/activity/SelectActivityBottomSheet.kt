package com.dgu.camputhon.presentation.createshorts.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.MutableLiveData
import com.dgu.camputhon.databinding.BottomsheetSelectActivityBinding
import com.dgu.camputhon.databinding.BottomsheetSelectLocationBinding
import com.dgu.camputhon.domain.entity.SelectActivity
import com.dgu.camputhon.domain.entity.SelectLocation
import com.dgu.camputhon.presentation.createshorts.CreateShortsViewModel
import com.dgu.camputhon.presentation.createshorts.location.SelectLocationAdapter
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class SelectActivityBottomSheet : BottomSheetDialogFragment() {

    private val viewModel by activityViewModels<CreateShortsViewModel>()

    private var _binding: BottomsheetSelectActivityBinding? = null
    val binding: BottomsheetSelectActivityBinding
        get() = requireNotNull(_binding as BottomsheetSelectActivityBinding)

    private var _selectActivityAdapter: SelectActivityAdapter? = null
    private val selectActivityAdapter
        get() = requireNotNull(_selectActivityAdapter)

//    private val selectedActivity = MutableLiveData<String>("")

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
        _binding = BottomsheetSelectActivityBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel

        initSetAdapter()
        initSetLocationList()
        clickConfirmBtn()
    }

    private fun initSetAdapter() {
        _selectActivityAdapter = SelectActivityAdapter(requireContext()).apply {
            setOnItemClickListener(object : SelectActivityAdapter.OnItemClickListener {
                override fun onItemClick(item: SelectActivity, position: Int) {
//                    selectedActivity.value = item.activity
                    viewModel.setSelectedActivity(item.activity)
                }
            })
        }
        binding.rcvSelectActivity.adapter = selectActivityAdapter
    }

    private fun initSetLocationList() {
        viewModel.activityList.observe(viewLifecycleOwner) {
            selectActivityAdapter.submitList(it)
        }
    }

    private fun clickConfirmBtn() {
//        binding.btnSelectActivity.setOnClickListener {
//            viewModel.setSelectedActivity(selectedActivity.value ?: "")
//            dismiss()
//        }
        viewModel.selectedActivity.observe(viewLifecycleOwner) {
            binding.btnSelectActivity.visibility = View.VISIBLE
            binding.btnSelectActivity.setOnClickListener {
                dismiss()
            }
        }
    }
}