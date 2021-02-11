package kkangjee.watcha_test

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.giphy.sdk.ui.GPHContentType
import com.giphy.sdk.ui.GiphyLoadingProvider
import com.giphy.sdk.ui.pagination.GPHContent
import kotlinx.android.synthetic.main.activity_favorite.*
import kotlinx.android.synthetic.main.activity_grid_view.*

class FavoriteActivity : AppCompatActivity(R.layout.activity_favorite) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)
        val list = Favorite.getList()

//        for (i in list){
//            val button = Button(this)
//            button.text = i
//            ll_favoritelistview.addView(button)
//        }
        setTrendingQuery()
        //gifsGridView_favorite.setGiphyLoadingProvider(loadingProviderClient)

    }
    private fun setTrendingQuery() {
        gifsGridView_favorite.content = when (DemoConfig.contentType) {
            GPHContentType.gif -> GPHContent.trendingGifs
            GPHContentType.sticker -> GPHContent.trendingStickers
            GPHContentType.text -> GPHContent.trendingText
            GPHContentType.emoji -> GPHContent.emoji
            GPHContentType.recents -> GPHContent.recents
            else -> throw Exception("MediaType ${DemoConfig.mediaType} not supported ")
        }
        //gifsGridView_favorite.
    }
    private val loadingProviderClient = object : GiphyLoadingProvider {
        override fun getLoadingDrawable(position: Int): Drawable {

            return LoadingDrawable(if (position % 2 == 0) LoadingDrawable.Shape.Rect else LoadingDrawable.Shape.Circle)
        }
    }
}