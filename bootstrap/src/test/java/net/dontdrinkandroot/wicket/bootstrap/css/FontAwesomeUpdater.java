package net.dontdrinkandroot.wicket.bootstrap.css;

import net.dontdrinkandroot.wicket.bootstrap.headeritem.FontAwesomeCssHeaderItem;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class FontAwesomeUpdater
{
    public static void main(String args[]) throws IOException
    {
        FontAwesomeUpdater updater = new FontAwesomeUpdater();
        updater.run();
    }

    public void run() throws IOException
    {
        Yaml yaml = new Yaml();
        Map loadedYaml =
                (Map) yaml.load(new URL(
                        String.format(
                                "https://raw.githubusercontent.com/FortAwesome/Font-Awesome/v%s/src/icons.yml",
                                FontAwesomeCssHeaderItem.VERSION
                        )).openStream());

        List<Icon> icons = new ArrayList<>();

        List<Map> iconMaps = (List) loadedYaml.get("icons");
        NumberFormat versionFormatter = new DecimalFormat("#0.0");
        for (Map iconMap : iconMaps) {
            Icon icon = new Icon();
            icon.name = (String) iconMap.get("name");
            icon.id = (String) iconMap.get("id");
            icon.version = versionFormatter.format(iconMap.get("created"));
            icons.add(icon);
        }
        icons.sort(Comparator.comparing(Icon::getEnumName));

        for (Icon icon : icons) {
            System.out.println(
                    String.format(
                            "%s(\"%s\", \"%s\",\"%s\"),",
                            icon.getEnumName(),
                            icon.getClassString(),
                            icon.name,
                            icon.version
                    ));
        }
    }
}

class Icon
{
    public String id;

    public String name;

    public String version;

    public String getEnumName()
    {
        String enumName = this.id.toUpperCase().replace("-", "_");
        enumName = enumName.replace("500PX", "FIVEHUNDRED_PX");
        return enumName;
    }

    public String getClassString()
    {
        return "fa-" + this.id;
    }
}
