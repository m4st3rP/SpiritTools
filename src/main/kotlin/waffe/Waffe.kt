package waffe

import kotlin.math.roundToInt

const val MAX_NACHTEILIGE_EIGENSCHAFTEN_PUNKTE = 5
const val VOLLAUTOMATISCHE_SALVENKUGELANZAHL_BASIS = 3
const val LAEUFE_ANZAHL_BASIS = 1

data class Waffe(
    private val eigenschaften: List<Eigenschaft>,
    private var feuermodus: Feuermodus,
    private var kaliber: Kaliber,
    private var lauf: Lauf,
    private var magazin: Magazin,
    private var rahmen: Rahmen,
    private var schaft: Schaft
    ) {
    var lastE: Int = Int.MIN_VALUE
    var durchschlagE: Int = Int.MIN_VALUE
    var rueckstossE: Int = Int.MIN_VALUE
    var eigenschaftenNamenE: List<String> = mutableListOf()
    var feuermodusE: String = "Fehler"
    var kaliberE: String = "Fehler"
    var komplexitaetE: Int = Int.MIN_VALUE
    var kugelnE: Int = Int.MIN_VALUE
    var schadenE: Int = Int.MIN_VALUE
    var reichweiteE: Int = Int.MIN_VALUE
    var magazingroesseE: Int = Int.MIN_VALUE
    var magazinartE: String = "Fehler"
    var preisE: Double = Double.MIN_VALUE
    var punkteE: Int = Int.MIN_VALUE

    var schwierigkeitDesAngriffBonusE: Int = Int.MIN_VALUE
    var einklappbarE: Boolean? = null
    var vollautomatischeSalvenKugelanzahlE: Int = Int.MIN_VALUE
    var schalldaempferE: Boolean? = null
    var repetierenIstFreieHandlungE: Boolean? = null
    var wartungsReperaturBonusE: Int = Int.MIN_VALUE
    var laeufeAnzahlE: Int = Int.MIN_VALUE
    var ladehemmungenE: Boolean? = null
    var spezialmagazinE: Boolean? = null
    var robustE: Boolean? = null
    var unrobustE: Boolean? = null
    var geraeuschBeimNachladenE: Boolean? = null

    var eigenschaftenBeschreibung: String = ""

    fun calculateEverything() {
        println("Last = " + getLast())
        println("Durchschlag = " + getDurchschlag())
        println("Rückstoß = " + getRueckstoss())
        println("Eigenschaften = " + getEigenschaftenNamen())
        println("Feuermodus = " + getFeuermodus())
        println("Kaliber = " + getKaliber())
        println("Komplexität = " + getKomplexitaet())
        println("Kugeln = " + getKugeln())
        println("Schaden = " + getSchaden())
        println("Reichweite = " + getReichweite())
        println("Magazingröße = " + getMagazingroesse())
        println("Magazinart = " + getMagazinart())
        println("Preis = " + "%.2f".format(getPreis()))
        println("Punkte = " + getPunkte())

        println("Schwierigkeit des Angriff Bonus = " + getSchwierigkeitDesAngriffBonus())
        println("Einklappbar = " + getEinklappbar())
        println("Vollautomatische Salvenkugelanzahl = " + getVollautomatischeSalvenKugelanzahl())
        println("Schalldämpfer = " + getSchalldaempfer())
        println("Repetieren ist freie Handlung = " + getRepetierenIstFreieHandlung())
        println("Wartungs-/Reperaturbonus = " + getWartungsReperaturBonus())
        println("Anzahl Läufe = " + getLaeufeAnzahl())
        println("Ladehemmungen bei Patzer = " + getLadehemmungen())
        println("Spezialmagazin = " + getSpezialmagain())
        println("Robust = " + getRobust())
        println("Unrobust = " + getUnrobust())
        println("PING! (Lautes Geräusch beim Nachladen) = " + getGeraeuscheBeimNachladen())
    }

    fun getLast(): Int {
        var last = rahmen.last
        last += kaliber.last
        last += lauf.last
        last += schaft.last

        last += eigenschaften.stream().mapToInt { it.last }.sum()

        lastE = last
        return last
    }

    fun getSchaden(): Int {
        var schaden = kaliber.schaden
        schaden += eigenschaften.stream().mapToInt { it.schaden }.sum()

        schadenE = schaden
        return schaden
    }

    fun getDurchschlag(): Int {
        var durchschlag = kaliber.durchschlag
        durchschlag += magazin.durchschlag
        durchschlag += lauf.durchschlag
        durchschlag += eigenschaften.stream().mapToInt { it.durchschlag }.sum()

        if(kaliber.durchschlagNull) {
            durchschlag = 0
        }

        durchschlagE = durchschlag
        return durchschlag
    }

    fun getReichweite(): Int {
        var reichweite = kaliber.reichweite
        reichweite += feuermodus.reichweite
        reichweite += schaft.reichweite
        reichweite += eigenschaften.stream().mapToInt { it.reichweite }.sum()

        val reichweitenModifikator = lauf.reichweitenModifikator

        reichweite = (reichweite*reichweitenModifikator).roundToInt()

        reichweiteE = reichweite
        return reichweite
    }

    fun getRueckstoss(): Int {
        var rueckstoss = rahmen.rueckstoss
        rueckstoss += kaliber.rueckstoss
        rueckstoss += feuermodus.rueckstoss
        rueckstoss += lauf.rueckstoss
        rueckstoss += eigenschaften.stream().mapToInt { it.rueckstoss }.sum()

        val rueckstossModifikator = schaft.rueckstossModifikator

        rueckstoss = (rueckstoss*rueckstossModifikator).roundToInt()

        rueckstossE = rueckstoss
        return rueckstoss
    }

    fun getMagazingroesse(): Int {
        val internMap = hashMapOf( //TODO: turn to JSON?
            "Leichte Pistole" to 7,
            "Schwere Pistole" to 6,
            "Mittelpatrone" to 5,
            "Gewehrpatrone" to 5,
            "Schroftline" to 4,
            "Leichte Panzerbüchse" to 3,
            "Schwere Panzerbüchse" to 3
        )

        val zylinderMap = hashMapOf( //TODO: turn to JSON?
            "Leichte Pistole" to 6,
            "Schwere Pistole" to 5,
            "Mittelpatrone" to 4,
            "Gewehrpatrone" to 4,
            "Schroftline" to 3,
            "Leichte Panzerbüchse" to 3,
            "Schwere Panzerbüchse" to 3
        )

        var magazingroesse = when(getMagazinart()) {
            "Kipplauf" -> 1
            "Intern" -> internMap[getKaliber()]?: -1
            "Zylinder" -> zylinderMap[getKaliber()]?: -1
            else -> -1
        }

        var interneMunitionsModifikator = 1.0
        interneMunitionsModifikator += eigenschaften.stream().mapToDouble { it.interneMunitionsModifikator }.sum()

        magazingroesse = (magazingroesse.times(interneMunitionsModifikator)).roundToInt()

        magazingroesseE = magazingroesse
        return magazingroesse
    }

    fun getMagazinart(): String {
        magazinartE = magazin.name
        return magazin.name
    }

    fun getFeuermodus(): String {
        feuermodusE = feuermodus.name
        return feuermodus.name
    }

    fun getKaliber(): String {
        kaliberE = kaliber.name
        return kaliber.name
    }

    fun getKomplexitaet(): Int {
        var komplexitaet = rahmen.komplexitaet
        komplexitaet += kaliber.komplexitaet
        komplexitaet += magazin.komplexitaet
        komplexitaet += feuermodus.komplexitaet
        komplexitaet += eigenschaften.stream().mapToInt { it.komplexitaet }.sum()

        komplexitaetE = komplexitaet
        return komplexitaet
    }

    fun getKugeln(): Int {
        kugelnE = kaliber.schadenAnzahl
        return kaliber.schadenAnzahl
    }

    fun getPreis(): Double {
        var preis = rahmen.preis
        preis += kaliber.preis

        var preisModifikator = magazin.preisModifikator
        preisModifikator += feuermodus.preisModifikator
        preisModifikator += lauf.preisModifikator
        preisModifikator += schaft.preisModifikator
        preisModifikator += eigenschaften.stream().mapToDouble { it.wert }.sum()

        var gesamtpreismodifikator = 1.0
        gesamtpreismodifikator += eigenschaften.stream().mapToDouble { it.gesamtpreismodifikator }.sum()

        preis *= preisModifikator * gesamtpreismodifikator

        preisE = preis
        return preis
    }

    fun getEigenschaftenNamen(): List<String> {
        eigenschaftenNamenE = eigenschaften.map { it.name }
        return eigenschaftenNamenE
    }

    fun getPunkte(): Int {
        var punkte = rahmen.punkte
        punkte += kaliber.punkte
        punkte += magazin.punkte
        punkte += feuermodus.punkte
        punkte += schaft.punkte
        punkte += lauf.punkte

        punkte += eigenschaften.stream().mapToInt {it.punkte}.sum()

        punkteE = punkte
        return punkte
    }

    fun getSchwierigkeitDesAngriffBonus(): Int {
        schwierigkeitDesAngriffBonusE = eigenschaften.stream().mapToInt {it.schwierigkeitDesAngriffBonus}.sum()
        if (schwierigkeitDesAngriffBonusE != 0) {
            eigenschaftenBeschreibung += "Schwierigkeit des Angriffbonus = $schwierigkeitDesAngriffBonusE, "
        }
        return schwierigkeitDesAngriffBonusE
    }

    fun getEinklappbar(): Boolean {
        val einklappbar = eigenschaften.stream().anyMatch { it.einklappbar }
        einklappbarE = einklappbar
        if (einklappbar) {
            eigenschaftenBeschreibung += "Einklappbar, "
        }
        return einklappbar
    }

    fun getVollautomatischeSalvenKugelanzahl(): Int {
        vollautomatischeSalvenKugelanzahlE = eigenschaften.stream().mapToInt {it.vollautomatischeSalvenKugelanzahlBonus}.sum() + VOLLAUTOMATISCHE_SALVENKUGELANZAHL_BASIS

        if(vollautomatischeSalvenKugelanzahlE != VOLLAUTOMATISCHE_SALVENKUGELANZAHL_BASIS) {
            eigenschaftenBeschreibung += "Vollautomatische Salvenkugelanzal = $vollautomatischeSalvenKugelanzahlE, "
        }

        return vollautomatischeSalvenKugelanzahlE
    }

    fun getSchalldaempfer(): Boolean {
        val schalldaempfer = eigenschaften.stream().anyMatch { it.schalldaempfer }
        schalldaempferE = schalldaempfer
        if(schalldaempfer) {
            eigenschaftenBeschreibung += "Schalldämpfer, "
        }
        return schalldaempfer
    }

    fun getRepetierenIstFreieHandlung(): Boolean {
        val repetierenIstFreieHandlung = eigenschaften.stream().anyMatch { it.repetierenIstFreieHandlung }
        repetierenIstFreieHandlungE = repetierenIstFreieHandlung
        if (repetierenIstFreieHandlung) {
            eigenschaftenBeschreibung += "Repetieren ist freie Handlung, "
        }
        return repetierenIstFreieHandlung
    }

    fun getWartungsReperaturBonus(): Int {
        wartungsReperaturBonusE = eigenschaften.stream().mapToInt{it.wartungsReperaturBonus}.sum()
        if(wartungsReperaturBonusE != 0) {
            eigenschaftenBeschreibung += "Wartungs-/Reperaturbonus = $wartungsReperaturBonusE, "
        }
        return wartungsReperaturBonusE
    }

    fun getLaeufeAnzahl(): Int {
        laeufeAnzahlE = eigenschaften.stream().mapToInt { it.zusaetzlicheLaeufe }.sum() + LAEUFE_ANZAHL_BASIS
        if (laeufeAnzahlE != LAEUFE_ANZAHL_BASIS) {
            eigenschaftenBeschreibung += "Anzahl Läufe = $laeufeAnzahlE, "
        }
        return laeufeAnzahlE
    }

    fun getLadehemmungen(): Boolean {
        val ladehemmungen = eigenschaften.stream().anyMatch { it.ladehemmungen }
        ladehemmungenE = ladehemmungen
        if (ladehemmungen) {
            eigenschaftenBeschreibung += "Bei Patzer Ladehemunng, "
        }
        return ladehemmungen
    }

    fun getSpezialmagain(): Boolean {
        val spezialmagazin = eigenschaften.stream().anyMatch { it.spezialmagazin }
        spezialmagazinE = spezialmagazin
        if(spezialmagazin) {
            eigenschaftenBeschreibung += "Spezialmagazin, "
        }
        return spezialmagazin
    }

    fun getRobust(): Boolean {
        val robust = eigenschaften.stream().anyMatch { it.robust }
        robustE = robust
        if(robust) {
            eigenschaftenBeschreibung += "Robust, "
        }
        return eigenschaften.stream().anyMatch { it.robust }
    }

    fun getUnrobust(): Boolean {
        val unrobust = eigenschaften.stream().anyMatch { it.unrobust }
        unrobustE = unrobust
        if(unrobust) {
            eigenschaftenBeschreibung += "Unrobust, "
        }
        return unrobust
    }

    fun getGeraeuscheBeimNachladen(): Boolean {
        val geraeuschBeimNachladen = eigenschaften.stream().anyMatch { it.geraeuschBeimNachladen }
        geraeuschBeimNachladenE = geraeuschBeimNachladen
        if(geraeuschBeimNachladen) {
            eigenschaftenBeschreibung += "PING!, "
        }
        return geraeuschBeimNachladen
    }

    fun getWaffeLegal(blacklists: List<Blacklist>, whitelists: List<Whitelist>): Legal {
        var legal = true
        var firstFoundPart = ""
        var message = ""

        for (b in blacklists) {
            var amountOfBlacklistedParts = 0
            for(n in b.list) {
                if(containsPart(n)) {
                    amountOfBlacklistedParts++
                    if(amountOfBlacklistedParts == 1) {
                        firstFoundPart = n
                    }
                    if(amountOfBlacklistedParts > 1) {
                        val mes = "$n ist mit $firstFoundPart inkompatibel."
                        println(mes)
                        message += mes + "\n"
                        legal = false
                    }
                }
            }
        }

        for(w in whitelists) {
            if (containsPart(w.name)) {
                for(t in w.list) {
                    if(!containsPart(t)) {
                        val mes = "Waffe hat ${w.name} und braucht deswegen auch $t."
                        println(mes)
                        message += mes + "\n"
                        legal = false
                    }
                }
            }
        }

        var amountOfNachteiligeEigenschaftenPunkte = 0
        for(e in eigenschaften) {
            if (!e.vorteil) {
                amountOfNachteiligeEigenschaftenPunkte += e.punkte
            }
        }
        if (amountOfNachteiligeEigenschaftenPunkte > MAX_NACHTEILIGE_EIGENSCHAFTEN_PUNKTE) {
            val mes = "Waffe hat mehr als $MAX_NACHTEILIGE_EIGENSCHAFTEN_PUNKTE Punkte durch nachteilige Eigenschaften bekommen."
            println(mes)
            message += mes + "\n"
            legal = false
        }
        return Legal(legal, message)
    }

    private fun containsPart(name: String): Boolean {
        for (eigenschaft in eigenschaften.stream().map { it.name }) {
            if (name == eigenschaft) {
                return true
            }
        }

        if (name == feuermodus.name) {
            return true
        }

        if (name == kaliber.name) {
            return true
        }

        if (name == lauf.name) {
            return true
        }

        if (name == magazin.name) {
            return true
        }

        if (name == rahmen.name) {
            return true
        }

        if (name == schaft.name) {
            return true
        }

        return false
    }
}