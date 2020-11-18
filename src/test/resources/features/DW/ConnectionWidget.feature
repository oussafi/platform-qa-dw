Feature: Vérification de la widget connexion
  En tant qu’ utilisateur
  Je veux vérifier mes connexions dans la page d'acceuil
  Afin de valider la page

  Scenario: US 3.3.3_(01)[BACK] No Connection requests to join
    Given Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    And L'utilisateur suivant est crée
      | Utilisateur               | userus3331                 |
      | Prénom                    | userUS3                    |
      | Nom                       | userUS3                    |
      | Email                     | userus3331@userUS3.userUS3 |
      | Mot de passe              | 123456789                  |
      | Confirmer le mot de passe | 123456789                  |
    When Je change l'utilisateur
      | login    | userus3331 |
      | password | 123456789  |
    Then Le nombre 'Contacts' est '0'


  Scenario: US 3.3.3_(02) [BACK] No Connection requests number
    Given Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    And L'utilisateur suivant est crée
      | Utilisateur               | userus33320                 |
      | Prénom                    | userUS3                     |
      | Nom                       | userUS3                     |
      | Email                     | userus33320@userUS3.userUS3 |
      | Mot de passe              | 123456789                   |
      | Confirmer le mot de passe | 123456789                   |
    And L'utilisateur suivant est crée
      | Utilisateur               | userus33322                 |
      | Prénom                    | userUS3                     |
      | Nom                       | userUS3                     |
      | Email                     | userus33322@userUS3.userUS3 |
      | Mot de passe              | 123456789                   |
      | Confirmer le mot de passe | 123456789                   |
    And L'utilisateur suivant est crée
      | Utilisateur               | userus33323                 |
      | Prénom                    | userUS3                     |
      | Nom                       | userUS3                     |
      | Email                     | userus33323@userUS3.userUS3 |
      | Mot de passe              | 123456789                   |
      | Confirmer le mot de passe | 123456789                   |
    And L'utilisateur suivant est crée
      | Utilisateur               | userus33324                 |
      | Prénom                    | userUS3                     |
      | Nom                       | userUS3                     |
      | Email                     | userus33324@userUS3.userUS3 |
      | Mot de passe              | 123456789                   |
      | Confirmer le mot de passe | 123456789                   |
    And L'utilisateur suivant est crée
      | Utilisateur               | userus33325                 |
      | Prénom                    | userUS3                     |
      | Nom                       | userUS3                     |
      | Email                     | userus33325@userUS3.userUS3 |
      | Mot de passe              | 123456789                   |
      | Confirmer le mot de passe | 123456789                   |
    And Je connecte avec l'utilisateur'userus33325'
    And Je change l'utilisateur
      | login    | userus33320 |
      | password | 123456789   |
    And Je connecte avec l'utilisateur'userus33325'
    And Je change l'utilisateur
      | login    | userus33322 |
      | password | 123456789   |
    And Je connecte avec l'utilisateur'userus33325'
    And Je change l'utilisateur
      | login    | userus33323 |
      | password | 123456789   |
    And Je connecte avec l'utilisateur'userus33325'
    And Je change l'utilisateur
      | login    | userus33324 |
      | password | 123456789   |
    And Je connecte avec l'utilisateur'userus33325'
    When  Je change l'utilisateur
      | login    | userus33325 |
      | password | 123456789   |
    Then le nombre des demandes de connexion est '5'


  Scenario:US 3.3.4_(01) [BACK] Spaces requests to join: See All
    Given Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    And L'utilisateur suivant est crée
      | Utilisateur               | userus33341                 |
      | Prénom                    | userUS3                     |
      | Nom                       | userUS3                     |
      | Email                     | userus33341@userUS3.userUS3 |
      | Mot de passe              | 123456789                   |
      | Confirmer le mot de passe | 123456789                   |
    And L'utilisateur suivant est crée
      | Utilisateur               | userus33342                 |
      | Prénom                    | userUS3                     |
      | Nom                       | userUS3                     |
      | Email                     | userus33342@userUS3.userUS3 |
      | Mot de passe              | 123456789                   |
      | Confirmer le mot de passe | 123456789                   |
    And L'utilisateur suivant est crée
      | Utilisateur               | userus33343                 |
      | Prénom                    | userUS3                     |
      | Nom                       | userUS3                     |
      | Email                     | userus33343@userUS3.userUS3 |
      | Mot de passe              | 123456789                   |
      | Confirmer le mot de passe | 123456789                   |
    And L'utilisateur suivant est crée
      | Utilisateur               | userus33344                 |
      | Prénom                    | userUS3                     |
      | Nom                       | userUS3                     |
      | Email                     | userus33344@userUS3.userUS3 |
      | Mot de passe              | 123456789                   |
      | Confirmer le mot de passe | 123456789                   |
    And L'utilisateur suivant est crée
      | Utilisateur               | userus33345                 |
      | Prénom                    | userUS3                     |
      | Nom                       | userUS3                     |
      | Email                     | userus33345@userUS3.userUS3 |
      | Mot de passe              | 123456789                   |
      | Confirmer le mot de passe | 123456789                   |
    And Je connecte avec l'utilisateur'userus33345'
    And Je change l'utilisateur
      | login    | userus33341 |
      | password | 123456789   |
    And Je connecte avec l'utilisateur'userus33345'
    And Je change l'utilisateur
      | login    | userus33342 |
      | password | 123456789   |
    And Je connecte avec l'utilisateur'userus33345'
    And Je change l'utilisateur
      | login    | userus33343 |
      | password | 123456789   |
    And Je connecte avec l'utilisateur'userus33345'
    And Je change l'utilisateur
      | login    | userus33344 |
      | password | 123456789   |
    And Je connecte avec l'utilisateur'userus33345'
    When  Je change l'utilisateur
      | login    | userus33345 |
      | password | 123456789   |
    And je clique sur le badge '5'
    Then le drawer contient '3' connexions est ouvert

  Scenario:US 3.3.4_(02)[BACK]Connections requests : accept and reject
    Given Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    And L'utilisateur suivant est crée
      | Utilisateur               | userus333423                 |
      | Prénom                    | userUSaccept                 |
      | Nom                       | userUS3                      |
      | Email                     | userus333423@userUS3.userUS3 |
      | Mot de passe              | 123456789                    |
      | Confirmer le mot de passe | 123456789                    |
    And L'utilisateur suivant est crée
      | Utilisateur               | userus333424                 |
      | Prénom                    | userUSreject                 |
      | Nom                       | userUS3                      |
      | Email                     | userus333424@userUS3.userUS3 |
      | Mot de passe              | 123456789                    |
      | Confirmer le mot de passe | 123456789                    |
    And L'utilisateur suivant est crée
      | Utilisateur               | userus333425                 |
      | Prénom                    | userUS3                      |
      | Nom                       | userUS3                      |
      | Email                     | userus333425@userUS3.userUS3 |
      | Mot de passe              | 123456789                    |
      | Confirmer le mot de passe | 123456789                    |
    And Je connecte avec l'utilisateur'userus333425'
    And Je change l'utilisateur
      | login    | userus333423 |
      | password | 123456789    |
    And Je connecte avec l'utilisateur'userus333425'
    And Je change l'utilisateur
      | login    | userus333424 |
      | password | 123456789    |
    And Je connecte avec l'utilisateur'userus333425'
    When  Je change l'utilisateur
      | login    | userus333425 |
      | password | 123456789    |
    And je clique sur le badge '3'
    And j'accepte l'invitation des connexions suivant
      | John         |
      | userUSaccept |
    And je rejecte l'invitation des connexions suivant
      | userUSreject |
    Then Le nombre 'Contacts' est '2'
