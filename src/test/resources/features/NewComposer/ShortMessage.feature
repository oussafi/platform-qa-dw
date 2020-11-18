Feature: Publication des activités
  En tant qu’ utilisateur
  Je veux publier des activité
  Afin de les partager avec mes collaborateur

  Scenario: CAP03 - [US-ShortMessage-01]: post a short message from drawer
    Given Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    And l'espace 'ShortMessageCAP03' est crée
    When je clique sur poster dans l'espace
    And je saisie une activité 'activité CAP03'
    And je publie l'activité
    Then l'activité 'activité CAP03' est affiché dans l'activity stream

  Scenario:CAP63 - [US-ShortMessage-02 ]:check the display "Switch to an article" link when exceeds 1300 characters (redactor case)
    Given Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    And l'espace 'ShortMessageCAP63' est crée
    When je clique sur poster dans l'espace
    And je saisie une activité plus de 1300 caractères
    Then Un lien qui permet de basculer vers un article est affiché

  Scenario:CAP64 - [US-ShortMessage-02 ]: when user click on "Switch to an article",he is redirected to a new tab (redactor case)
    Given Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    And l'espace 'ShortMessageCAP64' est crée
    When je clique sur poster dans l'espace
    And je saisie une activité plus de 1300 caractères
    And je clique sur basculer vers un article
    Then La formulaire ajouter un article est affichée
    And l'article est affiché avec le bon contenu

  Scenario:CAP86 - [US-ShortMessage-03]: check that attachments are displayed when user switch to "write an article" Form
    Given Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    And l'espace 'ShortMessageCAP86' est crée
    When je clique sur poster dans l'espace
    And je saisie une activité plus de 1300 caractères
    And j'atache le fichier 'text.txt'
    And je clique sur basculer vers un article
    Then La formulaire ajouter un article est affichée
    And l'article est affiché avec le bon contenu
    And le fichier attaché est affiché