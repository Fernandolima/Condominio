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
			
			success:function(data) {
				
				data = data.split(',');
				largura = data[1];
				altura = data[2];
				
				if(largura > larguraModal) {
		    		larguraFinal = larguraModal;
		    	}
		    	
		    	if(altura > alturaModal) {
		    		alturaFinal = alturaModal;
		    	}
		    	
		    	
		         $('#container-foto').html('<img src="'+data[0]+'" id="imageUser" style="width:'+larguraFinal+'px; height: '+alturaFinal+'px;" />');
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
		 console.log(EDITAR_PERFIL.CX);
		 console.log(EDITAR_PERFIL.CY);
		 console.log(EDITAR_PERFIL.CW);
		 console.log(EDITAR_PERFIL.CH);
		 console.log('data = ', data);
	 }
}

$(function() {
	
	//alterar foto do usuário
	$('#alterarFoto').on('click', EDITAR_PERFIL.alterarFoto);
	
	//Quando clica em cortar foto
	$('#cortarImagem').on('click', EDITAR_PERFIL.cortarFoto);
});