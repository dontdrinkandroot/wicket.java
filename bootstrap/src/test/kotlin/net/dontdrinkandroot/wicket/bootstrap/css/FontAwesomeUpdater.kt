package net.dontdrinkandroot.wicket.bootstrap.css

import net.dontdrinkandroot.wicket.bootstrap.headeritem.FONTAWESOME_VERSION
import org.yaml.snakeyaml.Yaml
import java.io.IOException
import java.net.URL
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

class FontAwesomeUpdater {

    @Throws(IOException::class)
    fun run() {
        val yaml = Yaml()
        val loadedYaml = yaml.load(
            URL(
                java.lang.String.format(
                    "https://raw.githubusercontent.com/FortAwesome/Font-Awesome/v%s/src/icons.yml",
                    FONTAWESOME_VERSION
                )
            ).openStream()
        ) as Map<*, *>
        val icons: MutableList<Icon> = ArrayList()
        val iconMaps: List<Map<*, *>> = loadedYaml["icons"] as List<Map<*, *>>
        val versionFormatter: NumberFormat = DecimalFormat("#0.0")
        for (iconMap in iconMaps) {
            val icon = Icon(
                id = iconMap["id"] as String,
                name = iconMap["name"] as String,
                version = versionFormatter.format(iconMap["created"])
            )
            icons.add(icon)
        }
        icons.sortWith(Comparator.comparing { obj: Icon -> obj.enumName })
        for (icon in icons) {
            println(
                String.format(
                    "%s(\"%s\", \"%s\",\"%s\"),",
                    icon.enumName,
                    icon.classString,
                    icon.name,
                    icon.version
                )
            )
        }
    }

    companion object {

        @Throws(IOException::class)
        @JvmStatic
        fun main(args: Array<String>) {
            val updater = FontAwesomeUpdater()
            updater.run()
        }
    }
}

internal class Icon(val id: String, val name: String, val version: String) {

    val enumName: String
        get() {
            var enumName = id.toUpperCase().replace("-", "_")
            enumName = enumName.replace("500PX", "FIVEHUNDRED_PX")
            return enumName
        }

    val classString: String
        get() = "fa-" + id
}