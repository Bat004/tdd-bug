# Password Validator

Implémentez en **TDD** un validateur de mot de passe.

Le projet ne contient qu'un `HelloWorld` et son test, pour vérifier que votre installation fonctionne. Supprimez-les quand vous démarrez : à vous d'écrire le premier test, puis de générer le code depuis son usage.

## Les règles

Un mot de passe est **valide** s'il respecte toutes les règles suivantes :

| # | Règle                                    | Erreur si la règle n'est pas respectée |
|---|------------------------------------------|----------------------------------------|
| 1 | Au moins **8 caractères**                | `TOO_SHORT`                            |
| 2 | Au moins **une majuscule**               | `NO_UPPERCASE`                         |
| 3 | Au moins **une minuscule**               | `NO_LOWERCASE`                         |
| 4 | Au moins **un chiffre**                  | `NO_DIGIT`                             |
| 5 | Au moins **un caractère spécial** parmi `. * # @ $ % &` | `NO_SPECIAL_CHAR`       |

Un mot de passe `null` est **refusé sans lever d'exception** : il est traité comme un mot de passe vide.

## Le contrat attendu

Le validateur expose **deux méthodes** :

### Java

```java
// Retourne les erreurs de toutes les règles non respectées, dans l'ordre des règles (liste vide si le mot de passe est valide)
List<PasswordError> validate(String password)

// Indique si le mot de passe respecte toutes les règles
boolean isValid(String password)
```

### C\#

```csharp
// Retourne les erreurs de toutes les règles non respectées, dans l'ordre des règles (liste vide si le mot de passe est valide)
IReadOnlyList<PasswordError> Validate(string? password)

// Indique si le mot de passe respecte toutes les règles
bool IsValid(string? password)
```

## Démarche conseillée

1. Commencez par `isValid`, une règle à la fois : la règle 1, puis 2, 3, 4, 5, puis le cas `null`.
2. Passez ensuite à `validate`, qui retourne la liste des erreurs.
3. Pour chaque règle, pensez aux **valeurs limites** : 7, 8 et 9 caractères, par exemple.

## Bonus

- La longueur minimale est **configurable**

## Lancer les tests

### Java

```bash
cd java
mvn test
```

### C\#

```bash
cd csharp
dotnet test
```
