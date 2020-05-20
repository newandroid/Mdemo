package css.com.applab.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.hubert.guide.NewbieGuide
import com.app.hubert.guide.model.GuidePage
import css.com.applab.R
import kotlinx.android.synthetic.main.activity_guide.*


class GuideActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guide)
        NewbieGuide.with(this)
                .setLabel("guide1")
                .addGuidePage(GuidePage.newInstance()
                        .addHighLight(button10)
                        .setLayoutRes(R.layout.view_guide_simple))
                .show();
    }
}
