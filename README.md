# ECS Online

[![forthebadge](https://forthebadge.com/images/badges/made-with-java.svg)](https://forthebadge.com)![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)

ECS Online est un jeu en ligne qui se joue à deux joueurs. Il vous permet de vous affronter avec un adversaire présent sur votre réseau local. Dans ce jeu, vous aurez l'occasion de découvrir différentes entités au fil de vos parties. Le jeu est divertissant et offre une expérience de jeu en ligne amusante et passionnante. Vous pourrez affronter votre adversaire en utilisant différentes stratégies pour remporter la victoire. Si vous aimez les jeux en ligne à deux joueurs, ECS Online est un excellent choix. Le jeu est simple à jouer et offre une interface intuitive pour une expérience de jeu fluide et agréable. Vous pourrez vous divertir pendant des heures en affrontant votre adversaire dans des parties passionnantes. Alors n'hésitez plus et essayez ECS Online dès maintenant !

## Fonctionnalités ⚙️

- La possibilité d'héberger une partie
- La possibilité de rejoindre une partie
- Un magasin avec des taux d'apparition afin de choisir ses combattants
- Une partie combat intéractive

## Démarrage 🚀

Pour lancer l'application via un IDE ouvrez simplement le fichier LaunchApp.java, et exécuter cette ligne :
```java
public class LaunchApp extends Application {
```
Application fonctionnelle sur : 

![Mac OS](https://img.shields.io/badge/mac%20os-000000?style=for-the-badge&logo=macos&logoColor=F0F0F0)![Windows](https://img.shields.io/badge/Windows-0078D6?style=for-the-badge&logo=windows&logoColor=white)![Linux](https://img.shields.io/badge/Linux-FCC624?style=for-the-badge&logo=linux&logoColor=black)

Vous pouvez aussi la lancer en exécutant le fichier ECSOnline.jar téléchargeable en cliquant sur le bouton ci-dessous.

[![Bouton téléchargement](https://custom-icon-badges.herokuapp.com/badge/-Download-blue?style=for-the-badge&logo=download&logoColor=white)](https://google.fr")

Pour exécuter le fichier ECSOnline.jar, vous pouvez soit cliquer à deux reprises dessus soit entrer la commande suivante dans votre terminal à l'endroit où se situe le fichier :
```bash
java -jar ECSOnline.jar
```
## Utilisation 🎮

- Accueil

Sur cette page, vous pouvez choisir d'être l'hôte de la partie en cliquant sur "Heberger" ou le client en cliquant sur "Rejoindre".

![Image page d'accueil de l'application](imagesReadme/accueil.png "Page d'accueil")

- Héberger

L'un des deux joueurs doit héberger la partie, et l'autre la rejoindre. Celui qui aura cliqué sur "Heberger" arrivera sur cette page où il attends la connection de son adversaire. Il faut qu'il lui communique son adresse ip pour qu'il se connecte.

![Image page héberger de l'application](imagesReadme/heberger.png "Page héberger")

- Rejoindre

Si vous avez cliqué sur rejoindre à l'étape précédente, vous arriverez sur cette page. Il faut insérer l'adresse ip de l'hébergeur pour se connecter.

![Image page rejoindre de l'application](imagesReadme/rejoindre.png "Page rejoindre")

- Magasin

Une fois la connexion établie, les joueurs doivent chosir leurs combattants. Ils ont plusieurs niveaux de rareté comme "Légendaire", "Rare", "Commun". Ces niveaux déterminent les compétences des entités. Plus les entitées sont rares, moins elles apparraissent. Un joueur doit choisir 5 entités qui seront utilisés pour le combat avec son adversaire.

![Image page magasin de l'application](imagesReadme/magasin.png "Page magasin")

- Combat

C'est maintenant que le combat commence. Le combat se termine lorsque l'un des deux joueurs n'as plus d'entitées dans son deck. À chaque tour, il faut choisir un champion qui sera celui qui se bat et ensuite cliquer sur le bouton "Se battre !".

![Image page combat de l'application](imagesReadme/combat.png "Page combat")

- Victoire

Une fois la partie terminée, le gagnant a un écran de victoire.

![Image page victoire de l'application](imagesReadme/victoire.png "Page victoire")

Le perdant a un écran de défaite.

![Image page défaite de l'application](imagesReadme/defaite.png "Page defaite")

## Besoins fonctionnels/non-fonctionnels
### Besoins fonctionnels
- En tant que client, je veux que l'application utilise des classes abstraites pour répondre à mes exigences techniques.

- En tant que client, je veux que l'application utilise des interfaces pour répondre à mes exigences techniques.

- En tant que client, je veux que l'application utilise des itérateurs pour répondre à mes exigences techniques.

- En tant que client, je veux que l'application utilise des collections pour répondre à mes exigences techniques.

- En tant que client, je veux que l'application utilise des exceptions pour répondre à mes exigences techniques.

- En tant que client, je veux que l'application utilise des threads pour répondre à mes exigences techniques.

- En tant que client, je veux que l'application utilise de la généricité pour répondre à mes exigences techniques.

### Besoins non-fonctionnels

- En tant que joueur, je veux héberger une partie pour jouer avec mes amis.

- En tant que joueur, je veux rejoindre une partie pour rejoindre mes amis.

- En tant que joueur, je veux acheter des personnages pour construire mon équipe.

- En tant que joueur, je veux choisir un personnage pour attaquer mon adversaire.

- En tant que joueur, je veux avoir une interface pour les personnages afin de jouer plus facilement.

- En tant que joueur, je veux avoir des personnages de différents types pour avoir de la diversité dans mon équipe.

- En tant que joueur, je veux que les personnages aient des stats différentes pour que certains soient plus forts que d'autres.

- En tant que joueur, je veux que les personnages aient des raretés différentes pour que les personnages aient des taux de drop différents.

- En tant que joueur, je veux un magasin aléatoire pour que chaque partie soit différente.

- En tant que joueur débutant, je veux une légende pour la rareté afin de savoir ce qui est le plus rare.

### Diagramme de cas d'utilisation

![Image diagramme de cas d'utilisation](imagesReadme/diagrammeCasUtilisation.png "Diagramme de cas d'utilisation")

### Écart avec les prévisions

Au départ, nous étions partis sur l'idée de faire un jeu avec intéraction via le terminal. Finalement, nous avons décidé de faire un jeu avec interface graphique afin de le rendre plus interractif. De plus, nous l'avons rendu multijoueur et jouable en LAN pour pouvoir jouer à deux. Un ordinateur fait office de serveur, et l'autre de client.

### Mesures d'amélioration

Pour améliorer notre projet, nous aurions pu créer une classe qui gère toute la partie aléatoire de l'application. Ceci nous aurait permis de la rendre plus testable/propre.

### Diagramme de classes

## Membres du projet 🧑‍💻

Ceccarelli Luca</br>
Egenscheviller Frédéric</br>
Saadi Nils
