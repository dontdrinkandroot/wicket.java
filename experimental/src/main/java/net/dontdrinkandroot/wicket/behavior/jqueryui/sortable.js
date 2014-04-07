/*
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
function initSortable(markupId, wicketCallback, componentPath, itemSelector, placeholderClass, containment) {
	
	var selector = "#" + markupId + "";
	$(selector).sortable({
		
		start: function(event, ui) {
			$(this).data('oldPosition', ui.item.index());
			$(this).data('out', false);
		},
		
		containment: containment, 
		
		beforeStop: function(event, ui) {
			wicketCallback(
					$(this).data('oldPosition'),
					ui.item.index(),
					$(this).data('out'),
					$(ui.helper).data('wicket.component.path'));
		},
		
		items: itemSelector,
		
		out: function(event, ui) {
			$(this).data('out', true)
		},
		
		placeholder: placeholderClass,
		
		helper: function(event, ui) {
			ui.data('wicket.component.path', componentPath);
			return ui;
		},
		
		over: function(event, ui) {
			$(this).data('out', false)
		}
	});
}