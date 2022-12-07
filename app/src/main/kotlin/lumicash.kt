package lumitel

fun getInput(): Int {
    val a: Int = readln().toInt()
    return a
}

class HomeScreen {
    // Home screen
    fun init() {
        println(
                "Lumicash - muhitemwo:\n1. Kurungika\n2. Kubikura\n3. Kugura ama inite\n4. Kuriha fagitire\n5. Kuriha umudandaza\n6. Ibikorwa vya banki\n7. OBR\n8. Mairie\n9. Ifumbire\n10. Serivisi\n"
        )

        val x = getInput()

        selectChoice(x)
    }

    fun selectChoice(x: Int) {
        when (x) {
            0 -> init()
            1 -> Kurungika().firstStep()
            2 -> println("Kubikura")
            3 -> println("Kugura ama inite")
            4 -> println("Kuriha fagitire")
            5 -> println("Kuriha umudandaza")
            6 -> println("Ibikorwa vya banki")
            7 -> println("OBR")
            8 -> println("Mairie")
            9 -> println("Ifumbire")
            10 -> println("Serivisi")
            else -> println("\nNo choice")
        }
    }
}

class Kurungika {
    // Step to add destination number
    fun firstStep() {
        println("\nShiremwo inomero ya terefone:\n0. Gusubira inyuma\n")

        val x = getInput()

        val pattern = Regex("^[0-9]{8}$")
        if (x == 0) {
            HomeScreen().init()
        } else if (pattern.matches(x.toString())) {
            secondStep()
        } else if (!pattern.matches(x.toString())) { 
			println("\nNuméro invalide")
			firstStep()
		} else println("\nNo choice")
    }

    // Step to add the amount
    fun secondStep() {
        println("\nShiremwo igitigiri c'amahera:\n0. Gusubira inyuma\n")

        val x = getInput()

        val pattern = Regex("^[0-9]{4,7}$")

        if (x == 0) {
            firstStep()
        } else if (pattern.matches(x.toString())) {
            thirdStep()
        } else if (!pattern.matches(x.toString())) {
			println("\nNtimushobora kurungika amahera ari musi y'igihumbi canke ashika imiliyoni cumi\n")
			secondStep()
		} else println("\nNo choice")
    }

    // Step to add the amount
    fun thirdStep() {
        println("\nShiremwo ivy'iri rungikwa ry'amahera:\n0. Gusubira inyuma\n")

        val x = readln()

        if (x.contains("0") && x.length == 1) {
            secondStep()
        } else fourthStep()
    }

    fun fourthStep() {
        println("\nShiremwo kode PIN\n0. Gusubira inyuma\n")

        val x = getInput()

        val pattern = Regex("^[0-9]{4}$")

        if (x.toString().contains("0") && x.toString().length == 1) {
            thirdStep()
        } else if (pattern.matches(x.toString())) {
            finalStep()
        } else println("\nNo choice")
    }

    fun finalStep() {
        println(
                "\nKwemeza: Kurungika amahera 200 FBU aja kuri Ineza Ange Fleurisse, 61004331 ya kurungika, amahera bitwara: 0 FBU,\nHitemwo:\n1. Ego\n2. Oya\n"
        )

        val x = getInput()

        when (x) {
            1 -> println("\nIvyo mwasavye vyakunze, raba ubutumwa.")
            2 -> println("\nOops")
            else -> println("\nNo choice")
        }
    }
}

fun main() {
    HomeScreen().init()
}
