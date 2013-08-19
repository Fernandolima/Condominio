var ADICIONAR_BLOCOS = {
	init: function() {
		//inserir validações
	},

	inserirBlocos: function(e) {
		e.preventDefault();
		var html = '';

		html += '<div class="blocos">';
			html += '<label>Bloco:</label>';
			html += '<input type="text" name="bloco" id="bloco" />';
			
			html += '<label id="lbNumAp">Quantidade de Apartamentos:</label>';
			html += '<input type="text" name="numAp" id="numAp" />';
		html += '</div>';

		$('#contentFrm').append(html);
	}
}

$(function() {	
	if($('#frmBlocos')[0]) {
		ADICIONAR_BLOCOS.init();

		$('.adicionar-bloco').on('click', ADICIONAR_BLOCOS.inserirBlocos);
	}	
});