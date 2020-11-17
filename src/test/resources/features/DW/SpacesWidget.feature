#language: fr
Fonctionnalité: Vérification des espaces
  En tant qu’ utilisateur
  Je veux vérifier les espaces dans la page d'acceuil
  Afin de valider la page


  Scénario: US 3.3.2_(01) [BACK] No Spaces requests to join
    Etant donné Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    Et L'utilisateur suivant est crée
      | Utilisateur               | userus3321              |
      | Prénom                    | userUS3                 |
      | Nom                       | userUS3                 |
      | Email                     | userUS3@userUS3.userUS3 |
      | Mot de passe              | 123456789               |
      | Confirmer le mot de passe | 123456789               |
    Quand Je change l'utilisateur
      | login    | userus3321 |
      | password | 123456789  |
    Alors Le nombre 'Espaces' est '0'


  Scénario: US 3.3.2_(02) [BACK] Spaces requests to join: See All
    Etant donné Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    Et L'utilisateur suivant est crée
      | Utilisateur               | user3322                 |
      | Prénom                    | userUS3                  |
      | Nom                       | userUS3                  |
      | Email                     | user3322@userUS3.userUS3 |
      | Mot de passe              | 123456789                |
      | Confirmer le mot de passe | 123456789                |
    Et Je créé l'espace 'userus33221' en invitant l'utilisateur 'user3322'
    Et Je créé l'espace 'userus33222' en invitant l'utilisateur 'user3322'
    Et Je créé l'espace 'userus33223' en invitant l'utilisateur 'user3322'
    Et Je créé l'espace 'userus33224' en invitant l'utilisateur 'user3322'
    Et Je créé l'espace 'userus33225' en invitant l'utilisateur 'user3322'
    Quand Je change l'utilisateur
      | login    | user3322  |
      | password | 123456789 |
    Et le nombre d'invitation pour un espace est '5'
    Et je clique sur le badge '5'
    Alors le drawer contient '3' espaces est ouvert

  @execute
  Scénario: US 3.3.2_(03) [BACK] Spaces requests to join: accept and reject
    Etant donné Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    Et L'utilisateur suivant est crée
      | Utilisateur               | user3325                 |
      | Prénom                    | userUS3                  |
      | Nom                       | userUS3                  |
      | Email                     | user3325@userUS3.userUS3 |
      | Mot de passe              | 123456789                |
      | Confirmer le mot de passe | 123456789                |
    Et Je créé l'espace 'userus33231' en invitant l'utilisateur 'user3325'
    Et Je créé l'espace 'userus33232' en invitant l'utilisateur 'user3325'
    Et Je créé l'espace 'userus33233' en invitant l'utilisateur 'user3325'
    Quand Je change l'utilisateur
      | login    | user3325  |
      | password | 123456789 |
    Et je clique sur le badge '3'
    Et j'accepte l'invitation des espaces suivant
      | userus33231 |
      | userus33233 |
    Et je rejecte l'invitation des espaces suivant
      | userus33232 |
    Alors Le nombre 'Espaces' est '2'