package com.example.a3_semina_assignment_1

import java.time.DateTimeException


data class responseBookData(
    val metas : List<metasData>,
    val documents : List<DocumentsData>
)

data class metasData(
    val total_count : Int,
    val pageable_count : Int,
    val is_end : Boolean
)
data class DocumentsData(
    val title : String,
    val contents : String,
    val url : String,
    val isbn : String,
    val authors : Array<String>,
    val publisher : String,
    val translators : Array<String>,
    val price : Integer,
    val sale_price :Integer,
    val thumbnail : String,
    val status : String

)