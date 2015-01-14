# MiniHeros
1 gegen 1 Spiel mit unendlich vielen Helden

Jeder Held hat folgende Werte:
Angriff, Geschick, Hirn, Magie, Leben und Resistenz.
Das besondere ist, dass jeder Held eigene Spells hat. Jeder Spell hat seine eigene Schadensberechnung!
Der Reiz besteht daran alle Helden zu erforschen und ihre Spells herauszufinden. Je mehr Helden du kennst desto stärker bist du!

In Hero.java findet ihr ein Tutorial wie ihr euren eigenen Helden erstellen könnt.
/* Hero Erstellen geht so:
* 1. unter Classes einen neuen Eintrag machen. z.b. GOBLIN
* 2. unter MiniHeros.java in die AntwortDB funktion gehen und einen else if Zweig erstellen.
* 3. unter addDefaultValues einen neuen else if Zweig machen mit createHero(werte...)
* 4. addSpells("spellname1","spellname2",usw..);
* 5. unter SpellDB.java einen else if zweig hinzufügen und die funktionen für die spells machen!
* FERTIG!

>>>TODO LIST
- Heros erstellen!
- Spells in SpellDB.java erstellen die zu Hero.java passen!
- Java Fenster erstellen, dass die Konsole ausgibt!
- Cooldown zu jedem Spell erstellen in Hero.java
  Methode könnte so aussehen: held.getCD(Spell);
- optional: Schlauere Methode für Spellsystem finden.
