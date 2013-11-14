package br.com.webhomebeta.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.webhomebeta.bean.GastoControllerBean;
import br.com.webhomebeta.entity.Gasto;
import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.json.GastoJSON;
import br.com.webhomebeta.service.GastoService;
import br.com.webhomebeta.service.UsuarioService;
import br.com.webhomebeta.service.security.UserDetailsImp;

@Controller
public class GastoController {
	
	@Autowired
	private GastoService gastoService;
	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(value = "admin/gasto", method = RequestMethod.GET)
	public ModelAndView CadastraBlocos(ModelMap model) {
		
		Calendar calendar = Calendar.getInstance();
		
		 String meses[] = {"Janeiro", "Fevereiro", 
	              "Mar�o", "Abril", "Maio", "Junho", 
	              "Julho", "Agosto", "Setembro", "Outubro",
		      "Novembro", "Dezembro"};
		 
		ArrayList<GastoJSON> gastoJSONs = new ArrayList<>();
		
		for(Gasto g : gastoService.get()){
			calendar.setTime(g.getData());
			GastoJSON gastoJSON = new GastoJSON();
			gastoJSON.setAno(calendar.get(Calendar.YEAR));
			gastoJSON.setMes(meses[g.getData().getMonth()]);
			gastoJSON.setGasto(g.getGasto());
			gastoJSON.setIdGasto(g.getIdGasto());
			
			gastoJSONs.add(gastoJSON);
		}
		
		Map<Integer, String> mes = new LinkedHashMap<>();
		mes.put(0, "Janeiro");
		mes.put(1, "Fevereiro");
		mes.put(2, "Mar�o");
		mes.put(3, "Abril");
		mes.put(4, "Maio");
		mes.put(5,"Junho");
		mes.put(6, "Julho");
		mes.put(7, "Agosto");
		mes.put(8, "Setembro");
		mes.put(9, "Outubro");
		mes.put(10, "Novembro");
		mes.put(11, "Dezembro");
		
		model.put("listaMeses", mes);
		model.put("listaGastos", gastoJSONs);
		model.put("gasto", new GastoControllerBean());
		model.put("usuario", getUsuario());
		// Retorna a pagina cadastrarBlocos.jsp com um bloco criado
		return new ModelAndView("gastos", model);
	}
	@RequestMapping(value = "admin/gastos/add", method = RequestMethod.POST)
	public @ResponseBody GastoJSON save(@ModelAttribute("gasto") GastoControllerBean gasto, BindingResult bindingResult){
		
		 String meses[] = {"Janeiro", "Fevereiro", 
	              "Mar�o", "Abril", "Maio", "Junho", 
	              "Julho", "Agosto", "Setembro", "Outubro",
		      "Novembro", "Dezembro"};
		
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.MONTH, Integer.parseInt(gasto.getMes()));
		calendar.set(Calendar.YEAR, gasto.getAno());
		
		gasto.getGastoTO().setData(calendar.getTime());
		Gasto g = new Gasto();
		
		BeanUtils.copyProperties(gasto.getGastoTO(), g);
		
		g = gastoService.save(g);
		
		GastoJSON gastoJSON = new GastoJSON();
		gastoJSON.setAno(calendar.get(Calendar.YEAR));
		gastoJSON.setMes(meses[calendar.get(Calendar.MONTH)]);
		gastoJSON.setGasto(g.getGasto());
		gastoJSON.setIdGasto(g.getIdGasto());
		
		return gastoJSON;
	}
	
	@RequestMapping(value = "admin/gastos/delete", method = RequestMethod.POST)
	public @ResponseBody String delete(@RequestParam("idGasto") int id){
		gastoService.delete(id);
		return "true";
	}

	public Usuario getUsuario() {

		Usuario usuario = null;
		SecurityContext context = SecurityContextHolder.getContext();
		if (context instanceof SecurityContext) {
			// Pega as informacoes da autenticacao
			Authentication authentication = context.getAuthentication();
			if (authentication instanceof Authentication) {
				// Pega o usuario que logou
				usuario = usuarioService
						.getUsuarioByLogin(((UserDetailsImp) authentication
								.getPrincipal()).getUsername());

			}
		}

		return usuario;
	}
	
}
