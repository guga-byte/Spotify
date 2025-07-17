package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentMainBinding
import com.example.myapplication.fragments.HomeFragment
import com.example.myapplication.fragments.LibraryFragment
import com.example.myapplication.fragments.SearchFragment

class MainFragment : Fragment() {

    private var _binding : FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    private fun loadFragment(f : Fragment){
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.mainFragment,f)
            .commit()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding){
        super.onViewCreated(view, savedInstanceState)

        loadFragment(HomeFragment.newInstance())

        bottomNavMenu.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> {
                    loadFragment(HomeFragment.newInstance())
                    true
                }
                R.id.search -> {
                    loadFragment(SearchFragment.newInstance())
                    true
                }
                R.id.library -> {
                    loadFragment(LibraryFragment.newInstance())
                    true
                }
                else -> {
                    loadFragment(HomeFragment.newInstance())
                    true
                }
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}