Feature: : Vérifications du wallet Widget
  En tant qu’ utilisateur
  Je veux vérifier news wallet dans la page d'acceuil
  Afin de le valider

  Scenario: : US 3.4.1[BACK]Add wallet widget
    Given Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    And les sections suivants sont affiché
      | Wallet |
    When je clique sur wallet label
    Then la page wallet est ouverte
