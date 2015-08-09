function getCompletePath(path) {
	if(ctx == "") {
		return "/" + path;
	}
	
	return ctx + "/" + path;
}

function redirect(path){
	window.location = getCompletePath(path);
}

function getImagePath(actionControllerName, imageName, type){
	type = type || 'none';
	return getCompletePath("imageHandler/" + actionControllerName) + '?fileName=' + imageName + '&type=' + type;
}
