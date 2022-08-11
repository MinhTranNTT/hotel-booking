$(document).ready(function() {
	
	$("#buttonCancel").on("click", function() {
		window.location = "[[@{/users}]]";
	});
	
	function checkEmailUnique(form) {
		url = "[[@{/users/check_email}]]";
		userEmail = $("#email").val();
		csrfValue = $("input[name='_csrf']").val();
		params = {email: userEmail, _csrf: csrfValue};
		
		$.post(url, params, function(response) {
			if (response == "OK") {
				form.submit();
			} else if (response == "Duplicated") {
				showModalDialog("Warning", "There is another user having the email " + userEmail);
			} else {
				showModalDialog("Error", "Unknown response from server");
			}
		}).fail(function() {
			showModalDialog("Error", "Could not connect to the server");
		});
		
		return false;
	}
	
	function showModalDialog(title, message) {
		$("#modalTitle").text(title);
		$("#modalBody").text(message);
		$("#modalDialog").modal();
	}
	
});