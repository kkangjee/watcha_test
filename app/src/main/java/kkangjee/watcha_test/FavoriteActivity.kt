package kkangjee.watcha_test

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_favorite.*


class FavoriteActivity : AppCompatActivity(R.layout.activity_favorite) {
    private var list = Favorite.getList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)

        loadItem()

    }
    fun loadItem(){
        for (i in list) {
            val imageView = ImageView(this)
            imageView.setOnClickListener {
                refresh(i)
            }

            Glide.with(this).load(i).into(imageView)

            ll_favorite.addView(imageView)
        }
    }
    fun refresh(str:String){
        list.remove(str)
        val linearLayout = LinearLayout(this)
        sv_favorite.addView(linearLayout)
        //ll_favorite.invalidate()
        loadItem()
    }

}