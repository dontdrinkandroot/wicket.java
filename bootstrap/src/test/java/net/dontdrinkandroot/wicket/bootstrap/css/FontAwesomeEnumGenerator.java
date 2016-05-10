package net.dontdrinkandroot.wicket.bootstrap.css;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;

import com.esotericsoftware.yamlbeans.YamlReader;


@Ignore
public class FontAwesomeEnumGenerator
{

	public static void main(String[] args) throws IOException
	{
		URL iconUrl = new URL("https://raw.githubusercontent.com/FortAwesome/Font-Awesome/master/src/icons.yml");
		BufferedReader urlReader = new BufferedReader(new InputStreamReader(iconUrl.openStream()));
		try {

			YamlReader yamlReader = new YamlReader(urlReader);
			@SuppressWarnings("unchecked")
			List<Object> iconList = (List<Object>) yamlReader.read(Map.class).get("icons");

			iconList.sort(new Comparator<Object>() {

				@Override
				public int compare(Object o1, Object o2)
				{
					@SuppressWarnings("unchecked")
					Map<String, String> icon1 = (Map<String, String>) o1;
					@SuppressWarnings("unchecked")
					Map<String, String> icon2 = (Map<String, String>) o2;
					String id1 = icon1.get("id");
					String id2 = icon2.get("id");

					return id1.compareTo(id2);
				}
			});

			for (Object iconObject : iconList) {
				@SuppressWarnings("unchecked")
				Map<String, String> icon = (Map<String, String>) iconObject;
				String id = icon.get("id");
				String created = icon.get("created");

				System.out.println(
						String.format("%s(\"fa-%s\", \"%s\"),", id.replace("-", "_").toUpperCase(), id, created));
			}
		} finally {
			urlReader.close();
		}
	}

}
