package com.sumiyacompany.oficina.oficina.entities.enums;

public enum TipoNum {
	
	CEL(1),
	COM(2),
	RES(3);
	
	private int code;

	private TipoNum(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	
	public static TipoNum valueOf(int code) {
		for(TipoNum value: TipoNum.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid TipoNum code");
	}
}
