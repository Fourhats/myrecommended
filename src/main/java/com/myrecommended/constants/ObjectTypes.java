package com.myrecommended.constants;

public enum ObjectTypes {
	RECOMMENDED(1), USER(2);

    private int value;

    private ObjectTypes(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}