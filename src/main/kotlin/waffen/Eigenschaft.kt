package waffen

data class Eigenschaft(
    val name: String,
    val vorteil: Boolean,
    val maxAnzahl: Int = 1,
    val last: Int = 1,
    val punkte: Int,
    val wert: Double = 0.0, //TODO: rename to preisModifikator
    val schwierigkeitDesAngriffBonus: Int = 0,
    val reichweite: Int = 0,
    val einklappbar: Boolean = false,
    val durchschlag: Int = 0,
    val schaden: Int = 0,
    val vollautomatischeSalvenKugelanzahlBonus: Int = 0,
    val interneMunitionsModifikator: Double = 0.0,
    val rueckstoss: Int = 0,
    val schalldaempfer: Boolean = false,
    val repetierenIstFreieHandlung: Boolean = false,
    val komplexitaet: Int = 0,
    val wartungsReperaturBonus: Int = 0,
    val zusaetzlicheLaeufe: Int = 0,
    val ladehemmungen: Boolean = false,
    val spezialmagazin: Boolean = false,
    val robust: Boolean = false,
    val unrobust: Boolean = false,
    val gesamtpreismodifikator: Double = 0.0, //TODO rename to gesamtPreisModifikator
    val geraeuschBeimNachladen: Boolean = false
)