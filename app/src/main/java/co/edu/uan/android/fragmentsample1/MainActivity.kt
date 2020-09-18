package co.edu.uan.android.fragmentsample1

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.v("TEXTSAMPLE", "onCreate")
    }

//    fun doCalc() {
//        // Fibonacci calc: 1 1 2 3 5 8 13
//        val n = editText.text.toString().toInt()
//        textView.text = "${fibonacci(n)}"
//    }



    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        val formFragment = fragmentManager?.findFragmentById(R.id.formFragment) as FormFragment
        if(newConfig.orientation==Configuration.ORIENTATION_LANDSCAPE)
            formFragment.landscapeOrientation = true
        else
            formFragment.landscapeOrientation = false

    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        Log.v("TEXTSAMPLE", "onSaveInstanceState")
//        outState.putString("RESULT",textView.text.toString())
//    }
//
//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//        Log.v("TEXTSAMPLE", "onRestoreInstanceState")
//        textView.text = savedInstanceState.getString("RESULT")
//    }
}