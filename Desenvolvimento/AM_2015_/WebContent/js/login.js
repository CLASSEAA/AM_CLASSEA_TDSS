$(document).ready( function() {
  $("#formularioLogin").validate({
    // Define as regras
    rules:{
      loginVl:{
        // campoNome será obrigatório (required) e terá tamanho mínimo (minLength)
        required: true
      },
      senhaVl:{
        // campoEmail será obrigatório (required) e precisará ser um e-mail válido (email)
        required: true
      }
    },
    // Define as mensagens de erro para cada regra
    messages:{
      login:{
        required: "Informe o login"
      },
      senha:{
        required: "Digite o seu e-mail para contato"
      }
    }
  });
});