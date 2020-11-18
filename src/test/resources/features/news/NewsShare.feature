Feature: Partager les articles
  En tant qu’ utilisateur
  Je veux partager des news
  Afin de les partager avec mes collaborateur

  Scenario: CAP10 - [US-ShareNews-01] : "share" button enabled when user select a space
    Given Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    And l'espace 'CAP10-2' est crée
    And l'espace 'CAP10' est crée
    When je clique sur poster dans l'espace
    And je clique sur 'écrire un article'
    And j'ajoute un article contenant une image <cap02.png>
      | Titre   | ArticleTitreCAP10   |
      | Résumé  | ArticleRésuméCAP10  |
      | Contenu | ArticleContenuCAP10 |
    And je clique sur le titre de l'article dans l'activity stream
    And l'article est affiché avec l'image ajoutée dans l'activity stream de l'espace
    And je clique sur 'Partager'
    And je choisis l'espace 'CAP10-2' pour partager l'article
    Then le button partager est activé

  Scenario: CAP12 - [US-ShareNews-01] : show the details of the shared article in space
    Given Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    And l'espace 'CAP12-2' est crée
    And l'espace 'CAP12' est crée
    When je clique sur poster dans l'espace
    And je clique sur 'écrire un article'
    And j'ajoute un article contenant une image <cap02.png>
      | Titre   | ArticleTitreCAP12   |
      | Résumé  | ArticleRésuméCAP12  |
      | Contenu | ArticleContenuCAP12 |
    And je clique sur le titre de l'article dans l'activity stream
    And l'article est affiché avec l'image ajoutée dans l'activity stream de l'espace
    And je clique sur 'Partager'
    And je partage l'article avec l'espace 'CAP12-2' et la description'CAP12-2-description'
    And je navigue vers l'espace 'CAP12-2'
    And je clique sur le titre de l'article dans l'activity stream
    Then l'article est affiché avec l'image ajoutée dans l'activity stream de l'espace

  Scenario: CAP18 - [US-ShareNews-01] : check the confirmation message when user share an article
    Given Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    And l'espace 'CAP18-2' est crée
    And l'espace 'CAP18' est crée
    When je clique sur poster dans l'espace
    And je clique sur 'écrire un article'
    And j'ajoute un article contenant une image <cap02.png>
      | Titre   | ArticleTitreCAP18   |
      | Résumé  | ArticleRésuméCAP18  |
      | Contenu | ArticleContenuCAP18 |
    And je clique sur le titre de l'article dans l'activity stream
    And l'article est affiché avec l'image ajoutée dans l'activity stream de l'espace
    And je clique sur 'Partager'
    And je partage l'article avec l'espace 'CAP18-2' et la description'CAP18-2-description'
    Then un message de succès est affiché