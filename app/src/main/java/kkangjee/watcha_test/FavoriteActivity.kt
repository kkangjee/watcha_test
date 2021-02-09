package kkangjee.watcha_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_favorite.*

class FavoriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)
        val list = Favorite.getList()

        for (i in list){
            val button = Button(this)
            button.text = i
            ll_favoritelistview.addView(button)
        }


    }
}