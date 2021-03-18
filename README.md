# Lab4_PA

Cerintele de la Compulsory + Optional + Bonus.

Am creeat 3 clase "SimplestSolution", "ExamScoreSolution" si "GaleShapley" pentru a ajunge la o solutie de atribuire a studentilor la scoli.

SimplestSolution - Respecta prima cerinta de la optional

ExamScoreSolution - Respecta penultima cerinta de la optional (atribuie studentii bazandu-se pe scor si preferinte)

GaleShapley - Respecta cerinta de la Bonus pentru a gasi un stable matching.

Momentan in Main este folosita a treia solutie.

Clasa Problem contine HashMap-urile pentru a retine Preferintele, Listele cu Scolile si Studentii si diferite metode precum:

setSchPrefCriteria - Seteaza automat preferintele scolilor bazandu-se pe obiectele "Criteria" care pot fi de 2 tipuri: Note (Studenti cu note mai mari ca valoarea din aceasta clasa) sau NameLength (Studenti cu nume mai lung ca valoarea din aceasta clasa).

schoolTopPref - Printeaza scolile care au un anumit student ca alegere de top

studLikeSch - Printeaza studentii care au ca preferinta o lista de scoli.

setPref - Prelucreaza preferintele inainte de a fi folosite in algoritmul Gale Shapley

Pentru numele studentilor si a universitatilor a fost folosita libraria faker.

Bucataru Cristian-Stefan