var prefix = 'api/convert';
var amount;
var source;
var target;
var sourceSelect;
var targetSelect;
 
    var convert = function() {
    	sourceSelect = document.getElementsByName('source_currency')[0];
    	source = sourceSelect.options[sourceSelect.selectedIndex].value;
    	
    	targetSelect = document.getElementsByName('target_currency')[0];
    	target = targetSelect.options[targetSelect.selectedIndex].value;
    	
    	amount = document.getElementsByName('amount_field')[0].value;
    	if (amount == '') {
    		amount = 0;
    	}
    	
        $.ajax({
            type: 'GET',
            url:  prefix + '/' + amount + '/' + source + '/' + target,
            dataType: 'json',
            async: true,
            success: function(result) {
                document.getElementsByName('result_field')[0].value = result;
            },
            error: function(jqXHR, textStatus, errorThrown) {
            	document.getElementsByName('result_field')[0].value = 'internal error occurred';;
            }
        });
    } 