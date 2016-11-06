package com.healthcaresolutions.hisif.beans;

import com.healthcare.db.model.ItemRange;

public class ItemInfo {
	
	private Integer itemId;
	
	private String itemName;
	
	private String unit;
	
	private String itemDesc;
	
	private ItemRange range;
	

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public ItemRange getRange() {
		return range;
	}

	public void setRange(ItemRange range) {
		this.range = range;
	}
	
}
