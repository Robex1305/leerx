# leerx

Application designed to scrap, store and expose lyrics from songs via RESTfull API.
This project is non-commercial and has an educational purpose.


## The starter pack

| Action                                            | How to                                                                                                                                                                           |
|---------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Starting application (dev)**                    | ./mvnw quarkus:dev                                                                                                                                                               |
| **Starting application (prod)**                   | ./mvnw quarkus:run                                                                                                                                                               |
| **Packaging application & run tests**             | ./mvnw package                                                                                                                                                                   |
| **Start database**                                | docker run -p 3306:3306 --env MARIADB_ALLOW_EMPTY_ROOT_PASSWORD=1 --env MARIADB_DATABASE=test --name mariadb --pull missing -v bdd:/var/lib/mysql --network mynet mariadb:latest |
| **Start application (requires database started)** | docker run -p 5000:5000 --name leerx --pull missing --network mynet leerx:latest                                                                                                 |


## Notes
- In order to run containers, you must first create a volume for data persistance with "docker volume create bdd" and a custom network "docker network create mynet".
- Port 3306 & 5000 are production ports. Use 3307 & 5001 for developpement use.
- XAMPP was used for developpement database, you can get it here for free https://www.apachefriends.org/fr/index.html
- This project was built using GraalVM 21 and WSL to host docker containers

*This project uses Quarkus, the Supersonic Subatomic Java Framework.
If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.*
