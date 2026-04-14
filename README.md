# leerx

Application designed to browse lyrics from lrclib.net via simple & lightweight HTML Web page 
This project is non-commercial and has an educational purpose.


## The starter pack

| Action                                            | How to                                                                                                                                                                           |
|---------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Starting application (dev)**                    | ./mvnw quarkus:dev                                                                                                                                                               |
| **Starting application (prod)**                   | ./mvnw quarkus:run                                                                                                                                                               |
| **Packaging application & run tests**             | ./mvnw package                                                                                                                                                                   |
| **Start application (requires database started)** | docker run -p 5000:5000 --name leerx --pull missing --network mynet leerx:latest                                                                                                 |


## Notes
- Port 5000 is for production ports. Use 5001 for developpement environment.
- Many thanks to https://lrclib.net/. Check out their GitHub https://github.com/tranxuanthang/lrclib
- The HTML Page was vibe-coded using Copilot (I'm not a good front-end dev)
