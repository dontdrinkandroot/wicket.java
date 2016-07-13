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

public enum ColumnSizeSmall implements ColumnSize
{

	SIZE_1,
	SIZE_2,
	SIZE_3,
	SIZE_4,
	SIZE_5,
	SIZE_6,
	SIZE_7,
	SIZE_8,
	SIZE_9,
	SIZE_10,
	SIZE_11;

	private ColumnSizeSmall()
	{
	}

	@Override
	public String getClassString()
	{
		return String.format("col-%s-%d", this.getPrefix(), this.ordinal() + 1);
	}

	@Override
	public ColumnOffsetSmall getInverseColumnOffset()
	{
		return ColumnOffsetSmall.values()[10 - this.ordinal()];
	}

	@Override
	public ColumnSizeSmall getInverseColumnSize()
	{
		return ColumnSizeSmall.values()[10 - this.ordinal()];
	}

	protected String getPrefix()
	{
		return "sm";
	}
}
