function deleteRows() {
	var checkboxes = document.querySelectorAll('input[type="checkbox"]:checked');
	var checkboxesNot = document.querySelectorAll('input[type="checkbox"]:not(:checked)');
	console.log(checkboxes);
	var selectedValues = [];
	for (var i = 1; i < checkboxes.length; i++) {
		 if (checkboxes[i].checked) {
	  		selectedValues.push(checkboxes[i].value);
		} 
	}
	if (checkboxesNot.length == checkboxes.length){
		 selectedValues.shift();
	}
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
	  if (this.readyState == 4 && this.status == 200) {
	    console.log(this.responseText);
	  }
	};
	xhttp.open("POST", "/CustomerSystem_Servlet_Jsp/T002", true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send("selectedValues=" + JSON.stringify(selectedValues));
} 

function deleteData() {
	  var checkboxes = document.getElementsByName("checkboxAll");
	  var selectedIds = [];
	  for (var i = 0; i < checkboxes.length; i++) {
	    if (checkboxes[i].checked) {
	      selectedIds.push(checkboxes[i].value);
	    }
	  }
	  if (selectedIds.length > 0) {
	    var xhr = new XMLHttpRequest();
	    xhr.open("POST", "/CustomerSystem_Servlet_Jsp/T002", true);
	    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	    xhr.onreadystatechange = function() {
	      if (xhr.readyState == 4 && xhr.status == 200) {
	        // Xóa thành công, cập nhật lại dữ liệu trên trang hiện tại
	        location.reload();
	      }
	    }
	    xhr.send("ids=" + selectedIds.join(","));
	  }
	}
	checkBox = (source) => {
		var checkBoxAll = document.getElementsByName("checkboxAll");
		for (var i = 0; i < checkBoxAll.length; i++) {
			checkBoxAll[i].checked = source.checked;
		}
	}
	
	function sendPostRequest(page) {
	  var xhr = new XMLHttpRequest();
	  xhr.open("POST", "/CustomerSystem_Servlet_Jsp/T002");
	  xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	  xhr.onreadystatechange = function() {
	    if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
	      // Xử lý phản hồi trả về từ máy chủ nếu cần
	    }
	  };
	  var data = "pagepage=" + encodeURIComponent(page);
	  xhr.send(data);
	}

	
	function validateForm() {
	  var dataTo = document.getElementById("dataTo").value;
	  var checkBirthdayFrom = document.getElementById("checkBirthdayFrom").value;
	  var checkBirthdayTo = document.getElementById("checkBirthdayTo").value;
	  var messageErrorTo = document.getElementById("messageErrorTo").value;
	  var messageErrorFrom = document.getElementById("messageErrorFrom").value;
	  var checkerrFromTo = document.getElementById("messageErrorFromBiggerTo").value;
  	console.log(checkBirthdayFrom);
  	
	  if (checkBirthdayFrom != null) { // Thêm điều kiện kiểm tra chuỗi khác rỗng
	    alert(checkBirthdayFrom);
	  } 
	
	  if (checkBirthdayTo != null) { // Thay messageTo bằng checkBirthdayTo
	    alert(checkBirthdayTo);
	  }
	
	  if (checkerrFromTo != null) { // Thêm điều kiện kiểm tra chuỗi khác rỗng
	    alert(checkerrFromTo);
	  }
}
