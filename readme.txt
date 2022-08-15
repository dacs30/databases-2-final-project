Project III by  Danilo Augusto Correia da Silva

dcorreidasilva@wpi.edu

=====Section I: how to compile the code ======================

- open you terminal and navigate to the /src folder of the project
- type "javac App.java" to compile the project
- type "java App.java" to run the project

=====Section II: what is working is what is not ==================

I only worked on question one and three of the assigment . They should
all be working completely fine if you compile with the following queries
withouth the quotations:

"SELECT Col2, AVG(randomv) FROM A GROUP BY Col2"

"SELECT Col2, SUM(randomv) FROM A GROUP BY Col2"

"SELECT Col2, AVG(randomv) FROM B GROUP BY Col2"

"SELECT Col2, SUM(randomv) FROM B GROUP BY Col2"

"SELECT A.Col1, A.Col2, B.Col1, B.Col2 FROM A, B WHERE A.RandomV = B.RandomV"

you can type "q" to quit at anytime

=====Section III: design decisions===========================

The one decision that I took for this project was to create  a class for each type
of operation. For the aggregation ones, the hash table is made of two items: the name
of the record and an Array of integers that the first index represents the sum of values
from all records with the same name, and the second index working as a "counter" of appearences.

No sorting was used for the sake of time (need to study for finals ;-) )