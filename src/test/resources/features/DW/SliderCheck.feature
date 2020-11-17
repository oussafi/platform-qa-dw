# language: fr
Fonctionnalité: Vérification des sliders
  En tant qu’ utilisateur
  Je veux vérifier les sliders dans la page d'acceuil
  Afin de valider la page

  Scénario: CAP01-US3:6 sections for the new Homepage
    Etant donné Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    Alors les sections suivants sont affiché
      | Article              |
      | Dernières actualités |
      | Statistique          |
      | Taches               |
      | Documents            |

  Scénario:CAP02-US 3.1[FRONT]_(01):Add a Slider section in the new Homepage
    Etant donné Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    Alors le slider est affiché dans la page d'acceuil