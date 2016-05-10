package net.dontdrinkandroot.wicket.bootstrap.css;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import com.esotericsoftware.yamlbeans.YamlReader;


public class FontAwesomeEnumGenerator
{

	public static void main(String[] args) throws IOException
	{
		InputStream inputStream = FontAwesomeEnumGenerator.class.getClassLoader().getResourceAsStream("icons.yml");

		YamlReader reader = new YamlReader(new InputStreamReader(inputStream));
		List iconList = (List) reader.read(Map.class).get("icons");

		iconList.sort(new Comparator<Object>() {

			@Override
			public int compare(Object o1, Object o2)
			{
				Map icon1 = (Map) o1;
				Map icon2 = (Map) o2;
				String id1 = (String) icon1.get("id");
				String id2 = (String) icon2.get("id");

				return id1.compareTo(id2);
			}
		});

		for (Object iconObject : iconList) {
			Map icon = (Map) iconObject;
			String id = (String) icon.get("id");
			String created = (String) icon.get("created");

			System.out.println(
					String.format("%s(\"fa-%s\", \"%s\"),", id.replace("-", "_").toUpperCase(), id, created));
		}
	}

}
