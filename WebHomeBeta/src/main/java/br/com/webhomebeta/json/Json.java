package br.com.webhomebeta.json;

public class Json {
	String success;

	
	
	public Json(String json) {
		super();
		this.success = json;
	}

	/**
	 * @return the json
	 */
	public String getJson() {
		return success;
	}

	/**
	 * @param json the json to set
	 */
	public void setJson(String json) {
		this.success = json;
	}
}
