# Prot�tipo da Tela do Robo de Triagem
  
  
Este reposit�rio guarda o c�digo fonte da tela de usu�rio do rob� de 
triagem do TJMA, desenvolvido pelo Laborat�rio de Inova��o - ToadaLab. 
  
  
## Objetivo da Aplica��o 
  
Dar ao usu�rio maior facilidade na configura��o dos arquivos de configura��o 
exigidos pelo rob�, para evitar erros no preenchimento dos mesmos, que em sua 
maioria, exige pr�vio e m�nimo conhecimento sobre a sintaxe exigida pelo 
formato dos arquivos (JSON). 
Desta forma, evitamos o deslocamento dos assessores de automa��o 
aos gabinetes para resolver problemas simples, como o preenchimento 
equivocado dos arquivos de configura��o. 
  
  
## Tecnologias utilizadas  

  
  
Para o projeto, as seguintes tecnologias foram utilizadas:  
* Java (15)
* JavaFX (18.0.1)
  
## Prepara��o inicial do ambiente para o desenvolvimento  
Ao utilizar o FX, precisamos executar antes alguns passos importantes: 

1. Clonado o projeto do reposit�rio remoto, rode o projeto. Apresentando erro, clique
   na seta ao lado do bot�o Run do eclipse, e acesse a op��o "Run Configurations";
   2. Na aba esquerda, clique no nome da classe do projeto que contenha o m�todo main;
   3. Na aba Arguments, desmarque a op��o "Use the -XStartOnFirstThread argument when lauching with SWT", se houver;
   4. Verifique se no arquivo module-info.java o pacote contendo a classe principal (com o m�todo main) est� aberta 
     (opens telaRobo;);  
  
