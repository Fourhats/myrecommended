package com.myrecommended.constants;

public enum TempFolders {
	AVATAR_FOLDER("avatars"), 
	RECOMMENDED_AVATARS_FOLDER("recommendedAvatars"), 
	RECOMMENDED_OLD_JOBS_FOLDER("recommendedOldJobs");

    private String value;

    private TempFolders(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}