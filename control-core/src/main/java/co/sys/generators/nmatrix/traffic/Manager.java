package co.sys.generators.nmatrix.traffic;

import co.sys.agent.Agent;

public class Manager extends Agent {

	private String id;

	private String name;

	public Manager(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
