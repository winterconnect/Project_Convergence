package com.example.kiosk_ver0.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
//import androidx.lifecycle.ViewModelProviders
import com.example.kiosk_ver0.R
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * A placeholder fragment containing a simple view.
 */
class Page2Fragment : Fragment() {

    // 뷰 생성 <onCreate다음에 호출됨>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_main, container, false)
        return root
    }

    // 뷰 생성이 완료되면 호출되는 메소드
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        section_label.text=arguments?.let{
            it.getInt(num).toString()
        }
        imageView.setImageResource(R.drawable.smile)
    }

    companion object {
        private const val num = "num"

        @JvmStatic
        fun newInstance(Number: Int): Page2Fragment {
            return Page2Fragment().apply {
                arguments = Bundle().apply {
                    putInt(num, Number)
                }
            }
        }
    }
}