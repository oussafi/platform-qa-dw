Feature: Vérification des sliders
  En tant qu’ utilisateur
  Je veux vérifier les sliders dans la page d'acceuil
  Afin de valider la page

  Scenario: CAP01-US3:6 sections for the new Homepage
    Given Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    Then les sections suivants sont affiché
      | Article              |
      | Dernières actualités |
      | Statistique          |
      | Taches               |
      | Documents            |

  Scenario: CAP02-US 3.1[FRONT]_(01):Add a Slider section in the new Homepage
    Given Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    Then le slider est affiché dans la page d'acceuil