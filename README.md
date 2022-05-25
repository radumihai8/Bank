# Bank Application

### Etapa I
1) Definirea sistemului
      - [x] Să se creeze o lista pe baza temei alese cu cel puțin 10 acțiuni/interogări care se pot face în cadrul sistemului și o listacu cel puțin 8 tipuri de obiecte.
2) Implementare
     
     Sa se implementeze în limbajul Java o aplicație pe baza celor definite la primul punct. Aplicația va conține:
      
      - [x] clase simple cu atribute private / protected și metode de acces
  
      - [x] cel puțin 2 colecții diferite capabile să gestioneze obiectele definiteanterior (eg: List, Set, Map, etc.) dintre care cel puțin una sa fie sortata 
  
      - [x] utilizare moștenire pentru crearea de clase adiționale și utilizarea lor încadrul colecțiilor;
 
      - [x] cel puțin o clasă serviciu care sa expună operațiile sistemului
 
      - [x] o clasa Main din care sunt făcute apeluri către servicii

### Etapa II
1) Extindeți proiectul din prima etapa prin realizarea persistentei utilizând fișiere:
      - [x]  Se vor realiza fișiere de tip CSV pentru cel puțin 4 dintre clasele definite în prima etapa. Fiecare coloana din fișier este separata de virgula. Exemplu:nume,prenume,varsta
      - [x]  Se vor realiza serviciisingleton generice pentru scrierea și citirea din fișiere;
      - [x]  La pornirea programului se vor încărca datele din fișiere utilizând serviciile create;
2) Realizarea unui serviciu de audit
      - [x]  Se va realiza un serviciu care sa scrie într-un fișier de tip CSV de fiecare data când este executată una dintre acțiunile descrise în prima etapa. Structura fișierului: nume_actiune, timestamp
      
### Etapa III
1) Înlocuiți serviciile realizate în etapa a II-a cu servicii care sa asigure persistenta utilizând baza de date folosind JDBC. 
      - [x]  Să se realizeze servicii care sa expună operații de tip create, read, update, delete pentru cel puțin 4 dintre clasele definite
