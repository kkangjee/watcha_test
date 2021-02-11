package kkangjee.watcha_test

import android.content.Context
import android.preference.PreferenceManager
import com.giphy.sdk.analytics.GiphyPingbacks.context
import org.json.JSONArray


class Favorite {
    companion object {
        //SharedPreference 사용을 위한 key
        const val SETTINGS_PLAYER_JSON = "settings_item_json"

        //좋아요 리스트
        var favoriteList = ArrayList<String>()

        fun getList(): ArrayList<String> {
            var arrayList = ArrayList<String>()
            for (i in favoriteList) {
                if (!arrayList.contains(i))
                    arrayList.add(i)
            }
            return arrayList
        }

        fun setList(favoriteList: ArrayList<String>) {
            this.favoriteList = favoriteList
            setStringArrayPref(context, SETTINGS_PLAYER_JSON, Companion.favoriteList)
        }

        fun addItem(item: String) {
            favoriteList.add("https://media4.giphy.com/media/$item/giphy.gif")
            setStringArrayPref(context, SETTINGS_PLAYER_JSON, Companion.favoriteList)

        }

        private fun setStringArrayPref(context: Context, key: String, values: ArrayList<String>) {
            val prefs = PreferenceManager.getDefaultSharedPreferences(context)
            val editor = prefs.edit()
            val a = JSONArray()
            for (i in 0 until values.size) {
                a.put(values[i])
            }
            if (values.isNotEmpty()) {
                editor.putString(key, a.toString())
            } else {
                editor.putString(key, null)
            }
            editor.apply()
        }


    }
}