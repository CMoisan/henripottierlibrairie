package imt.oscarclemclem.henripottierlibrairie

import java.io.Serializable

class Book(
    val isbn: String,
    val title: String,
    var price: Int,
    var cover: String,
    var synopsis: Array<String>
) : Serializable