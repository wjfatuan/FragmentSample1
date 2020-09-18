package co.edu.uan.android.fragmentsample1

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_form.*

/**
 * A simple [Fragment] subclass.
 * Use the [FormFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FormFragment : Fragment() {

    var landscapeOrientation = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_form, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        button.setOnClickListener { _ -> doCalc() }
    }

    fun doCalc() {
        //Fibonacci calc: 1 1 2 3 5 8 13
        val n = editText.text.toString().toInt()
        if(landscapeOrientation) {
            val resultFragment = fragmentManager?.findFragmentById(R.id.resultFragment) as ResultFragment
            resultFragment.updateResult("${fibonacci(n)}")
        }
        else {
            val intent = Intent(activity, SecondActivity::class.java)
            intent.putExtra("RESULT", "${fibonacci(n)}")
            startActivity(intent)
        }
    }

    fun fibonacci(n: Int) : ArrayList<Long> {
        val list = arrayListOf<Long>()
        list.add(1)
        list.add(1)
        var i = 2
        while(i<n) {
            list.add(list[i-1]+list[i-2])
            i++
        }
        return list
    }

//    override fun onConfigurationChanged(newConfig: Configuration) {
//        super.onConfigurationChanged(newConfig)
//        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
//            landscapeOrientation = true
//        else
//            false
//    }

}