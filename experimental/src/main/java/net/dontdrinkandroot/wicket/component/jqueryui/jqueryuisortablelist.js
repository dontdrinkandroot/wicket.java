function initSortableList(markupId, wicketCallback, componentPath, placeholderClass, containment) {
	
	var selector = "#" + markupId + "";
	$(selector).sortable({
		
		start: function(event, ui) {
			$(this).data('oldPosition', ui.item.index());
			$(this).data('out', false);
		},
		
		containment: containment, 
		
		beforeStop: function(event, ui) {
			var componentPath = $(ui.helper).data('wicket.component.path');
			wicketCallback(
					$(this).data('oldPosition'),
					ui.item.index(),
					$(this).data('out'),
					componentPath);
		},
		
		items: 'li',
		
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