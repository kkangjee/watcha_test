package kkangjee.watcha_test

import android.content.Context
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import kkangjee.watcha_test.Favorite.Companion.SETTINGS_PLAYER_JSON
import kotlinx.android.synthetic.main.activity_favorite.*
import org.json.JSONArray
import org.json.JSONException


class FavoriteActivity : AppCompatActivity(R.layout.activity_favorite) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)

        val list: ArrayList<String> = if (getStringArrayPref(this, SETTINGS_PLAYER_JSON) != null)
            getStringArrayPref(this, SETTINGS_PLAYER_JSON)!!
        else
            ArrayList<String>()

        var adapter = RecyclerAdapter(list)
        rv_favorite.adapter = adapter
    }

    private fun getStringArrayPref(context: Context, key: String): ArrayList<String>? {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        val json = prefs.getString(key, null)
        val urls = ArrayList<String>()
        if (json != null) {
            try {
                val a = JSONArray(json)
                for (i in 0 until a.length()) {
                    val url = a.optString(i)
                    urls.add(url)
                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }
        }
        return urls
    }
}