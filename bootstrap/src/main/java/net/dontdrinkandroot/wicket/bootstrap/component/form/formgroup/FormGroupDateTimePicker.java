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
package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup;

import java.util.Date;

import org.apache.wicket.model.IModel;

import net.dontdrinkandroot.wicket.bootstrap.component.form.DateTimePicker;


public class FormGroupDateTimePicker extends AbstractFormGroup<Date, DateTimePicker>
{

	private final int maxYear;

	private final int minYear;


	public FormGroupDateTimePicker(String id, IModel<Date> model, String label, int minYear, int maxYear)
	{
		super(id, model, label);
		this.minYear = minYear;
		this.maxYear = maxYear;
	}

	@Override
	protected DateTimePicker createFormComponent(String id)
	{
		return new DateTimePicker(id, this.getModel(), this.minYear, this.maxYear);
	}

}
