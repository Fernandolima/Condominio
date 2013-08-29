package br.com.webhomebeta.to;

public class Json {
	String response;

	
	public Json(String response) {
		super();
		this.response = response;
	}

	/**
	 * @return the json
	 */
	public String getJson() {
		return response;
	}

	/**
	 * @param json the json to set
	 */
	public void setJson(String json) {
		this.response = json;
	}
}
