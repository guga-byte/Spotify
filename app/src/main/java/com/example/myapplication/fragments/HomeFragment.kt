package com.example.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.adapters.ViewPagerAdapter
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.fragments.fragmentsForViewPager.AllFragment
import com.example.myapplication.fragments.fragmentsForViewPager.MusicFragment
import com.example.myapplication.fragments.fragmentsForViewPager.PodcastsFragment
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding

    private val fList = listOf(
        AllFragment.newInstance(),
        MusicFragment.newInstance(),
        PodcastsFragment.newInstance()
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        if (isAdded){
            val vpAdapter = ViewPagerAdapter(requireActivity() , fList)
            vp.adapter = vpAdapter
            val tList = listOf(
                ContextCompat.getDrawable(requireContext(),R.drawable.ic_all),
                ContextCompat.getDrawable(requireContext(),R.drawable.ic_music),
                ContextCompat.getDrawable(requireContext(),R.drawable.ic_podcasts)

            )

            TabLayoutMediator(tablayout,vp) { tab, position ->
                tab.icon = tList[position]
            }.attach()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}