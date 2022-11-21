package com.example.education.presentation.fragments.homework1.firstPage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.education.presentation.MainActivity
import com.example.education.R
import com.example.education.databinding.FragmentFirstPageBinding
import com.example.education.presentation.fragments.homework1.secondPage.SecondPageFragment


class FirstPageFragment : Fragment(R.layout.fragment_first_page) {


    private val viewBinding: FragmentFirstPageBinding by viewBinding(FragmentFirstPageBinding::bind)

    private var count: Int = 0
    private var countColor: Int = 1


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(viewBinding) {
            btnIncreaseCount.setOnClickListener {
                count += 1
            }

            btnSwapColor.setOnClickListener {
                countColor += 1
            }

            btnToSecondPage.setOnClickListener {
                (requireActivity() as? MainActivity)?.addFragment(
                    SecondPageFragment.getInstance(count, countColor),
                    SecondPageFragment.SECOND_PAGE_FRAGMENT_TAG,
                    detachCurrent = true
                )
            }
        }
    }



    companion object {
        const val FIRST_PAGE_FRAGMENT_TAG = "FIRST_PAGE_FRAGMENT_TAG"

        fun getInstance() = FirstPageFragment()



    }
}