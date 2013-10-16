package net.dontdrinkandroot.wicket.bootstrap.css;

import java.util.Arrays;
import java.util.List;

import net.dontdrinkandroot.wicket.css.CssClass;


public class CombinedColumnSize implements CssClass {

	private final List<ColumnSize> columnSizes;


	public CombinedColumnSize(ColumnSize... columnSizes) {

		this.columnSizes = Arrays.asList(columnSizes);
	}


	@Override
	public String getClassString() {

		StringBuffer sb = new StringBuffer();
		int count = 0;
		for (ColumnSize columnSize : this.columnSizes) {
			sb.append(columnSize.getClassString());
			count++;
			if (count < this.columnSizes.size()) {
				sb.append(" ");
			}
		}

		return sb.toString();
	}

}
