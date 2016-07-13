package net.dontdrinkandroot.wicket.example.component;

import java.util.Arrays;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.Model;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.ColumnSize;


public class ColumnPanel extends GenericPanel<ColumnSize>
{

	private ColumnSize[] values;


	public ColumnPanel(String id, ColumnSize[] values)
	{
		super(id);
		this.values = values;
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		ListView<ColumnSize> row = new ListView<ColumnSize>("row", Arrays.asList(this.values)) {

			@Override
			protected void populateItem(ListItem<ColumnSize> item)
			{
				ColumnSize columnSize = item.getModelObject();
				WebMarkupContainer left = new WebMarkupContainer("left");
				this.add(left);
				Label leftLabel = new Label("label", Model.of(columnSize.getClassString()));
				left.add(leftLabel);
				left.add(new CssClassAppender(columnSize));
				item.add(left);

				WebMarkupContainer right = new WebMarkupContainer("right");
				this.add(right);
				Label rightLabel = new Label("label", Model.of(columnSize.getInverseColumnSize().getClassString()));
				right.add(rightLabel);
				right.add(new CssClassAppender(columnSize.getInverseColumnSize()));
				item.add(right);
			}
		};
		this.add(row);
	}

}
