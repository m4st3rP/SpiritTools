package waffen

data class Schaft(
    val name: String,
    val last: Int,
    val reichweite: Int,
    val rueckstossModifikator: Double,
    val punkte: Int,
    val preisModifikator: Double
)