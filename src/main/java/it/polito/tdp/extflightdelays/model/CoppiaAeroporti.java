package it.polito.tdp.extflightdelays.model;

import it.polito.tdp.extflightdelays.model.Airport;

public class CoppiaAeroporti {
	private int partenza_id;
	private int arrivo_id;
	private int distanceMedia;
	
	public int getPartenza_id() {
		return partenza_id;
	}
	public void setPartenza_id(int partenza_id) {
		this.partenza_id = partenza_id;
	}
	public int getArrivo_id() {
		return arrivo_id;
	}
	public void setArrivo_id(int arrivo_id) {
		this.arrivo_id = arrivo_id;
	}
	public int getDistanceMedia() {
		return distanceMedia;
	}
	public void setDistanceMedia(int distance) {
		this.distanceMedia = distance;
	}
	public CoppiaAeroporti(int partenza_id, int arrivo_id, int distance) {
		super();
		this.partenza_id = partenza_id;
		this.arrivo_id = arrivo_id;
		this.distanceMedia = distance;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + arrivo_id;
		result = prime * result + distanceMedia;
		result = prime * result + partenza_id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CoppiaAeroporti other = (CoppiaAeroporti) obj;
		if (arrivo_id != other.arrivo_id)
			return false;
		if (distanceMedia != other.distanceMedia)
			return false;
		if (partenza_id != other.partenza_id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CoppiaAeroporti [partenza_id=" + partenza_id + ", arrivo_id=" + arrivo_id + ", distanceMedia="
				+ distanceMedia + "]";
	}

	
	
	
	
}
