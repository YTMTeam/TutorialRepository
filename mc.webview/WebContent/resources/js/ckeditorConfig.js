CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here.
	config.extraPlugins = 'lineutils,widget,mathjax';
	config.removePlugins = 'elementspath';
	config.resize_dir = 'both';
	//config.resize_enabled = false;
	config.toolbarStartupExpanded = true; 
	config.toolbarCanCollapse = true;
	config.resize_minHeight = 100;
	config.height = 100; 
	config.toolbar = [
                  	{ name: 'clipboard', groups: [ 'clipboard', 'undo' ], items: [ 'Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord', '-', 'Undo', 'Redo' ] },
                  	{ name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ], items: [ 'Bold', 'Italic', 'Underline', 'Strike', 'Subscript', 'Superscript', '-', 'RemoveFormat' ] }, 
					'/',
                  	{ name: 'paragraph', groups: [ 'list', 'indent', 'blocks', 'align', 'bidi' ], items: [ 'NumberedList', 'BulletedList', '-', 'Outdent', 'Indent', '-', 'Blockquote', '-', 'JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock', '-', 'BidiLtr', 'BidiRtl' ] },
                  	{ name: 'insert', items: [ 'Image',  'Mathjax', 'Table', 'HorizontalRule', 'SpecialChar', 'PageBreak' ] },
                  	'/',
                  	{ name: 'styles', items: [ 'Styles', 'Format', 'Font', 'FontSize' ] },
                  	{ name: 'colors', items: [ 'TextColor', 'BGColor' ] },
                  	{ name: 'tools', items: [ 'Maximize', 'ShowBlocks' ] },
                  ];

};

