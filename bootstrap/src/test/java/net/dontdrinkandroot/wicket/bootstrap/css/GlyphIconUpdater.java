package net.dontdrinkandroot.wicket.bootstrap.css;

import net.dontdrinkandroot.wicket.bootstrap.headeritem.BootstrapJsHeaderItem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class GlyphIconUpdater
{
    public static void main(String[] args) throws IOException
    {
        GlyphIconUpdater updater = new GlyphIconUpdater();
        updater.update();
    }

    private void update() throws IOException
    {
        URL lessUrl = new URL(String.format(
                "https://raw.githubusercontent.com/twbs/bootstrap/v%s/less/glyphicons.less",
                BootstrapJsHeaderItem.BOOTSTRAP_VERSION
        ));

        //        Pattern pattern = Pattern.compile("\\.glyphicon-([^\\s]*)");
        Pattern pattern = Pattern.compile("(.*)\\.glyphicon-([^\\s]*)(.*)");

        InputStream inputStream = lessUrl.openStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line = reader.readLine();
        while (null != line) {
            //            System.out.println(line);
            Matcher matcher = pattern.matcher(line);
            if (matcher.matches()) {
                String css = matcher.group(2);
                String name = css.replace("-", "_").toUpperCase();
                //                System.out.println(css);
                //                System.out.println(name);
                System.out.println(name + "(\"glyphicon-" + css + "\"),");
            }
            line = reader.readLine();
        }
    }
}
