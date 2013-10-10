var EDITAR_PERFIL  = {
	
	//coordenadas do JCROP da imagem editada
	CX: 0,
	CY: 0,
	CW: 243,
	CH: 243,
		
	alterarFoto: function(e) {
		var foto = $('#image').val();
		
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
				
				 $('#editarFoto').css({
					 'width': largura,
					 'height': altura
				 });
				 $('#cortarImagem').css('left', largura/2);
				 $('#container-foto').html('<img src="'+data[0]+'" id="imageUser" />');
		         $('#editarFoto').modal({
		             escapeClose: false,
		             clickClose: false,
		             showClose: true
		         });
		         
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
            maxSize: [300,300],
            aspectRatio: 1
		});
	},
	
	showCoords: function(c) {
		EDITAR_PERFIL.CX = c.x;
		EDITAR_PERFIL.CY = c.y;
		EDITAR_PERFIL.CW = c.w;
		EDITAR_PERFIL.CH = c.h;
	 },
	 
	 cortarFoto: function() {
		 var data = 'x1='+EDITAR_PERFIL.CX+'&y1='+EDITAR_PERFIL.CY+'&w='+EDITAR_PERFIL.CW+'&h='+EDITAR_PERFIL.CH;
		 $.ajax({
		    	type: 'post',
		    	data: data,
		      	url:'cropAndUpload',
		      	success: function(e) {
		      		$('#thumb-photo').attr('src', e);
		      		$('.close-modal').trigger('click');
		      	}

		    });
	 }
}

$(function() {
	
	//alterar foto do usu�rio
	$('#alterarFoto').on('click', EDITAR_PERFIL.alterarFoto);
	
	//Quando clica em cortar foto
	$('#cortarImagem').on('click', EDITAR_PERFIL.cortarFoto);
});