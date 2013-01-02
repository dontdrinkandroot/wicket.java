package net.dontdrinkandroot.wicket.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.model.AbstractReadOnlyModel;


/**
 * A readonly List Model that contains all Integers between the given min and max value, min and max
 * included.
 * 
 * @author Philip W. Sorst <philip@sorst.net>
 * 
 */
public class IntegerRangeListModel extends AbstractReadOnlyModel<List<Integer>> {

	private List<Integer> list;

	private int min;

	private int max;


	public IntegerRangeListModel(int min, int max) {

		this.min = min;
		this.max = max;
		this.updateList();
	}


	public void setMin(int min) {

		this.min = min;
		this.updateList();
	}


	public void setMax(int max) {

		this.max = max;
		this.updateList();
	}


	private void updateList() {

		this.list = new ArrayList<Integer>();
		for (int i = this.min; i <= this.max; i++) {
			this.list.add(Integer.valueOf(i));
		}

	}


	public int getMin() {

		return this.min;
	}


	public int getMax() {

		return this.max;
	}


	@Override
	public List<Integer> getObject() {

		return this.list;
	}

}
