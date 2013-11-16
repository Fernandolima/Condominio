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
				console.log(data);
				if(data.erro === 1){
					$.jGrowl("Você deve preencher todos os campos!", { header: 'ERRO!', sticky:true,});
				}
					else if(data.erro === 2) {
						$.jGrowl("Este bloco já esta adicionado!", { header: 'ERRO!', sticky:true,});
				}else{
				htmlBloco += '<tr>';
					htmlBloco += '<td>'+data.bloco+'</p>';
					htmlBloco += '<td>'+data.quantAp+'</p>';
					htmlBloco += '<td>'+data.quatApAndares+'</p>';
					htmlBloco += '<td>'+data.numeroInicial+'</p>';
					htmlBloco += '<td><a href="#div'+data.idBloco+'" data-toggle="modal" class="btn btn-danger">Excluir</a>';
					//Modal
					htmlBloco += '<div id="div'+data.idBloco+'" class="modal hide">';
					htmlBloco += '<div class="modal-header">';
					htmlBloco += '<button data-dismiss="modal" class="close" type="button">×</button>';
					htmlBloco += '<h3>Exclusão do bloco</h3>';
					htmlBloco += '</div>';
					htmlBloco += 	'<div class="modal-body">';
					htmlBloco += '<p>Confirma exclusão do bloco?</p>';
					htmlBloco += '</div>';
					htmlBloco += '<div class="modal-footer">';
					htmlBloco += 	'<a data-dismiss="modal" class="btn btn-delete-bloco btn-primary" href="#" data-id="'+data.idBloco+'">Sim</a>';
					htmlBloco += 	'<a data-dismiss="modal" class="btn" href="#">Não</a>';
					htmlBloco += '</div>';
					htmlBloco += '</div>';
					htmlBloco += '</td>';
				htmlBloco += '</tr>';
				$('#listaBlocos tbody').prepend(htmlBloco);
				$('body').on('click', '.btn-delete-bloco', BLOCOS.excluirBlocos);
				$.jGrowl("O Bloco foi adicionado com sucesso!");
				$('input[type="text"]').val('');
				}
				
				if($('.nenhumResultado').css('display') == 'block') {
					$('.nenhumResultado').hide();
				}
				
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
		$('#nrmApartementos').mask('?9999',{placeholder:""});
		$('#apartamentosPorAndar').mask('?9999',{placeholder:""});
		$('#inicioDaNumeracao').mask('?9999',{placeholder:""});
	}	
});