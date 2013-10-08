var BLOCOS = {
	
	init: function() {
		//inserir validações
	},

	inserirBlocos: function(e) {
		e.preventDefault();
		
		var htmlBloco = "";
		
		if($('#tabelaBlocos')[0]) {
			
		} else {
			htmlBloco += '<div id="tabelaBlocos">';
				htmlBloco += '<div class="lineTabelaBlocos">';
					htmlBloco += '<p class="itemBlocos pBloco title">Bloco</p>';
					htmlBloco += '<p class="itemBlocos title">Nº de Apartamentos</p>';
					htmlBloco += '<p class="itemBlocos title">Ap. por Andar</p>';
					htmlBloco += '<p class="itemBlocos title">Inicio da numeração</p>';
					htmlBloco += '<p class="itemBlocos title deleteBloco">Excluir</p>';
				htmlBloco += '</div>';
			htmlBloco += '</div>';
			
			$('.nenhumResultado').hide();
			$('#blocosCadastrados').append(htmlBloco);
		}
		
		htmlBloco = "";			
		$.ajax({
			url: 'cadastro/salvarBloco',
			type: 'POST',
			data : $('#frmBlocos').serialize(),
			success: function(data) {
				htmlBloco += '<div class="lineTabelaBlocos">';
					htmlBloco += '<p class="itemBlocos pBloco">'+data.bloco+'</p>';
					htmlBloco += '<p class="itemBlocos">'+data.quantAp+'</p>';
					htmlBloco += '<p class="itemBlocos">'+data.quatApAndares+'</p>';
					htmlBloco += '<p class="itemBlocos">'+data.numeroInicial+'</p>';
					htmlBloco += '<p class="itemBlocos delete"><a href="#" data-id="'+data.idBloco+'" class="btn-delete-bloco hidden">Delete</a></p>';
				htmlBloco += '</div>';
				
				$('#tabelaBlocos').append(htmlBloco);
				$('.inputBloco').val('');
			}
		});		
	},
	
	excluirBlocos: function(e) {
		e.preventDefault();
		
		var idBloco = $(this).attr('data-id'),
			el = $(this);
		$.ajax({
			url: 'cadastro/delete',
			type: 'POST',
			data: { idbloco: idBloco },
			success: function(data) {
				if(data.json) {
					el.closest('div').remove();
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