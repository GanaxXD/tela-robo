# Protótipo da Tela do Robo de Triagem
  
  
Este repositório guarda o código fonte da tela de usuário do robô de 
triagem do TJMA, desenvolvido pelo Laboratório de Inovação - ToadaLab. 
  
  
## Objetivo da Aplicação 
  
Dar ao usuário maior facilidade na configuração dos arquivos de configuração 
exigidos pelo robô, para evitar erros no preenchimento dos mesmos, que em sua 
maioria, exige prévio e mínimo conhecimento sobre a sintaxe exigida pelo 
formato dos arquivos (JSON). 
Desta forma, evitamos o deslocamento dos assessores de automação 
aos gabinetes para resolver problemas simples, como o preenchimento 
equivocado dos arquivos de configuração. 
  
  
## Tecnologias utilizadas  

  
  
Para o projeto, as seguintes tecnologias foram utilizadas:  
* Java (15)
* JavaFX (18.0.1)
  
## Preparação inicial do ambiente para o desenvolvimento  

  
  
**1. UTILIZANDO UM PROJETO COM MODULARIDADE**   
Ao utilizar o FX, precisamos executar antes alguns passos importantes: 

1. Clonado o projeto do repositório remoto, rode o projeto. Apresentando erro, clique
   na seta ao lado do botão Run do eclipse, e acesse a opção "Run Configurations";
   2. Na aba esquerda, clique no nome da classe do projeto que contenha o método main;
   3. Na aba Arguments, desmarque a opção "Use the -XStartOnFirstThread argument when lauching with SWT", se houver;
   4. Verifique se no arquivo module-info.java o pacote contendo a classe principal (com o método main) está aberta 
     (opens telaRobo;);  
   5. Prepare as configurações de execução em *Run Config*.
  
**2. UTILIZANDO RECURSOS JAVA SEM MODULARIDADE**
  
1. Abra o projeto normalmente. A classe ClienteRobo que contém o método main.
2. Faça as configurações de execução no *Run Config*.

  
  
## Realizando configurações no Run Config ## 
  
A estrutura do projeto contém uma pasta chamada *robos*.
  
Essa pasta contém os arquivos que serão usados nos computadores dos usuários finais. Nela, estão cópias do arquivo 
de configuração (no formato *json*), o .bat (nesse caso, o robô), e o  
arquivo de temas, no formato . txt, que contém as palavras chaves 
 que o robô buscara no processo para etiquetar o mesmo.  
Ao rodar o projeto pela primeira vez, será criado um App Config, acessado clicando 
na seta ao lado do botão *run*, e navegue até a opção *Run Configuration*. 
  Na tela que será aberta, selecione o App Config do robô rodado, e no quadro de Parâmetros, serão inseridos os dados que serão 
enviados no *main*, na variável args. Aqui, deverá ser passaro, entre aspas duplas, o caminho do arquivo 
 de configuração, seguido do temas, seguindo a seguinte sintaxe:  
  
```"pasta/nomeArquivoConfiguracao_config".json x "pasta/nomeArquivoTemas.txt"```
  
A figura abaixo exemplofica os passos descritos acima:  
  
  
  
