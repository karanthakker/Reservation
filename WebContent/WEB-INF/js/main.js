function sendAjax(url,success,failure,selector){

	$('.alert-success').html('');
	$('.alert-error').html('');
	$('.alert-success').hide();
	$('.alert-error').hide();
	
	$.ajax({
		url: url,
		type: 'POST',
		dataType: 'html',
		data: $('form').serialize(),
		success: function(data) {
			
			if(data == 'success'){

				$('.alert-success').html(success);
				$('.alert-success').show();

				if(selector){
					setTimeout(function() {
						$('#' + selector).fadeOut("slow");
						$('.alert-success').fadeOut("slow");
					}, 3000);

				}

			}else{
				$('.alert-error').html(failure);
				$('.alert-error').show();
			}

		}

	});
}


$('.action').click(function(){

	var selector = $(this).attr('data-selector');
	var action = $(this).attr('data-action');
	var success = $(this).attr('data-success');
	var failure = $(this).attr('data-failure');
	var dataActiontype = $(this).attr('data-action-type');
	var borrowId = $(this).attr('data-id');

	sendAjax(action,success,failure,selector);
	
	if(dataActiontype == 'payment'){
		removeBorrowRow(borrowId);
	}
	
})

$('#create_user').click(function(){

	var username = $('#username').val();
	var password = $('#password').val();
	var confirmPassword = $('#confirmPassword').val();
	var address = $('#address').val();
	var email = $('#email').val();
	var role = $('.role:checked').val();

	$('.alert-success').html('');
	$('.alert-error').html('');
	$('.alert-success').hide();
	$('.alert-error').hide();
	
	if(username == '' || password == '' || confirmPassword == '' || address == '' || email == '' || typeof(role) == 'undefined'){
		$('.alert-error').append('All the fields are mandatory!');
		$('.alert-error').show();
		return false;
	}

	if(password != confirmPassword){
		$('.alert-error').append('Password does not match!');
		$('.alert-error').show();
		return false;
	}

	if(!isValidEmailAddress(email)){
		$('.alert-error').append('Enter a valid email address!');
		$('.alert-error').show();
		return false;
	}

	var action = $(this).attr('data-action');
	var success = $(this).attr('data-success');
	var failure = $(this).attr('data-failure');

	sendAjax(action,success,failure,false);
	return false;
})

$('#delete_user').click(function(){

	var username = $('#username').val();
	if(username == '' ){
		$('.alert-error').append('Username is mandatory!');
		$('.alert-error').show();
		return false;
	}

	var action = $(this).attr('data-action');
	var success = $(this).attr('data-success');
	var failure = $(this).attr('data-failure');

	sendAjax(action,success,failure,false);
	return false;
})

function isValidEmailAddress(emailAddress) {
	var pattern = new RegExp(/^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i);
	return pattern.test(emailAddress);
}