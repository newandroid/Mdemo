package css.com.applab.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import css.com.applab.R
import kotlinx.android.synthetic.main.activity_coroutines.*
import kotlinx.coroutines.*

class CoroutinesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines)
        btn.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            GlobalScope.launch(Dispatchers.Main) {
                async(Dispatchers.IO) { delay(5000) }.await()
                Toast.makeText(this@CoroutinesActivity, "finish async job but not block main thread", Toast.LENGTH_LONG).show()
                progressBar.visibility = View.GONE
            }
        }

    }
}