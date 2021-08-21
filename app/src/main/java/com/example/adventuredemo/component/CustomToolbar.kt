package com.example.adventuredemo.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.example.adventuredemo.databinding.ToolbarBinding

class CustomToolbar : FrameLayout {

    private lateinit var binding: ToolbarBinding

    constructor(context: Context) : super(context) {
        initInflate()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initInflate()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initInflate()
    }

    var toolbarTitle: String? = ""
        set(value) {
            binding.tvTitle.text = value
            field = value
        }

    private fun initInflate() {
        binding = ToolbarBinding.inflate(LayoutInflater.from(context), this, true)
    }

    var isOnBackVisible = true
        set(value) {
            binding.backGroup.visibility = if (value) View.VISIBLE else View.GONE
            field = value
        }

    fun onClickBack(listener: OnClickListener) {
        binding.backGroup.setAllOnClickListener(listener)
    }

    fun setTitle(title: String?) {
        binding.tvTitle.text = title ?: ""
    }
}