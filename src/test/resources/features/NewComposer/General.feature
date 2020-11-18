Feature: New composer général
  En tant qu’ utilisateur
  Je veux manipuler des activités via le new composer
  Afin de les partager avec mes collaborateur

  Scenario: CAP97-[US-General-04]:update posts - text update (space case)
    Given Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    And l'espace 'ShortMessageCAP97' est crée
    When je clique sur poster dans l'espace
    And je saisie une activité 'activité CAP97'
    And je publie l'activité
    And je clique sur modifier l'activité
    And je saisie une activité 'activité CAP97 edited'
    And je publie l'activité
    And l'activité 'activité CAP97 edited' est affiché dans l'activity stream

  @Pending @Wait_Until_fixing_Bug
  Scenario: CAP109-[US-General-07]:update posts - text update with normal Link (space case)
    Given Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    And l'espace 'US-General-07' est crée
    When je clique sur poster dans l'espace
    And je saisie une activité 'activité CAP109'
    And je saisie une activité 'https://www.exoplatform.com/'
    And je publie l'activité
    And je clique sur modifier l'activité
    And je saisie une activité 'modifier le lien'
    And je publie l'activité
    Then l'activité 'modifier le lien' est affiché dans l'activity stream
    And Le lien est affiché avec le preview

  @Pending @Wait_Until_fixing_Bug
  Scenario: CAP110 - [US-General-07] : update posts - text update with video Link (space case)
    Given Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    And l'espace 'US-General-07-CAP110' est crée
    When je clique sur poster dans l'espace
    And je saisie une activité 'activité CAP110'
    And je saisie une activité 'https://www.youtube.com/embed/wgpduVyZT50?enablejsapi=1'
    And je publie l'activité
    And je clique sur modifier l'activité
    And je saisie une activité 'modifier le lien'
    And je publie l'activité
    Then l'activité 'modifier le lien' est affiché dans l'activity stream
    And le video 'https://www.youtube.com/embed/wgpduVyZT50?enablejsapi=1' est affiché dans l'activity stream
