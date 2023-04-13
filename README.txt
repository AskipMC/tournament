Pour le système de connexion du site, c'est stocké dans le cache donc à chaque actualisation ca deconnecte.
Nous n'avons pas eu le temps de faire autrement.

Installation de la base de donnée :
- Ouvrir WSL (ubuntu)
- sudo apt update
- sudo apt-get install mariadb-server mariadb-client -y
- sudo apt update
- Verifier si Mariadb est bien installé : sudo service mariadb status ou mariadb --version
- Pour lancer Mariadb : sudo service mariadb start

Pour créer la Database :
- sudo mysql -u root
- CREATE DATABASE tournament
- CREATE USER 'admin2'@'localhost' IDENTIFIED BY 'password'
- GRANT ALL PRIVILEGES ON *.* TO 'admin2'@'localhost';
- FLUSH PRIVILEGES

Pour lancer le front (vuejs-frontend) :
- Avoir NodeJs sur l'odinateur
- Aller dans le fichier vuejs-frontend :
	- npm install
	- npm install vue
	- npm install buefy
	- peut être vuex aussi à installer
	- si yarn est installé : il suffit de tapper yarn et ca installe toutes les dépendances

Pour lancer le backend :
- Aller dans le dossier tournament du dossier tournament puis ouvrir dans intellJ et le lancer

ATTENTION : les ports sont ceux de base, il faut lancer le backend avant le front comme ca le backend prend le port 8080 et le front le 8081 !