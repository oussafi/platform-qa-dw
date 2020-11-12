# language: fr
Fonctionnalité: Publication des activités
  En tant qu’ utilisateur
  Je veux publier des activité
  Afin de les partager avec mes collaborateur
@execute
  Scénario: CAP03 - [US-ShortMessage-01]: post a short message from drawer
    Etant donné Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    Et l'espace 'ShortMessageCAP03' est crée
    Quand je clique sur poster dans l'espace
    Et je saisie une activité 'activité CAP03'
    Et je publie l'activité
    Alors l'activité 'activité CAP03' est affiché dans l'activity stream
