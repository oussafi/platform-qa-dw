Feature: Insérer des videos
  En tant qu’ utilisateur
  Je veux publier des videos via le new composer
  Afin de les partager avec mes collaborateur

  Scenario: CAP15-[US-InsertVideo-01]:Post a message with a video link
    Given Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    And l'espace 'ShortMessageCAP15' est crée
    When je clique sur poster dans l'espace
    And je saisie une activité 'https://www.youtube.com/embed/wgpduVyZT50?enablejsapi=1'
    And je publie l'activité
    Then le video 'https://www.youtube.com/embed/wgpduVyZT50?enablejsapi=1' est affiché dans l'activity stream