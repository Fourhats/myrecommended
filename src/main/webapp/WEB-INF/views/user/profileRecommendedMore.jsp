<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<%@ include file="../partials/styles.jsp"%>
<title>Mis Recomendados</title>
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.3/fotorama.css"
	rel="stylesheet">
<!-- 3 KB -->
<style>
	#holder, #holder2, #holder3 { border: 10px dashed #ccc; width: 100px; min-height: 100px; margin: 20px auto;}
	#holder.hover, #holder2.hover, #holder3.hover { border: 10px dashed #0c0; }
	#holder img, #holder2 img, #holder3 img { display: block; margin: 10px auto; }
	#holder p, #holder2 p, #holder3 p { margin: 10px; font-size: 14px; }
	progress { width: 100%; }
	.fail { background: #c00; padding: 2px; color: #fff; }
	.hidden { display: none !important;}
</style>
</head>

<body>
	<%@ include file="../partials/header.jsp"%>

	<main>
	<div class="col m12">
		<h1 class="header center-on-small-only">Perfil de usuario</h1>
	</div>
	<div class="section no-pad-bot" id="index-banners">
		<div class="container">

			<div class="row">
				<div class="col s3">
					<div class="collection">
						<a href="#!" class="collection-item">Información del usuario</a> <a
							href="#!" class="collection-item active">Perfíl
							Recomendado</a> <a href="#!" class="collection-item">Trabajos
							realizados</a> <a href="#!" class="collection-item">Preguntas <span
							class="new badge">4</span></a>
					</div>
				</div>
				<form class="col s9">
					<div class="row">
						<div class="input-field col s6">
							<input id="first_name" type="text" class="validate"> <label
								for="first_name">Nombre del Recomendado</label>
						</div>
						<div class="input-field col s6">
							<input id="last_name" type="text" class="validate"> <label
								for="last_name">Razón Social</label>
						</div>
						<div class="input-field col s12">
							<textarea id="textarea1" class="materialize-textarea"></textarea>
							<label for="textarea1">Descripción</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s6">
							<input id="email" type="email" class="validate"> <label
								for="email">Telefono</label>
						</div>
						<div class="input-field col s6">
							<input id="phone" type="text" class="validate"> <label
								for="email">Email</label>
						</div>
					</div>

					<div class="row">
						<div class="col s3">
							 <div id="holder">
							 </div> 
							 <p id="upload" class="hidden"><label>Drag & drop not supported, but you can still upload via this input field:<br><input type="file"></label></p>
							 <p id="filereader">File API & FileReader API not supported</p>
							 <p id="formdata">XHR2's FormData is not supported</p>
							 <p id="progress">XHR2's upload progress isn't supported</p>
							 <progress id="uploadprogress" min="0" max="100" value="0">0</progress>
						 </div>
						<div class="col s3">
							 <div id="holder2">
							 </div> 
							 <p id="upload2" class="hidden"><label>Drag & drop not supported, but you can still upload via this input field:<br><input type="file"></label></p>
							 <!-- <p id="filereader2">File API & FileReader API not supported</p>
							 <p id="formdata2">XHR2's FormData is not supported</p>
							 <p id="progress2">XHR2's upload progress isn't supported</p>-->
							 <progress id="uploadprogress2" min="0" max="100" value="0">0</progress>
						 </div>
						<div class="col s3">
							 <div id="holder3">
							 </div> 
							 <p id="upload3" class="hidden"><label>Drag & drop not supported, but you can still upload via this input field:<br><input type="file"></label></p>
							 <!-- <p id="filereader3">File API & FileReader API not supported</p>
							 <p id="formdata3">XHR2's FormData is not supported</p>
							 <p id="progress3">XHR2's upload progress isn't supported</p>-->
							 <progress id="uploadprogress3" min="0" max="100" value="0">0</progress>
						 </div>
					</div>

				</form>
			</div>
		</div>
	</div>
	</main>
</body>

<%@ include file="../partials/scripts.jsp"%>
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.3/fotorama.js"></script>
<!-- 16 KB -->
<script>
var holder = document.getElementById('holder'),
    tests = {
      filereader: typeof FileReader != 'undefined',
      dnd: 'draggable' in document.createElement('span'),
      formdata: !!window.FormData,
      progress: "upload" in new XMLHttpRequest
    }, 
    support = {
      filereader: document.getElementById('filereader'),
      formdata: document.getElementById('formdata'),
      progress: document.getElementById('progress')
    },
    acceptedTypes = {
      'image/png': true,
      'image/jpeg': true,
      'image/gif': true
    },
    progress = document.getElementById('uploadprogress'),
    fileupload = document.getElementById('upload');

"filereader formdata progress".split(' ').forEach(function (api) {
  if (tests[api] === false) {
    support[api].className = 'fail';
  } else {
    // FFS. I could have done el.hidden = true, but IE doesn't support
    // hidden, so I tried to create a polyfill that would extend the
    // Element.prototype, but then IE10 doesn't even give me access
    // to the Element object. Brilliant.
    support[api].className = 'hidden';
  }
});

function previewfile(file) {
  if (tests.filereader === true && acceptedTypes[file.type] === true) {
    var reader = new FileReader();
    reader.onload = function (event) {
      var image = new Image();
      image.src = event.target.result;
      image.width = 250; // a fake resize
      holder.appendChild(image);
    };

    reader.readAsDataURL(file);
  }  else {
    holder.innerHTML += '<p>Uploaded ' + file.name + ' ' + (file.size ? (file.size/1024|0) + 'K' : '');
    console.log(file);
  }
}

function readfiles(files) {
    debugger;
    var formData = tests.formdata ? new FormData() : null;
    for (var i = 0; i < files.length; i++) {
      if (tests.formdata) formData.append('file', files[i]);
      previewfile(files[i]);
    }

    // now post a new XHR request
    if (tests.formdata) {
      var xhr = new XMLHttpRequest();
      xhr.open('POST', '/devnull.php');
      xhr.onload = function() {
        progress.value = progress.innerHTML = 100;
      };

      if (tests.progress) {
        xhr.upload.onprogress = function (event) {
          if (event.lengthComputable) {
            var complete = (event.loaded / event.total * 100 | 0);
            progress.value = progress.innerHTML = complete;
          }
        }
      }

      xhr.send(formData);
    }
}

if (tests.dnd) { 
  holder.ondragover = function () { this.className = 'hover'; return false; };
  holder.ondragend = function () { this.className = ''; return false; };
  holder.ondrop = function (e) {
    this.className = '';
    e.preventDefault();
    readfiles(e.dataTransfer.files);
  }
} else {
  fileupload.className = 'hidden';
  fileupload.querySelector('input').onchange = function () {
    readfiles(this.files);
  };
}

</script>
</html>