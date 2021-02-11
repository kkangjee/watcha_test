package kkangjee.watcha_test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_favorite.*



class FavoriteActivity : AppCompatActivity(R.layout.activity_favorite) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)

        var list = Favorite.getList()
        var adapter = RecyclerAdapter(list)

        rv_favorite.adapter = adapter
    }
}