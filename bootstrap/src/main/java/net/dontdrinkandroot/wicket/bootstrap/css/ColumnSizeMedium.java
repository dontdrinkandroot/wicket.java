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

public enum ColumnSizeMedium implements ColumnSize
{

	COLUMNS_1,
	COLUMNS_2,
	COLUMNS_3,
	COLUMNS_4,
	COLUMNS_5,
	COLUMNS_6,
	COLUMNS_7,
	COLUMNS_8,
	COLUMNS_9,
	COLUMNS_10,
	COLUMNS_11,
	COLUMNS_12;

	private ColumnSizeMedium()
	{
	}

	@Override
	public String getClassString()
	{
		return String.format("col-%s-%d", this.getPrefix(), this.ordinal() + 1);
	}

	@Override
	public ColumnOffsetMedium getInverseColumnOffset()
	{
		if (this.ordinal() >= 11) {
			return null;
		}
		return ColumnOffsetMedium.values()[10 - this.ordinal()];
	}

	@Override
	public ColumnSizeMedium getInverseColumnSize()
	{
		if (this.ordinal() >= 11) {
			return null;
		}
		return ColumnSizeMedium.values()[10 - this.ordinal()];
	}

	protected String getPrefix()
	{
		return "md";
	}
}