var BLOCOS = {
	init: function() {
		//inserir validações
	},

	inserirBlocos: function(e) {
		e.preventDefault();
		var html = '';

		html += '<div class="blocos">';
			html += '<label>Bloco:</label>';
			html += '<input type="text" name="descricaoCondominioTO.bloco" id="bloco" />';
			
			html += '<label id="lbNumAp">Quantidade de Apartamentos:</label>';
			html += '<input type="text" name="descricaoCondominioTO.apartamento" id="numAp" />';
		html += '</div>';

		$('#contentFrm').append(html);
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
		//$('.adicionar-bloco').on('click', BLOCOS.inserirBlocos);
		$('.btn-delete-bloco').on('click', BLOCOS.excluirBlocos);
	}	
});