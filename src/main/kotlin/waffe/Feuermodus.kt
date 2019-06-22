package waffe

data class Feuermodus(
    val name: String,
    val reichweite: Int,
    val rueckstoss: Int,
    val komplexitaet: Int,
    val punkte: Int,
    val preisModifikator: Double
)