package kkangjee.watcha_test

class Favorite {
    companion object {
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
        }

        fun addItem(item: String) {
            favoriteList.add("https://media4.giphy.com/media/$item/giphy.gif")
        }

    }
}