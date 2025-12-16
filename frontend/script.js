document.getElementById('cadastroAmigo').addEventListener('submit', function(event) {
    event.preventDefault(); // Impede o envio padrão

    // 1. Coleta os dados do formulário baseado nos atributos 'name'
    const form = event.target;
    const formData = new FormData(form);
    
    // 2. Converte os dados do formulário para um objeto JSON
    // As chaves deste objeto serão os valores dos atributos 'name' (nomeCompleto, apelido, amizadeNivel)
    const amigoData = Object.fromEntries(formData.entries());

    // 3. Ajusta o tipo do Nível de Amizade para Integer (Spring espera um número)
    amigoData.rating = parseInt(amigoData.rating);

    // 4. URL do seu Endpoint Spring (VERIFIQUE A PORTA!)
    const url = 'http://localhost:8080/api/add'; 
    
    // 5. Enviar a requisição POST (O restante da lógica é a mesma)
    fetch(url, {
        method: 'POST', 
        headers: {
            'Content-Type': 'application/json' 
        },
        body: JSON.stringify(amigoData) 
    })
    .then(response => {
        if (response.ok) { 
            return response.json(); 
        } else {
            // Trata erros de validação do Spring (400 Bad Request)
            return response.json().then(err => {
                 throw new Error(`Falha no cadastro. Verifique os campos. Código: ${response.status}`);
            });
        }
    })
    .then(data => {
        // SUCESSO
        console.log('Amigo cadastrado com sucesso!', data);
        alert(`🎉 Amigo ${data.name} cadastrado!`);
        form.reset(); 
    })
    .catch(error => {
        // ERRO
        console.error('Erro na requisição:', error);
        alert(`🚨 ERRO: ${error.message}`);
    });
});