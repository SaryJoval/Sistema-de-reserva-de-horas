
	$(document).ready(function() {
		$('#registrationForm').bootstrapValidator({
 
 
	 feedbackIcons: {
 
		 valid: 'glyphicon glyphicon-ok',
 
		 invalid: 'glyphicon glyphicon-remove',
 
		 validating: 'glyphicon glyphicon-refresh'
 
	 },
 
	 fields: {
 
		 'registrationForm\\:nombreUsuario': {
			 validators: {
				 stringLength: {
                     min: 5,
                     max: 15,
                     message: 'El nombre de usuario debe tener entre 6 a 15 caracteres'
                 },
 
				 notEmpty: {
					 message: 'El nombre de usuario es obligatorio'
				 }
			 }
		 },
		 'registrationForm\\:nombre':{
			 validators: {
				 stringLength: {
                     min: 6,
                     max: 15,
                     message: 'El nombre de usuario debe tener entre 6 a 15 caracteres'
				 },
				 notEmpty: {
					 message: 'El nombre es obligatorio'
				 }
			 }
		 },
		 'registrationForm\\:apellidoPaterno': {
			 validators: {
				 notEmpty: {
					 message: 'El apellido paterno es obligatorio'
				 }
			 }
		 },
		 'registrationForm\\:apellidoMaterno': {
			 validators: {
				 notEmpty: {
					 message: 'El apellido materno es obligatorio'
				 }
			 }
		 },
		 'registrationForm\\:edad': {
			 validators: {
				 between: {
                     min: 18,
                     max: 140,
                     message: ''
                 },
				 stringLength: {
                     min: 2,
                     max: 3,
                     message: 'La edad sólo permite hasta tres digitos'
                 },
				 digits: {
					 message:'La edad sólo puede conterner números'
				 },
				 notEmpty: {
					 message: 'Por favor ingrese su edad'
				 }
			 }
		 },
		 'registration\\:correo': {
			 validators: {
				 emailAddress:{ 
					 message: 'Por favor ingrese un mail válido'
				 }
			 },
				 notEmpty: {
					 message: 'Por favor ingrese un e-mail'
				 }
			 }
		 },
		 'registration\\:celular': {
			 validators: {
				 stringLength: {
                     min: 8,
                     max: 8,
                     message: 'El celular debe tener 8 digitos'
                 },
				 notEmpty: {
					 message: 'Por favor ingrese su teléfono celular'
				 }
			 }
		 },
		 'registration\\:contraseña': {
			 validators: {
				 notEmpty: {
					 message: 'La contraseña es requerida'
				 }
			 }
		 },
		
			});
		})
		
		
		
		
 