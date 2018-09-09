package co.sys.generators.nmatrix.traffic;

import co.sys.concept.patterns.things.agent.Agent;

import java.util.ArrayList;
import java.util.List;

public class Route extends Agent {

	private String id;

	private String friendlyName;

	private String starGeo;

	private String endGeo;

	private List<String> stopGeos = new ArrayList<>();

	public Route(String id, String friendlyName, String starGeo, String endGeo, List<String> stopGeos) {
		this.id = id;
		this.friendlyName = friendlyName;
		this.starGeo = starGeo;
		this.endGeo = endGeo;
		this.stopGeos = stopGeos;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFriendlyName() {
		return friendlyName;
	}

	public void setFriendlyName(String friendlyName) {
		this.friendlyName = friendlyName;
	}

	public String getStarGeo() {
		return starGeo;
	}

	public void setStarGeo(String starGeo) {
		this.starGeo = starGeo;
	}

	public String getEndGeo() {
		return endGeo;
	}

	public void setEndGeo(String endGeo) {
		this.endGeo = endGeo;
	}

	public List<String> getStopGeos() {
		return stopGeos;
	}

	public void setStopGeos(List<String> stopGeos) {
		this.stopGeos = stopGeos;
	}
}
