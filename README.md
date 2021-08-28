<h1>Desafio</h1>
<h2>MovieFlix casos de uso</h2>

<h3>Casos de uso</h3>
<img src="https://github.com/AugustoCesar/assets/blob/main/img/movieflix.png" alt="movieflix"/>

<h3>Efetuar login</h3>
<ul>
  <li>[IN] O usuário anônimo informa seu email e senha</li>
  <li>[OUT] O sistema informa um token válido</li>
</ul>

<h3>Listar filmes</h3>
<ul>
  <li>[OUT] O sistema apresenta uma listagem dos nomes de todos gêneros, bem como uma listagem paginada com título, subtítulo, ano e imagem dos filmes, ordenada alfabeticamente por título.</li>
  <li>[IN] O usuário visitante ou membro seleciona, opcionalmente, um gênero.</li>
  <li>[OUT] O sistema apresenta a listagem atualizada, restringindo somente ao gênero selecionado.</li>
</ul>

<h3>Visualizar detalhes do filme</h3>
<ul>
  <li>[IN] O usuário visitante ou membro seleciona um filme</li>
  <li>[OUT] O sistema informa título, subtítulo, ano, imagem e sinopse do filme, e também uma listagem dos textos das avaliações daquele filme juntamente com nome do usuário que fez cada avaliação.</li>
  <li>[IN] O usuário membro informa, opcionalmente, um texto para avaliação do filme. *</li>
  <li>[OUT] O sistema apresenta os dados atualizados, já aparecendo também a avaliação feita pelo usuário.</li>
</ul>

<h3>* Exceção 3.1 - Texto vazio</h3>
<ul>
  <li>3.1.1. O sistema apresenta uma mensagem de que não é permitido texto vazio na avaliação</li>
</ul>
