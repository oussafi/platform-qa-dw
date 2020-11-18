Feature: Insérer des liens
  En tant qu’ utilisateur
  Je veux publier des liens via le new composer
  Afin de les partager avec mes collaborateur

  Scenario: CAP29-[US-insertLink-01]: insert a link from composer drawer (space case)
    Given Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    And l'espace 'ShortMessageCAP29' est crée
    When je clique sur poster dans l'espace
    And je saisie une activité 'https://www.exoplatform.com/'
    And je publie l'activité
    Then Le lien est affiché avec le preview