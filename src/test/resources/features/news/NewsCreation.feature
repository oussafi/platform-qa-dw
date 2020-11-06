# language: fr
Fonctionnalité: Création des news
  En tant qu’ utilisateur
  Je veux créer des news
  Afin de les partager avec mes collaborateur

  Scénario: CAP04 - [US-NewsCreation-01]Check the display of the "write an article" Link under the activity composer box
    Etant donné Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    Et l'espace 'CAP04' est crée
    Quand je clique sur poster dans l'espace
    Alors le lien 'écrire un article' est affiché dans le drawer
