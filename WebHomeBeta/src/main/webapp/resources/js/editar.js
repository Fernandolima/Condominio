var EDITAR_PERFIL  = {
		
	alterarFoto: function(e) {
		
		e.preventDefault();
		$('#alterarFoto').hide();
		$('#editarFoto').show();
	}
}

$(function() {
	
	//alterar foto do usu�rio
	$('#alterarFoto').on('click', EDITAR_PERFIL.alterarFoto);
});