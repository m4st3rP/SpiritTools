package waffe

fun main(args: Array<String>) {
    val teile = Teile()

    val eigenschaften = mutableListOf<Eigenschaft>()
    for (i in 6 until args.size) {
        eigenschaften.add(teile.eigenschaften[args[i].toInt()])
    }

    val waffe = Waffe(eigenschaften, teile.feuermodi[args[3].toInt()], teile.kaliber[args[1].toInt()], teile.laufarten[args[4].toInt()], teile.magazine[args[2].toInt()], teile.rahmen[args[0].toInt()], teile.schaftarten[args[5].toInt()])

    val waffeLegal = waffe.getWaffeLegal(teile.blacklists, teile.whitelists)
    if(waffeLegal.legal) {
        println("Last = " + waffe.getLast())
        println("Durchschlag = " + waffe.getDurchschlag())
        println("Eigenschaften = " + waffe.getEigenschaftenNamen())
        println("Feuermodus = " + waffe.getFeuermodus())
        println("Kaliber = " + waffe.getKaliber())
        println("Komplexität = " + waffe.getKomplexitaet())
        println("Schaden = " + waffe.getSchaden())
        println("Reichweite = " + waffe.getReichweite())
        println("Magazingröße = " + waffe.getMagazingroesse())
        println("Magazinart = " + waffe.getMagazinart())
        println("Preis = " + "%.2f".format(waffe.getPreis()))
        println("Punkte = " + waffe.getPunkte())

        println("Schwierigkeit des Angriff Bonus = " + waffe.getSchwierigkeitDesAngriffBonus())
        println("Einklappbar = " + waffe.getEinklappbar())
        println("Vollautomatische Salvenkugelanzahl = " + waffe.getVollautomatischeSalvenKugelanzahl())
        println("Schalldämpfer = " + waffe.getSchalldaempfer())
        println("Repetieren ist freie Handlung = " + waffe.getRepetierenIstFreieHandlung())
        println("Wartungs-/Reperaturbonus = " + waffe.getWartungsReperaturBonus())
        println("Anzahl Läufe = " + waffe.getLaeufeAnzahl())
        println("Ladehemmungen bei Patzer = " + waffe.getLadehemmungen())
        println("Spezialmagazin = " + waffe.getSpezialmagain())
        println("Robust = " + waffe.getRobust())
        println("Unrobust = " + waffe.getUnrobust())
        println("PING! (Lautes Geräusch beim Nachladen) = " + waffe.getGeraeuscheBeimNachladen())
    }
}

fun printParts(teile: Teile) {
    println("Rahmen:")
    for(i in 0 until teile.rahmen.size) {
        println(i.toString() + " = " + teile.rahmen[i].name)
    }
    println()

    println("Kaliber:")
    for(i in 0 until teile.kaliber.size) {
        println(i.toString() + " = " + teile.kaliber[i].name)
    }
    println()

    println("Magazine:")
    for(i in 0 until teile.magazine.size) {
        println(i.toString() + " = " + teile.magazine[i].name)
    }
    println()

    println("Feuermodi:")
    for(i in 0 until teile.feuermodi.size) {
        println(i.toString() + " = " + teile.feuermodi[i].name)
    }
    println()

    println("Laufarten:")
    for(i in 0 until teile.laufarten.size) {
        println(i.toString() + " = " + teile.laufarten[i].name)
    }
    println()

    println("Schaftarten:")
    for(i in 0 until teile.schaftarten.size) {
        println(i.toString() + " = " + teile.schaftarten[i].name)
    }
    println()

    println("Eigenschaften:")
    for(i in 0 until teile.eigenschaften.size) {
        println(i.toString() + " = " + teile.eigenschaften[i].name)
    }
    println()
}