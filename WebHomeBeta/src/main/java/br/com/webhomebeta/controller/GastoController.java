package br.com.webhomebeta.controller;

import java.math.BigDecimal;
import java.text.DecimalFormat;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.webhomebeta.bean.GastoControllerBean;
import br.com.webhomebeta.entity.Gasto;
import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.json.GastoGrafico;
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

	private String meses[] = { "Janeiro", "Fevereiro", "Março", "Abril",
			"Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro",
			"Novembro", "Dezembro" };

	@RequestMapping(value = "admin/gasto", method = RequestMethod.GET)
	public ModelAndView CadastraBlocos(ModelMap model) {

		Calendar calendar = Calendar.getInstance();

		ArrayList<GastoJSON> gastoJSONs = new ArrayList<>();

		for (Gasto g : gastoService.get()) {
			calendar.setTime(g.getData());
			GastoJSON gastoJSON = new GastoJSON();
			gastoJSON.setAno(calendar.get(Calendar.YEAR));
			gastoJSON.setMes(meses[g.getData().getMonth()]);
			DecimalFormat f = new DecimalFormat("#,###,##0.00");
			gastoJSON.setGasto("R$ " + f.format(g.getGasto()));
			gastoJSON.setIdGasto(g.getIdGasto());

			gastoJSONs.add(gastoJSON);
		}

		Map<Integer, String> mes = new LinkedHashMap<>();
		mes.put(0, "Janeiro");
		mes.put(1, "Fevereiro");
		mes.put(2, "Março");
		mes.put(3, "Abril");
		mes.put(4, "Maio");
		mes.put(5, "Junho");
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
	public @ResponseBody
	GastoJSON save(@ModelAttribute("gasto") GastoControllerBean gasto,
			BindingResult bindingResult) {

		for (Gasto gasto2 : gastoService.get()) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(gasto2.getData());
			if (calendar.get(Calendar.YEAR) == gasto.getAno()
					&& calendar.get(Calendar.MONTH) == Integer.parseInt(gasto
							.getMes())) {
				return new GastoJSON(2);
			}
		}

		if (gasto.getAno() < 4) {
			return new GastoJSON(1);
		}

		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.MONTH, Integer.parseInt(gasto.getMes()));
		calendar.set(Calendar.YEAR, gasto.getAno());

		gasto.getGastoTO().setData(calendar.getTime());
		Gasto g = new Gasto();

		BeanUtils.copyProperties(gasto.getGastoTO(), g);
		String preco = gasto.getGasto().replace(".", "").replace(",", ".");

		g.setGasto(new BigDecimal(preco));
		g = gastoService.save(g);

		GastoJSON gastoJSON = new GastoJSON();
		gastoJSON.setAno(calendar.get(Calendar.YEAR));
		gastoJSON.setMes(meses[calendar.get(Calendar.MONTH)]);
		DecimalFormat f = new DecimalFormat("#,###,##0.00");
		gastoJSON.setGasto("R$ " + f.format(g.getGasto()));
		gastoJSON.setIdGasto(g.getIdGasto());

		return gastoJSON;
	}

	@RequestMapping(value = "admin/gastos/delete", method = RequestMethod.POST)
	public @ResponseBody
	String delete(@RequestParam("idGasto") int id) {
		gastoService.delete(id);
		return "true";
	}

	@RequestMapping(value = "home/gastos", method = RequestMethod.GET)
	public ModelAndView showGastos(ModelMap model) {
		model.put("usuario", getUsuario());
		model.put("gastos", gastoService.getYears());
		return new ModelAndView("gastosUsuario", model);
	}

	@RequestMapping(value = "home/gastos/ano={ano}", method = RequestMethod.GET)
	public ModelAndView showGrafico(@PathVariable("ano") int ano, ModelMap model) {
		model.put("usuario", getUsuario());
		model.put("ano", ano);
		return new ModelAndView("gastoGraficoUsuario", model);
	}

	@RequestMapping(value = "home/gastos/grafico")
	public @ResponseBody
	List<GastoGrafico> montarGrafico(@RequestParam("ano") int ano) {
		List<GastoGrafico> gastoGraficos = gastoJSON(ano);
		return gastoGraficos;
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

	public List<GastoGrafico> gastoJSON(int ano) {

		List<GastoGrafico> gastoJSONs = new ArrayList<>();
		for (Gasto gasto : gastoService.getGastos(ano)) {

			GastoGrafico gastoJSON = new GastoGrafico();
			gastoJSON.setData(gasto.getData());
			gastoJSON.setGasto(gasto.getGasto());
			System.out.println(gasto.getGasto());

			gastoJSONs.add(gastoJSON);
		}

		return gastoJSONs;
	}

}
