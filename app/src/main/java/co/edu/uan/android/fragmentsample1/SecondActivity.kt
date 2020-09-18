package co.edu.uan.android.fragmentsample1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_second.*
import java.util.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //val resultFragment = fragmentManager?.findFragmentById(R.id.otherFragment) as ResultFragment
        //resultFragment.updateResult(intent.getStringExtra("RESULT")!!)

        val n = readFile()
        var i = 0
        var l = LinearLayout(this)
        l.setOrientation(LinearLayout.HORIZONTAL)
        containerButton.addView(l)
        while(i<n) {
            val b = ImageButton(this)
            b.setImageResource(R.drawable.dog)
            b.setPadding(5, 5, 5, 5)
            l.addView(b)
            i++
            if(i%2==0) {
                l = LinearLayout(this)
                l.setOrientation(LinearLayout.HORIZONTAL)
                containerButton.addView(l)
            }
            //b.setOnClickListener { _-> doSomething("us") }
        }
    }

    fun doSomething() {
        //
    }

    fun readFile() : Int {
        val f = Scanner(resources.openRawResource(R.raw.images))
        val l = f.nextLine()
        f.close()
        return l.toInt()
    }
}