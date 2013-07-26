var LOGIN = {
	hash: null,
	
	init: function() {
		console.log('init');
		hash = location.href.split('?');
		hash = hash[1];
		
		if(hash !== '') {
			switch (hash) {
				case 'error':
					$('body').addClass('error');
				break;
			}
		}
	}	
}

$(function() {
	if($('#login-view')[0]){
		LOGIN.init();
	}
});