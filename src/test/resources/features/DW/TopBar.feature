Feature: Vérification de la top barre
  En tant qu’ utilisateur
  Je veux vérifier la top barre dans la page d'acceuil
  Afin de valider la page

  @execute
  Scenario:CAP31-US 7.7[FRONT]_(01):My applications button on Desktop
    Given Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    Then Le button mes applications est affiché