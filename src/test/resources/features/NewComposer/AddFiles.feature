Feature: Ajout des fichiers
  En tant qu’ utilisateur
  Je veux publier des fichiers via le new composer
  Afin de les partager avec mes collaborateur

  Scenario: CAP23 - [US-AddFiles-01]: upload a file by using "upload manually" option (space case)
    Given Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    And l'espace 'AddFilesCAP23' est crée
    When je clique sur poster dans l'espace
    And j'atache le fichier 'text.txt'
    And je saisie une activité 'activité CAP23'
    And je publie l'activité
    Then l'activité 'activité CAP23' est affiché dans l'activity stream
    And le fichier 'text.txt' est partagé dans l'activity stream

  Scenario: CAP20-[US-AddFiles-01]:upload a file by using "Select from Drives" option
    Given Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    And l'espace 'AddFilesCAP20' est crée
    And je navigue vars 'Documents' tab
    And je télécharge le fichier 'text.txt'
    And je navigue vars 'Activité' tab
    When je clique sur poster dans l'espace
    And je selectionne le fichier existant 'text.txt'
    And je saisie une activité 'activité CAP20'
    And je publie l'activité
    Then l'activité 'activité CAP20' est affiché dans l'activity stream
    And le fichier 'text.txt' est partagé dans l'activity stream


  Scenario: CAP19-[US-AddFiles-01]:Upload a file by using "Drag and Drop" option
    Given Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    And l'espace 'AddFilesCAP19' est crée
    When je clique sur poster dans l'espace
    And j'atache le fichier 'text.txt'
    And je saisie une activité 'activité CAP19'
    And je publie l'activité
    Then l'activité 'activité CAP19' est affiché dans l'activity stream
    And le fichier 'text.txt' est partagé dans l'activity stream
    When je navigue vars 'Documents' tab
    And je selectionne le repertoire 'Activity Stream Documents'
    Then Le fichier 'text.txt' est téléchargé

  Scenario: CAP33-[US-Extensibility-01]:user writes an article by using "write an article" area in the composer drawer
    Given Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    And l'espace 'ExtensibilityCAP33' est crée
    When je clique sur poster dans l'espace
    And je clique sur 'écrire un article'
    And j'ajoute un article contenant une image <cap02.png>
      | Titre   | ArticleTitreCAP33   |
      | Résumé  | ArticleRésuméCAP33  |
      | Contenu | ArticleContenuCAP33 |
    Then l'article est affiché avec l'image ajoutée