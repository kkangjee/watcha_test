package kkangjee.watcha_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.giphy.sdk.core.models.Media
import com.giphy.sdk.ui.GPHContentType
import com.giphy.sdk.ui.GPHSettings
import com.giphy.sdk.ui.Giphy
import com.giphy.sdk.ui.themes.GPHTheme
import com.giphy.sdk.ui.themes.GridType
import com.giphy.sdk.ui.views.GiphyDialogFragment

class MainActivity : AppCompatActivity() {
    private val YOUR_API_KEY = "BJqVVqyooC5k6JK8kQruMEHs9c2DKKHj"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Giphy.configure(this, YOUR_API_KEY)


        //테마 설정

        val settings = GPHSettings(GridType.waterfall, GPHTheme.Dark)
        val gifsDialog = GiphyDialogFragment.newInstance(settings)

        //이미지 확인 옵션
        //settings.showConfirmationScreen = true

        gifsDialog.gifSelectionListener = object : GiphyDialogFragment.GifSelectionListener {
            override fun didSearchTerm(term: String) {
                //Callback for search terms
            }

            override fun onDismissed(selectedContentType: GPHContentType) {
                //Your user dismissed the dialog without selecting a GIF
            }

            override fun onGifSelected(media: Media, searchTerm: String?, selectedContentType: GPHContentType) {
                Log.e("main_onGifSelected", "선택 됨")
            }
        }



        gifsDialog.show(supportFragmentManager, "giphy_dialog")
        setContentView(R.layout.activity_main)
    }

}

//https://github.com/Giphy/giphy-android-sdk-ui-example/blob/master/Docs.md#the-giphy-grid