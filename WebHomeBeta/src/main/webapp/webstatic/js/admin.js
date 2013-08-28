var ADMIN = {
	
	esqueciMinhaSenha: function() {
		//ajusta footer na parte inferior do site
		var heightPage = $(window).height();
		
		if(heightPage > 550) {
			$('#main-forgotPassword').css('height', heightPage - 40);
		}
	},
	
	onClickItemMenu: function(e) {
		e.preventDefault();
		$(this).next('.sub-menu').fadeToggle();
	},
	
	onDeleteBloco: function(e) {
		e.preventDefault();
		var idBloco = $(this).attr('data-id');

		$.ajax({
			url: 'cadastro/delete',
			type: 'POST',
			data: {id-bloco: idBloco},
			success: function(data) {
				console.log('JSON = ', data);
			}
		});
	}
}

$(function() {
	//valida se está na página de cadastro
	if($('#forgotPassword-view')[0]){
		ADMIN.esqueciMinhaSenha();
	}
	
	$('#list-user-register .link').on('click', function(e) {
		e.preventDefault();
		var user = $(this).find('a').attr('data-link');
		
		$("#loginEdit").attr("value", user);
		
		$("#frmEditarCadastro").submit();
	});
	
	$('.title-menu-drop').on('click', ADMIN.onClickItemMenu);
	
	$('.btn-delete-bloco').on('click', ADMIN.onDeleteBloco);
});