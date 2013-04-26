<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>  
      
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
    
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>gravar novo</title>  
    
</head>  
<body>  

<form id="produtosForm" action="<c:url value="/produtos"/>" 
  method="POST">
  <fieldset>
    <legend>Adicionar produtos</legend>
  
    <label for="nome">Nome:</label>
      <input id="nome" class="required" minlength="3"
        type="text" name="produto.nome" 
        value="${produto.nome }"/>

    <label for="descricao">Descri��o:</label>
      <textarea id="descricao" class="required" 
        maxlength="40" name="produto.descricao">
        ${produto.descricao }
      </textarea>

    <label for="preco">Pre�o:</label>
      <input id="preco" min="0" type="text"
        name="produto.preco" value="${produto.preco }"/>

    <button type="submit">Enviar</button>
  </fieldset>
</form>

<script type="text/javascript"> 
$('#produtosForm').validate({ 
messages:{ 
"produto.nome": { 
required: "O campo nome � obrigatorio.", 
minlength: "O campo nome deve conter no m�nimo 3 caracteres." 
}, 
"produto.descricao": { 
required: "O campo descri��o � obrigatorio.", 
maxlength: "O campo nome deve conter no m�ximo 40 caracteres." 
}, 
"produto.preco": { 
required: "O campo pre�o � obrigatorio.", 
min: "O valor deve ser superior a zero." 
} 
} 
}); 
</script>
  
</body>  
  
</html>  