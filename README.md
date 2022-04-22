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
Ao utilizar o FX, precisamos executar antes alguns passos importantes: 

1. Clonado o projeto do repositório remoto, rode o projeto. Apresentando erro, clique
   na seta ao lado do botão Run do eclipse, e acesse a opção "Run Configurations";
   2. Na aba esquerda, clique no nome da classe do projeto que contenha o método main;
   3. Na aba Arguments, desmarque a opção "Use the -XStartOnFirstThread argument when lauching with SWT", se houver;
   4. Verifique se no arquivo module-info.java o pacote contendo a classe principal (com o método main) está aberta 
     (opens telaRobo;);  
  
