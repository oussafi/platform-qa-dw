# language: fr
Fonctionnalité: Partager les articles
  En tant qu’ utilisateur
  Je veux partager des news
  Afin de les partager avec mes collaborateur


  Scénario: CAP10 - [US-ShareNews-01] : "share" button enabled when user select a space
    Etant donné Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    Et l'espace 'CAP10-2' est crée
    Et l'espace 'CAP10' est crée
    Quand je clique sur poster dans l'espace
    Et je clique sur 'écrire un article'
    Et j'ajoute un article contenant une image <cap02.png>
      | Titre   | ArticleTitreCAP10   |
      | Résumé  | ArticleRésuméCAP10  |
      | Contenu | ArticleContenuCAP10 |
    Et je clique sur le titre de l'article dans l'activity stream
    Et l'article est affiché avec l'image ajoutée dans l'activity stream de l'espace
    Et je clique sur 'Partager'
    Et je choisis l'espace 'CAP10-2' pour partager l'article
    Alors le button partager est activé

  Scénario: CAP12 - [US-ShareNews-01] : show the details of the shared article in space
    Etant donné Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    Et l'espace 'CAP12-2' est crée
    Et l'espace 'CAP12' est crée
    Quand je clique sur poster dans l'espace
    Et je clique sur 'écrire un article'
    Et j'ajoute un article contenant une image <cap02.png>
      | Titre   | ArticleTitreCAP12   |
      | Résumé  | ArticleRésuméCAP12  |
      | Contenu | ArticleContenuCAP12 |
    Et je clique sur le titre de l'article dans l'activity stream
    Et l'article est affiché avec l'image ajoutée dans l'activity stream de l'espace
    Et je clique sur 'Partager'
    Et je partage l'article avec l'espace 'CAP12-2' et la description'CAP12-2-description'
    Et je navigue vers l'espace 'CAP12-2'
    Et je clique sur le titre de l'article dans l'activity stream
    Alors l'article est affiché avec l'image ajoutée dans l'activity stream de l'espace

  Scénario: CAP18 - [US-ShareNews-01] : check the confirmation message when user share an article
    Etant donné Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    Et l'espace 'CAP18-2' est crée
    Et l'espace 'CAP18' est crée
    Quand je clique sur poster dans l'espace
    Et je clique sur 'écrire un article'
    Et j'ajoute un article contenant une image <cap02.png>
      | Titre   | ArticleTitreCAP18   |
      | Résumé  | ArticleRésuméCAP18  |
      | Contenu | ArticleContenuCAP18 |
    Et je clique sur le titre de l'article dans l'activity stream
    Et l'article est affiché avec l'image ajoutée dans l'activity stream de l'espace
    Et je clique sur 'Partager'
    Et je partage l'article avec l'espace 'CAP18-2' et la description'CAP18-2-description'
    Alors un message de succès est affiché