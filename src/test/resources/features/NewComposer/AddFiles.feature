# language: fr
Fonctionnalité: Ajout des fichiers
  En tant qu’ utilisateur
  Je veux publier des fichiers via le new composer
  Afin de les partager avec mes collaborateur

  Scénario: CAP23 - [US-AddFiles-01]: upload a file by using "upload manually" option (space case)
    Etant donné Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    Et l'espace 'AddFilesCAP23' est crée
    Quand je clique sur poster dans l'espace
    Et j'atache le fichier 'text.txt'
    Et je saisie une activité 'activité CAP23'
    Et je publie l'activité
    Alors l'activité 'activité CAP23' est affiché dans l'activity stream
    Et le fichier 'text.txt' est partagé dans l'activity stream

  Scénario: CAP20-[US-AddFiles-01]:upload a file by using "Select from Drives" option
    Etant donné Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    Et l'espace 'AddFilesCAP20' est crée
    Et je navigue vars 'Documents' tab
    Et je télécharge le fichier 'text.txt'
    Et je navigue vars 'Activité' tab
    Quand je clique sur poster dans l'espace
    Et je selectionne le fichier existant 'text.txt'
    Et je saisie une activité 'activité CAP20'
    Et je publie l'activité
    Alors l'activité 'activité CAP20' est affiché dans l'activity stream
    Et le fichier 'text.txt' est partagé dans l'activity stream


  Scénario: CAP19-[US-AddFiles-01]:Upload a file by using "Drag and Drop" option
    Etant donné Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    Et l'espace 'AddFilesCAP19' est crée
    Quand je clique sur poster dans l'espace
    Et j'atache le fichier 'text.txt'
    Et je saisie une activité 'activité CAP19'
    Et je publie l'activité
    Alors l'activité 'activité CAP19' est affiché dans l'activity stream
    Et le fichier 'text.txt' est partagé dans l'activity stream
    Quand je navigue vars 'Documents' tab
    Et je selectionne le repertoire 'Activity Stream Documents'
    Alors Le fichier 'text.txt' est téléchargé

  Scénario: CAP33-[US-Extensibility-01]:user writes an article by using "write an article" area in the composer drawer
    Etant donné Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    Et l'espace 'ExtensibilityCAP33' est crée
    Quand je clique sur poster dans l'espace
    Et je clique sur 'écrire un article'
    Et j'ajoute un article contenant une image <cap02.png>
      | Titre   | ArticleTitreCAP33   |
      | Résumé  | ArticleRésuméCAP33  |
      | Contenu | ArticleContenuCAP33 |
    Alors l'article est affiché avec l'image ajoutée