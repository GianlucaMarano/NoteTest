package com.example.notetest

class Note (){

    constructor(title: String, description: String, isFavourite: Boolean) : this() {
        this.title = title
        this.description = description
        this.isFavourite = isFavourite
    }
    var title : String = ""
    var description: String = ""
    var isFavourite = false
}