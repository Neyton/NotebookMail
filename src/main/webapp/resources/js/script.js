$(function(){

    $('#btn-add').click(function(){
        // declare variable
        var _name = $('input[name="name"]').val();
        var _address = $('input[name="email"]').val();
        var _tr = '<tr><td>'+ _name +'</td> <td>'+_address+'</td><td><button type="button" class="btn btn-primary pull-right btn-send">Выбрать</button></td></tr>';
        $('tbody').append(_tr);
    });

    var _trEdit = null;

	$(document).on('click', '.btn-send',function(){
		_trEdit = $(this).closest('tr');
		var _name = $(_trEdit).find('td:eq(0)').text();
		var _address = $(_trEdit).find('td:eq(1)').text();
		
		$('input[name="name-send"]').val(_name);
		$('input[name="email-send"]').val(_address);
	}); 
});