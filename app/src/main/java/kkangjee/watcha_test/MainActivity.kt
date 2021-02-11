package kkangjee.watcha_test

import android.content.Intent
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.giphy.sdk.analytics.GiphyPingbacks.context
import com.giphy.sdk.core.models.Media
import com.giphy.sdk.core.models.enums.RenditionType
import com.giphy.sdk.ui.*
import com.giphy.sdk.ui.themes.GPHTheme
import com.giphy.sdk.ui.themes.GridType
import com.giphy.sdk.ui.views.GPHMediaView
import com.giphy.sdk.ui.views.GiphyDialogFragment
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : AppCompatActivity() , GiphyDialogFragment.GifSelectionListener{
    private val YOUR_API_KEY = "BJqVVqyooC5k6JK8kQruMEHs9c2DKKHj"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //log 초기화
        setupTimber()

        Giphy.configure(this, YOUR_API_KEY)


        //테마 설정
        val settings = GPHSettings(GridType.waterfall, GPHTheme.Dark)
        val gifsDialog = GiphyDialogFragment.newInstance(settings)

        //이미지 확인 옵션
        settings.showConfirmationScreen = true


        setContentView(R.layout.activity_main)

        bt_gridviewactivity.setOnClickListener {
            val intent = Intent(this, GridViewActivity::class.java)
            startActivity(intent)
        }


        bt_favorite.setOnClickListener {

            val intent = Intent(this, FavoriteActivity::class.java)
            startActivity(intent)
        }
        bt_show.setOnClickListener {
            gifsDialog.show(supportFragmentManager, "giphy_dialog")
            startActivity(intent)
        }

    }

    override fun didSearchTerm(term: String) {
        //Callback for search terms
    }

    override fun onDismissed(selectedContentType: GPHContentType) {
        //Your user dismissed the dialog without selecting a GIF
    }

    override fun onGifSelected(
        media: Media,
        searchTerm: String?,
        selectedContentType: GPHContentType
    ) {
        //Your user tapped a GIF
    }
    private fun setupTimber() {
        Timber.plant(Timber.DebugTree())
    }
}

//https://github.com/Giphy/giphy-android-sdk-ui-example/blob/master/Docs.md#the-giphy-grid