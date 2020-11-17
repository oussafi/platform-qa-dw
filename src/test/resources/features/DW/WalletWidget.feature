# language: fr
Fonctionnalité: Vérifications du wallet Widget
  En tant qu’ utilisateur
  Je veux vérifier news wallet dans la page d'acceuil
  Afin de le valider

  Scénario: US 3.4.1[BACK]Add wallet widget
    Etant donné Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    Et les sections suivants sont affiché
      | Wallet |
    Quand je clique sur wallet label
    Alors la page wallet est ouverte
