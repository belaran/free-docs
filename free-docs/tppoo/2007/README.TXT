ReadMe
======

Comme vu au TP précédent, ce projet intial vient avec un fichier ant, dont la conception vous revient. Néanmoins,
il suffira très probablement de vous inspirer de ce qui vous avez déjà fait pour rapidement le mettre en place.

Une tâche a été déjà été mise en place pour vous 'pmd':

$ ant pmd

Cette tâche appel l'outil PMD pour contrôler le respect des règles de programmations préconisées. La tâche génère
un rapport au format HTML. Vous êtes de libre de ne pas utilsier cet outil, mais sachez que le
correcteur lui le fera ;) ...

Attention: PMD a besoin des librairies placés dans le répertoire lib/ pour fonctionner, mais comme vous l'avez
vu au tp de la semaine dernière, ces librairies ne devraient pas être placés dans le gestionnaire de sources, mais
pour des raisons de commodités vous pouvez le faire.
En plus de ces librairies, PMD a besoin d'un fichier de configuration 'esme-rulesets.xml' et d'une feuille de style
(pmd.xsl) qui transforme les rapports XML en HTML.