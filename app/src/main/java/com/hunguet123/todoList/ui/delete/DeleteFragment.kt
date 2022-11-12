package com.hunguet123.todoList.ui.delete

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.hunguet123.todoList.R
import com.hunguet123.todoList.ui.home.HomeViewModel
import kotlinx.android.synthetic.main.fragment_delete_item.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DeleteFragment : Fragment(R.layout.fragment_delete_item) {

    private val viewModel : DeleteViewModel by viewModel()
    private val homeViewModel : HomeViewModel by viewModel()

    private var position = 0

    var onPopBackstack: () -> Unit = {}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = this.arguments
        if (bundle != null) {
            position = bundle.getInt("key")
        }
        initData()
        listenEvents()
        observeData()
    }

    private fun initData() {
        homeViewModel.getTasks()
    }

    private fun listenEvents() {
        buttonYes.setOnClickListener {
            val task = homeViewModel.tasks?.value?.get(position)
            if (task != null) {
                viewModel.deleteItem(task)
            }
        }

        buttonNo.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
            onPopBackstack()
        }
    }

    private fun observeData() {
        viewModel.error.observe(viewLifecycleOwner) { errorMsg ->
            context?.run {
                Toast.makeText(this, errorMsg, Toast.LENGTH_LONG).show()
            }
        }
        viewModel.isDeleteSuccess.observe(viewLifecycleOwner) { isSuccess ->
            if (isSuccess) {
                activity?.supportFragmentManager?.popBackStack()
                onPopBackstack()
            }
        }
    }
}