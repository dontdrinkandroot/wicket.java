package net.dontdrinkandroot.wicket.example.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Theme
{

	private String name;

	private String url;


	public Theme(String name, String url)
	{
		super();
		this.name = name;
		this.url = url;
	}

	public String getName()
	{
		return this.name;
	}

	public String getUrl()
	{
		return this.url;
	}

	public static List<Theme> getAvailableThemes()
	{
		String version = "3.3.6";
		List<Theme> availableThemes = new ArrayList<Theme>();
		availableThemes.add(
				new Theme(
						"Vanilla",
						String.format("https://maxcdn.bootstrapcdn.com/bootstrap/%s/css/bootstrap.min.css", version)));

		List<String> bootswatchThemeNames = Arrays.asList(
				new String[] {
						"Cerulean",
						"Cosmo",
						"Cyborg",
						"Darkly",
						"Flatly",
						"Journal",
						"Lumen",
						"Paper",
						"Readable",
						"Sandstone",
						"Simplex",
						"Slate",
						"Spacelab",
						"Superhero",
						"United",
						"Yeti", });

		for (String name : bootswatchThemeNames) {
			String url = String.format(
					"https://maxcdn.bootstrapcdn.com/bootswatch/%s/%s/bootstrap.min.css",
					version,
					name.toLowerCase());
			availableThemes.add(new Theme(name, url));
		}

		return availableThemes;
	}
}
