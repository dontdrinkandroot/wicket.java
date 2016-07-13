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

public enum ColumnOffsetLarge implements ColumnOffset
{

	OFFSET_1,
	OFFSET_2,
	OFFSET_3,
	OFFSET_4,
	OFFSET_5,
	OFFSET_6,
	OFFSET_7,
	OFFSET_8,
	OFFSET_9,
	OFFSET_10,
	OFFSET_11;

	private ColumnOffsetLarge()
	{
	}

	@Override
	public String getClassString()
	{
		return String.format("col-%s-offset-%d", this.getPrefix(), this.ordinal() + 1);
	}

	@Override
	public ColumnSizeLarge getInverseColumnSize()
	{
		return ColumnSizeLarge.values()[10 - this.ordinal()];
	}

	@Override
	public ColumnOffsetLarge getInverseColumnOffset()
	{
		return ColumnOffsetLarge.values()[10 - this.ordinal()];
	}

	protected String getPrefix()
	{
		return "xs";
	}
}
