Overzicht van alle aanwezige features:

------------------- Algemeen-----------------------------

- Bottom navigatie voor verschillende schermen
- Aangepaste startlogo van de applicatie in de manifest

--------------- Uitgaves/ inkomsten---------------------

- Mogelijkheid om een nieuw inkomst toe te voegen 
- Mogelijkheid om een nieuw Uitgave toe te voegen
  → er wordt nog altijd gevraagd van welke type item er moet aangemaakt worden in het create scherm. 
  → deze worden allemaal in recyclervieuws aangeboden. 
  → Teller met totaal van elke categorie

- mogelijkheid van op een item ( card ) te klikken voor naar de details te gaan van dit item. 
  → hierin de mogelijkheid om dit item te verwijderen, of terug te keren. 

- 

---------------- Dashboard --------------------

- Een overzicht van alle tellers van de applicatie 
- Een teller die de " balans" voorstelt , verschil tussen inkomsten een uitgave

- een Progression-bar die het overblijvende budget  ( balans ) voorsteld, deze is dynamisch en wordt aangepast na elke verandering
  → deze veranderd van kleur i.v.m. het budget die overblijft. 

- De mogelijkheid van een limiet in te stellen 
  → deze blijft enkel aanstaan tijdens het gebruik van applicatie, na elke terugkomst moet deze terug aangezet worden. 
  → Deze wordt ingesteld via een popup
  → Bij het toevoegen van een uitgave, als deze uitgave ervoor gaat zorgen dat deze de limiet niet meer respecteert, gaat deze een popup geven, met twee mogelijkheden
    → toch aanmaken, popup gaat dicht, en de user mag op create drukken
    → niet aanmaken, gaat terug naar de dashboard om de limiet aan te passen. 


  ----------- Preferences----------------------

- De gebruikersvoorwaarden

  → Als deze niet aanstaan, gaat er een snackbar gegeneerd worden met een knop voor naar de parameters te gaan, en deze te accepteren. Worden deze achteraf terug uitgeschakeld, zal de popup opnieuw op het scherm komen.
  → dit komt enkel tevoorschijn op de dashboard, de dashboard bevat een appbar die anders is dan andere schermen, hier is enkel de parameters-knop beschikbaar niet op andere schermen. 

- Mogelijkheid om zijn taal aan te passen 

  → 3 talen mogelijk
  → na aanpassen van de taal, zal de popup wijzen dat de veranderingen worden bewaart na het terugkeren naar de dashboard en biedt en knop aan om naar deze terug te keren. 
  → de 3 talen zijn beschikbaar op alle schermen van de applicatie 
  
---------------------------------------------------------------------  
  
Bronnen:

- Flaticon voor het gebruik van icons in de app. 
  → https://www.flaticon.com/fr/ 


- Android dev documentatie
  → https://developer.android.com/docs 


- Android hive voor documentatie
  https://www.androidhive.info/ 
