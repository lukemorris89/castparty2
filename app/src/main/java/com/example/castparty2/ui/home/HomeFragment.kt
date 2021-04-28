package com.example.castparty2.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.castparty2.R
import com.example.castparty2.databinding.FragmentHomeBinding
import com.example.castparty2.ui.MainViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import java.util.*


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: MainViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_home,
            container,
            false
        )

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        setWelcomeText()

        setUpListeners()

        return binding.root
    }

    fun setWelcomeText() {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        binding.welcomeTv.let {
            when (hour) {
                in 0..11 -> it.text = "Good Morning, $userFirstName"
                in 12..18 -> it.text = "Good Afternoon, $userFirstName"
                in 18..23 -> it.text = "Good Evening, $userFirstName"
                else -> it.text = "Welcome, $userFirstName"
            }
        }
    }

    fun setUpListeners() {
        binding.dismissButton.setOnClickListener {
            binding.homeContentMotionLayout.transitionToEnd()
        }

        viewModel.podcastList.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            if (it != null && it.isNotEmpty()) {
                binding.topPicksPb.visibility = View.GONE
                binding.topPicksRv.apply {
                    adapter = HomeRecyclerViewAdapter(requireContext(), it).apply {
                        onItemClick = { podcast ->
                            findNavController().navigate(R.id.podcastFragment)
                        }
                    }
                }
            } else {
                binding.topPicksPb.visibility = View.VISIBLE
            }
        })

    }


    companion object {
        private const val userFirstName = "Luke"
    }


}