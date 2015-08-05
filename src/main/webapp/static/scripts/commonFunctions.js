function getCompletePath(path) {
	if(ctx == "") {
		return "/" + path;
	}
	
	return ctx + "/" + path;
}

function redirect(path){
	window.location = getCompletePath(path);
}