# Bug Report : ShoppingCart

> **Ticket #4271 : Remise incorrecte après suppression d'un article**
>
> **Signalé par** : Marie D. (support client)
> **Priorité** : Haute
>
> **Description** :
> Un client a ajouté un ordinateur à 120 € dans son panier (remise de 10 % appliquée → total 108 €).
> Il a ensuite retiré l'ordinateur et ajouté uniquement un stylo à 5 €.
> Le total affiché était **4,50 €** au lieu de **5,00 €**.
> La remise est restée appliquée alors que le panier ne la justifiait plus.
>
> **Étapes pour reproduire** :
> 1. Ajouter un article à 120 € → total = 108 € (remise OK)
> 2. Retirer cet article → panier vide
> 3. Ajouter un article à 5 € → total attendu = 5 €, total obtenu = 4,50 €

### Règles métier du ShoppingCart

- Une **remise de 10 %** s'applique sur le total quand le sous-total atteint ou dépasse **100 €**
- La remise s'applique (ou non) dynamiquement en fonction du contenu **actuel** du panier


## À vous de jouer

### Java

```bash
cd java
mvn test
```

### C#

```bash
cd csharp
dotnet test
```

**Votre mission** : corriger le bug décrit dans le ticket #4271.
