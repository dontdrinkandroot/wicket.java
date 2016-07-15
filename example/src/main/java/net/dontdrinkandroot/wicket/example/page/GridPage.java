package net.dontdrinkandroot.wicket.example.page;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnOffsetExtraSmall;
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnOffsetLarge;
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnOffsetMedium;
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnOffsetSmall;
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnSizeExtraSmall;
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnSizeLarge;
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnSizeMedium;
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnSizeSmall;
import net.dontdrinkandroot.wicket.example.component.ColumnPanel;
import net.dontdrinkandroot.wicket.example.component.OffsetPanel;


public class GridPage extends DecoratorPage<Void>
{

	@Override
	protected IModel<String> createPageHeadingModel()
	{
		return Model.of("The Grid");
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		ColumnPanel xsColumns = new ColumnPanel("xsColumns", ColumnSizeExtraSmall.values());
		this.add(xsColumns);

		ColumnPanel smColumns = new ColumnPanel("smColumns", ColumnSizeSmall.values());
		this.add(smColumns);

		ColumnPanel mdColumns = new ColumnPanel("mdColumns", ColumnSizeMedium.values());
		this.add(mdColumns);

		ColumnPanel lgColumns = new ColumnPanel("lgColumns", ColumnSizeLarge.values());
		this.add(lgColumns);

		OffsetPanel xsOffsets = new OffsetPanel("xsOffsets", ColumnOffsetExtraSmall.values());
		this.add(xsOffsets);

		OffsetPanel smOffsets = new OffsetPanel("smOffsets", ColumnOffsetSmall.values());
		this.add(smOffsets);

		OffsetPanel mdOffsets = new OffsetPanel("mdOffsets", ColumnOffsetMedium.values());
		this.add(mdOffsets);

		OffsetPanel lgOffsets = new OffsetPanel("lgOffsets", ColumnOffsetLarge.values());
		this.add(lgOffsets);
	}
}
