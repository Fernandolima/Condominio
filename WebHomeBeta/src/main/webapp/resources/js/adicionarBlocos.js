var BLOCOS = {
	init: function() {
		//inserir validações
	},

	inserirBlocos: function(e) {
		e.preventDefault();
		
		var htmlBloco = "";
		
		$.ajax({
			url: 'cadastro/salvarBloco',
			type: 'POST',
			data : $('#frmBlocos').serialize(),
			success: function(data) {
				console.log(data);
				htmlBloco += '<div class="lineTabelaBlocos">';
					htmlBloco += '<p class="itemBlocos pBloco">'+data.bloco+'</p>';
					htmlBloco += '<p class="itemBlocos">'+data.quantAp+'</p>';
					htmlBloco += '<p class="itemBlocos">'+data.quatApAndares+'</p>';
					htmlBloco += '<p class="itemBlocos">'+data.numeroInicial+'</p>';
					htmlBloco += '<p class="itemBlocos delete"><a href="#" data-id="'+data.idBloco+'" class="btn-delete-bloco hidden">Delete</a></p>';
				htmlBloco += '</div>';
				
				$('#tabelaBlocos').append(htmlBloco);
				$('#frmBlocos input').val('');
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
	}
}

$(function() {	
	if($('#frmBlocos')[0]) {
		BLOCOS.init();
		$('#btSubmitBlocos').on('click', BLOCOS.inserirBlocos);
		$('body').on('click', '.btn-delete-bloco', BLOCOS.excluirBlocos);
	}	
});