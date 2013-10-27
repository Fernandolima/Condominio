var BLOCOS = {
	
	init: function() {
		//inserir validações
	},

	inserirBlocos: function(e) {
		e.preventDefault();
		
		htmlBloco = "";			
		$.ajax({
			url: 'cadastro/salvarBloco',
			type: 'POST',
			data : $('#frmBlocos').serialize(),
			success: function(data) {
				htmlBloco += '<tr>';
					htmlBloco += '<td>'+data.bloco+'</p>';
					htmlBloco += '<td>'+data.quantAp+'</p>';
					htmlBloco += '<td>'+data.quatApAndares+'</p>';
					htmlBloco += '<td>'+data.numeroInicial+'</p>';
					htmlBloco += '<td><a href="#" data-id="'+data.idBloco+'" class="btn btn-danger btn-delete-bloco">Delete</a></td>';
				htmlBloco += '</tr>';
				
				if($('.nenhumResultado').css('display') == 'block') {
					$('.nenhumResultado').hide();
				}
				
				$('#listaBlocos tbody').prepend(htmlBloco);
				$('input[type="text"]').val('');
			}
		});		
	},
	
	excluirBlocos: function(e) {
		e.preventDefault();
		
		var idBloco = $(this).attr('data-id'),
			el = $(this);
		$.ajax({
			url: '/WebHomeBeta/cadastro/delete',
			type: 'POST',
			data: { idbloco: idBloco },
			success: function(data) {
				if(data.json) {
					el.closest('tr').remove();
				}
			}
		});
		
		if($('.lineTabelaBlocos').length === 2) {
			console.log('entra');
			$('.nenhumResultado').show();
			$('#tabelaBlocos').remove();			
		}
	}
}

$(function() {	
	if($('#frmBlocos')[0]) {
		BLOCOS.init();
		$('#btSubmitBlocos').on('click', BLOCOS.inserirBlocos);
		$('body').on('click', '.btn-delete-bloco', BLOCOS.excluirBlocos);
	}	
});