/**
 * Copyright (C) 2012-2014 Philip W. Sorst <philip@sorst.net>
 * and individual contributors as indicated
 * by the @authors tag.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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