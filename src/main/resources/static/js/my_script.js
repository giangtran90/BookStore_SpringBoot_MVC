// hiển thị detai book
function detail(bookId) {
	$.ajax({
		url: 'findBookById/' + bookId, // URL endpoint cho request get
		type: 'GET', // Phương thức HTTP GET
		data: { id: bookId }, // Dữ liệu gửi đi (có thể là id của item)
		success: function(response) {
			// Xử lý kết quả trả về từ server nếu cần
			alert("Customer Detail: id= " + response.id + " name= " + response.name);
		},
		error: function(xhr, status, error) {
			// Xử lý lỗi nếu có
			console.error('Failed: ' + error);
		}
	});
}

// delete book
function deleteBook(bookId) {
	event.preventDefault();
	$.ajax({
		url: 'deleteBook/' + bookId, // URL endpoint cho request delete
		type: 'DELETE', // Phương thức HTTP DELETE
		data: { id: bookId }, // Dữ liệu gửi đi (có thể là id của item cần xóa)
		success: function(response) {
			// Xử lý kết quả trả về từ server nếu cần
			console.log('Delete successful');
			window.location.href = 'my_books';
		},
		error: function(xhr, status, error) {
			// Xử lý lỗi nếu có
			console.error('Failed: ' + error);
		}
	});
}