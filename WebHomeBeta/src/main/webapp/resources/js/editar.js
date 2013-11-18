var EDITAR_PERFIL  = {
	
	//coordenadas do JCROP da imagem editada
	CX: 0,
	CY: 0,
	CW: 243,
	CH: 243,
		
	alterarFoto: function(e) {
		var foto = $('#image').val();
		
		$('#container-foto').html('<img src="/WebHomeBeta/img/load-login.gif" id="loadFoto" alt="carregando foto"/> ');
  		$('#cortarImagem').hide();
  		$('#editarFoto').css({
  			'width': 'auto',
  			'height': 'auto'
  		});
  		$('#myModal').modal('show');
		//$('#editarFoto').modal();
		
		var larguraModal = 700,
			alturaModal = 500,
			largura = '',
			altura = '',
			larguraFinal = '',
			alturaFinal = '';
		
		$("#trocarFoto").ajaxForm({
			
			//rancar fora e ALTERAR O TAMANHO DA MODAL DE ACORDO COM A FOTO
			success:function(data) {
				
				data = data.split(',');
				largura = parseInt(data[1], 10);
				altura = parseInt(data[2], 10);
				
				 $('.modal-dialog').css({
					 'max-width': largura + 80,
					 'height': altura + 20
				 });
				 
				 $('#cortarImagem').show();
				 $('#cortarImagem').css('left', largura/2);
				 $('#container-foto').html('<img src="'+data[0]+'" id="imageUser" />');
		         
		         
		         EDITAR_PERFIL.JcropInit();         
		         
		     },
		     dataType:"text"
		   }).submit();
	},
	
	JcropInit: function() {
		$('#imageUser').Jcrop({
			onSelect: EDITAR_PERFIL.showCoords,
			onChange: EDITAR_PERFIL.showCoords,
            minSize: [243,243],
            aspectRatio: 1
		});
	},
	
	showCoords: function(c) {
		EDITAR_PERFIL.CX = c.x;
		EDITAR_PERFIL.CY = c.y;
		EDITAR_PERFIL.CW = c.w;
		EDITAR_PERFIL.CH = c.h;
	 },
	 
	 cortarFoto: function(e) {
		 console.log('aaaa');
		 
		 e.preventDefault();
		 var data = 'x1='+EDITAR_PERFIL.CX+'&y1='+EDITAR_PERFIL.CY+'&w='+EDITAR_PERFIL.CW+'&h='+EDITAR_PERFIL.CH;
		 $.ajax({
		    	type: 'post',
		    	data: data,
		      	url:'/WebHomeBeta/cropAndUpload',
		      	success: function(e) {
		      		$('#thumb-photo').attr('src', e);
		      		$('.close').trigger('click');	    
		      	},
		      	error: function(erro) {
		      		console.log('---erro = ',erro);
		      	}

		    });
	 },
	 
	 abrirAlterarSenha: function(e) {
		 
		 e.preventDefault();
		 $('#content-alterar-senha').toggle();
		 
	 }
}

$(function() {
	console.log('editar js');
	//$('#dataNascimento').numeric();
	//$('#dataNascimento').mask("99/99/9999",{placeholder:" "});
	
	//alterar foto do usuário
	$('#alterarFoto').on('click', EDITAR_PERFIL.alterarFoto);
	
	//Quando clica em cortar foto
	$('body #cortarImagem').on('click', EDITAR_PERFIL.cortarFoto);
	
	$('#btn-alterar-senha').on('click', EDITAR_PERFIL.abrirAlterarSenha);
});