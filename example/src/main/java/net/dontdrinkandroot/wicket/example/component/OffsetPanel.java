package net.dontdrinkandroot.wicket.example.component;

import java.util.Arrays;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.Model;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.ColumnOffset;


public class OffsetPanel extends GenericPanel<Void>
{

	private ColumnOffset[] values;


	public OffsetPanel(String id, ColumnOffset[] values)
	{
		super(id);
		this.values = values;
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		ListView<ColumnOffset> row = new ListView<ColumnOffset>("row", Arrays.asList(this.values)) {

			@Override
			protected void populateItem(ListItem<ColumnOffset> item)
			{
				ColumnOffset columnOffset = item.getModelObject();

				WebMarkupContainer container = new WebMarkupContainer("container");
				container.add(new CssClassAppender(columnOffset));
				container.add(new CssClassAppender(columnOffset.getInverseColumnSize()));
				item.add(container);

				Label offsetLabel = new Label("offsetLabel", Model.of(columnOffset.getClassString()));
				container.add(offsetLabel);

				Label columnLabel =
						new Label("columnLabel", Model.of(columnOffset.getInverseColumnSize().getClassString()));
				container.add(columnLabel);
			}
		};
		this.add(row);
	}

}
