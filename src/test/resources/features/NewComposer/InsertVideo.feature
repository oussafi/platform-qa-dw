# language: fr
Fonctionnalité: Insérer des videos
  En tant qu’ utilisateur
  Je veux publier des videos via le new composer
  Afin de les partager avec mes collaborateur

  Scénario: CAP15-[US-InsertVideo-01]:Post a message with a video link
    Etant donné Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    Et l'espace 'ShortMessageCAP15' est crée
    Quand je clique sur poster dans l'espace
    Et je saisie une activité 'https://www.youtube.com/embed/wgpduVyZT50?enablejsapi=1'
    Et je publie l'activité
    Alors le video 'https://www.youtube.com/embed/wgpduVyZT50?enablejsapi=1' est affiché dans l'activity stream