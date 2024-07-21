package com.dgu.camputhon.presentation.createshorts.time

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.dgu.camputhon.databinding.BottomsheetSelectTimeBinding
import com.dgu.camputhon.presentation.createshorts.CreateShortsViewModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


interface AlertPickerDialogInterface {
    fun onClickDoneBtn(id: Int, meridiem: Int, hour: Int, minute: Int)
}

class SelectTimeBottomSheet(
    pickerDialogInterface: AlertPickerDialogInterface,
    id: Int,
    meridiem: Int, hour: Int, minute: Int
) : BottomSheetDialogFragment() {

    private val viewModel by activityViewModels<CreateShortsViewModel>()

    private var _binding: BottomsheetSelectTimeBinding? = null
    val binding: BottomsheetSelectTimeBinding
        get() = requireNotNull(_binding as BottomsheetSelectTimeBinding)

    private val meridiemArr = arrayOf("오전", "오후")
    private val hoursArr = Array(12) { (it + 1).toString() }
    private val minutesArr = Array(60) { (it).toString() }

    private var pickerDialogInterface: AlertPickerDialogInterface? = null
    private var id: Int? = null

    // 선택된 값
    private var meridiem: Int? = null
    private var hour: Int? = null
    private var minute: Int? = null

    init {
        this.id = id
        this.meridiem = meridiem
        this.hour = hour
        this.minute = minute
        this.pickerDialogInterface = pickerDialogInterface
    }

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
        _binding = BottomsheetSelectTimeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        val ampmPicker = binding.pickerTimeAmpm
        val hoursPicker = binding.pickerTimeHour
        val minutePicker = binding.pickerTimeMinute

        binding.btnSelectTime.setOnClickListener {
            meridiem = ampmPicker.value
            hour = hoursPicker.value
            minute = minutePicker.value

            this.pickerDialogInterface?.onClickDoneBtn( id ?: 0, meridiem ?: 0, hour ?: 0, minute ?: 0)
            dismiss()
        }

        //  최소값 설정
        ampmPicker.minValue = 0
        hoursPicker.minValue = 1
        minutePicker.minValue = 0

        //  최대값 설정
        ampmPicker.maxValue = meridiemArr.size - 1
        hoursPicker.maxValue = 12
        minutePicker.maxValue = 59

        ampmPicker.displayedValues = meridiemArr
        hoursPicker.displayedValues = hoursArr
        minutePicker.displayedValues = minutesArr

        ampmPicker.value = meridiem ?: 0
        hoursPicker.value = hour ?: 0
        minutePicker.value = minute ?: 0

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}