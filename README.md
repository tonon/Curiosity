# Curiosity


Curiosity é um webservice RESTful webservice que envia comandos ao robo Curiosity para a exploração de terrenos em Marte.

Tecnologias utilizadas:

Java EE
JUnit
Maven
JBoss WildFly


Cenários de testes:


1) Movimento com rotações para direita:
curl -s --request GEST http://localhost:8080/Curiosity/rest/message/MMRMMRMM
Saída esperada: (2, 0, S)

2) Movimento para esquerda:
Entrada: curl -s --request GET http://localhost:8080/Curiosity/rest/message/MML
Saída esperada: (0, 2, W)

3) Repetição da requisição com movimento para esquerda:
Entrada: curl -s --request GET http://localhost:8080/Curiosity/rest/message/MML
Saída esperada: (0, 2, W)

4) Comando inválido:
curl -s --request GET http://localhost:8080/Curiosity/rest/message/AAA
Saída esperada: 400 Bad Request

5)Posição inválida:
curl -s --request GET http://localhost:8080/Curiosity/rest/message/MMMMMMMMMMMMMMMMMMMMMMMM
Saída esperada: 400 Bad Request




