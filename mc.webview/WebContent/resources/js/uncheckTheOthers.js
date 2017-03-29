function uncheckTheOthers(checkbox, isSingleChoice, idComponent) {
	if(!isSingleChoice)
		return;

	var elements = checkbox.form.elements;
	var comparePrefix="singleAndMultipleChoice:answersList";
	var compareSufix="checkboxId";

	for (var i = 0; i < elements.length; i++) {
		var element = elements[i];
		if ((element.id.indexOf(comparePrefix)>-1) && (element.id.indexOf(compareSufix)>-1) && !(idComponent.indexOf(element.id)>-1))
		{

			element.checked = true;

		}
	}

};

function uncheckDummy(){


	var element=document.getElementById("dummyForm:dummyCheckbox_input");
	element.checked=false;
	document.getElementById("myCheck").checked = true;

};

function checkAll(isSingleChoice,checkbox)
{
	if(!isSingleChoice) {
		return;
	}		
	var checkboxes = new Array(); 
	checkboxes = document['takeQuestionForm'].getElementsByTagName('input');
	for (var i=0; i<checkboxes.length; i++)  {
		if (checkboxes[i].type == 'checkbox') {
			if(checkboxes[i].id.indexOf(checkbox.id)>-1){				 
				checkboxes[i].checked = true;
			}
			else 
				if(checkboxes[i].id.indexOf( checkbox.id.substring(0, checkbox.id.length-("answChck".length+2))) >-1)
					checkboxes[i].checked = false;
		}
	}
}

function checkAllIncludeBrowserType(isSingleChoice, questionIndex, answerId, checkbox) {
	console.log("checkAllIncludeBrowserType");
	if (isSingleChoice) {
		backBeanQuestionProcessing([{name:'questionIndexTakeQuiz', value:questionIndex},{name:'answerId', value:answerId}]);
		return;
	}
	
	// Internet Explorer 6-11
	var isIE = /*@cc_on!@*/false || !!document.documentMode;
	// Edge 20+
	var isEdge = !isIE && !!window.StyleMedia;
	if (isIE || isEdge) {
		backBeanQuestionProcessing([{name:'questionIndexTakeQuiz', value:questionIndex},{name:'answerId', value:answerId},{name:'answered', value:checkbox.checked}]);
	} else {
		backBeanQuestionProcessing([{name:'questionIndexTakeQuiz', value:questionIndex},{name:'answerId', value:answerId}]);
	}
}

function checkAllPF(isSingleChoice, checkbox) {
	if (!isSingleChoice) return;
	// get all PF checkbox elements under the same .answers element as @checkbox is
	$(checkbox).closest('.answers').find('.ui-chkbox').each(function(){
		var inputId = $(this)[0].id + "_input"; // PF checkbox id is constructed as ui-chkbox id + '_input'
		if ($(checkbox)[0].checked && inputId != $(checkbox)[0].id) {
			// if we checked @checkbox, we are unchecking all the others
			getCheckboxWidget($(this)[0].id).uncheck();
		}
	});
}

function getCheckboxWidget(id) {
	for (var propertyName in PrimeFaces.widgets) {
		var widget = PrimeFaces.widgets[propertyName];
		if (widget instanceof PrimeFaces.widget.SelectBooleanCheckbox && widget.id == id) {
	    	return widget;
		}
	}
}