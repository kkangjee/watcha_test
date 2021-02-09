package kkangjee.watcha_test

class Favorite {
    companion object {
        //좋아요 리스트
        var favoriteList = ArrayList<String>()
        fun getList() : ArrayList<String> {

            return favoriteList
        }
        fun setList(favoriteList:ArrayList<String>){
            this.favoriteList = favoriteList
        }
        fun addItem(item:String){
            favoriteList.add(item)
        }

    }
}