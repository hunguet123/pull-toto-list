package com.hunguet123.todoList.ui.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewModelScope
import com.hunguet123.todoList.R
import com.hunguet123.todoList.data.Task

import com.hunguet123.todoList.ui.add.AddFragment
import com.hunguet123.todoList.ui.delete.DeleteFragment
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val viewModel: HomeViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listenEvents()
        setupViews()

        initData()
        observeData()
    }

    private fun setupViews() {
        recyclerTasks.adapter = TaskAdapter
    }

    private fun listenEvents() {
        cardAdd.setOnClickListener {
            val fragment = AddFragment().apply {
                onPopBackstack = {
                    viewModel.getTasks()
                }
            }
            activity?.supportFragmentManager?.beginTransaction()
                ?.add(R.id.frameMain, fragment)
                ?.addToBackStack(null)
                ?.commit()
        }

        TaskAdapter.apply {
            getFragmentDelete = { position ->
                val fragment = DeleteFragment().apply {
                    val bundle = Bundle()
                    bundle.putInt("key", position)
                    arguments = bundle
                    onPopBackstack = {
                        viewModel.getTasks()
                    }
                }
                activity?.supportFragmentManager?.beginTransaction()
                    ?.add(R.id.frameMain, fragment)
                    ?.addToBackStack(null)
                    ?.commit()
            }
        }
    }

    private fun initData() {
        viewModel.getTasks()
    }

    private fun observeData() {
        viewModel.error.observe(viewLifecycleOwner) { errorMsg ->
            context?.run {
                Toast.makeText(this, errorMsg, Toast.LENGTH_LONG).show()
            }
        }
        viewModel.tasks.observe(viewLifecycleOwner) { tasks ->
            TaskAdapter.submitList(tasks)
            textCount.text = getString(R.string.text_count, tasks.size)
        }
    }
}
