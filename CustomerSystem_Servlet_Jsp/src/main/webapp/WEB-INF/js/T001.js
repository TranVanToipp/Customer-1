var btnClear = document.getElementById("btnClear");
	btnClear.addEventListener('click', (event) => {
		event.preventDefault();
		document.getElementById("txtUserID").value = "";
		document.getElementById("txtPassword").value = "";
		document.getElementById("lblErrorMessage").innerHTML = "";
	});

	function checkInput () {
			var user = document.getElementById("txtUserID").value;
			var pass = document.getElementById("txtPassword").value;
			if (user == "") {
				document.getElementById("lblErrorMessage").innerHTML = '<%=errorMessage%>';
				return false;
			}
			if (pass == "") {
				document.getElementById("lblErrorMessage").innerHTML = "パスワードを入力してください。";
				return false;
			}
			return true;
		
	}