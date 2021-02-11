package kkangjee.watcha_test

class Favorite {
    companion object {
        //좋아요 리스트

        var favoriteList: LinkedHashSet<String> = LinkedHashSet()
        fun getList() : LinkedHashSet<String> {

            return favoriteList
        }
        fun setList(favoriteList: LinkedHashSet<String>){
            this.favoriteList = favoriteList
        }
        fun addItem(item: String){
            favoriteList.add("https://media4.giphy.com/media/$item/giphy.gif")
        }

    }
}