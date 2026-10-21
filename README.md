# Casale

Backend per la gestione delle prenotazioni e del menu di un agriturismo, sviluppato con Java e Spring Boot.

> **Stato del progetto:** in sviluppo. Il modello dati è impostato, i servizi e le API sono in lavorazione.

## Obiettivo

Un sito per un agriturismo a conduzione familiare, con:

- **Prenotazione del tavolo** con controllo dei posti disponibili per data e turno
- **Menu gestito da database**, modificabile senza caricare PDF
- **Area riservata** per il titolare, per confermare o rifiutare le richieste

## Stack

| Parte | Tecnologia |
|---|---|
| Linguaggio | Java 25 |
| Framework | Spring Boot 4.0.6 (Spring MVC, Spring Data JPA) |
| Persistenza | Hibernate, H2 in sviluppo |
| Build | Maven (con Maven Wrapper) |
| Utilità | Lombok |

## Modello dati

- `Restaurant`: il locale, con orari di apertura e capienza
- `Reservation`: la richiesta di prenotazione, con stato `PENDING`, `CONFIRMED` o `REJECTED`
- `Client`: i dati di contatto di chi prenota
- `Admin`: il titolare che gestisce le richieste
- `MenuItem` e `Category`: i piatti del menu e le loro categorie
- `RestaurantTable`: i tavoli del locale

## Struttura del progetto

```
src/main/java/lixef/gg/casale/
├─ enums/      stati e categorie
├─ model/      entità JPA
├─ repo/       repository Spring Data
├─ services/   logica applicativa
└─ CasaleApplication.java
```

## Come avviarlo

Servono solo **Java 25 o superiore** e Git. Maven non va installato, perché il progetto include il wrapper.

```bash
git clone https://github.com/FixeLOne/casale.git
cd casale

# Linux / macOS
./mvnw spring-boot:run

# Windows
mvnw.cmd spring-boot:run
```

L'applicazione parte su `http://localhost:8080`.

## Configurazione

In sviluppo il database è H2 su file. La configurazione sta in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:h2:file:~/casale;AUTO_SERVER=TRUE
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Le tabelle vengono create da Hibernate all'avvio. Il file del database non va aggiunto al repository.

## Roadmap

- [x] Entità JPA e configurazione del database
- [ ] Salvataggio delle prenotazioni (repository, service, controller)
- [ ] Controllo dei posti disponibili per data e turno
- [ ] Validazione delle richieste e gestione degli errori
- [ ] Protezione dalle richieste di spam (verifica via email, rate limit)
- [ ] Menu da database con filtri per categoria
- [ ] Area admin con autenticazione
- [ ] Test automatici con JUnit e Mockito
- [ ] Database PostgreSQL e container Docker
- [ ] Deploy su AWS

## Note

Progetto personale, realizzato per un agriturismo reale e usato per esercitarsi con Spring Boot, JPA e il deploy su cloud.
