package com.myrecommended.constants;

public enum SignInProvider {
	FORM("FORM"), FACEBOOK("FACEBOOK");

    private String value;

    private SignInProvider(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}