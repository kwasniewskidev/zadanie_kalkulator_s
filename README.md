Aplikacja do wyliczania zarobków netto w danym państwie.

Niezbędne do uruchomienia:
- maven do pobrania zależności
- jdk 8+ do uruchomienia

Link do dokumentacji api:
http://localhost:8080/swagger-ui.html#/

Opis budowania:
Dzięki zastosowaniu frontend-maven-plugin
część serwerowa jak i frontendowa są budowane jednocześnie,
połączone wspólnym parent modułem.

Uruchomienie,
z poziomu głównego aplikacji:
- mvn clean install
- cd backend/
- mvn spring-boot:run

Link do aplikacji:
http://localhost:8080/




