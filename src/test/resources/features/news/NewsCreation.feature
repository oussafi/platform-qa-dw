# language: fr
Fonctionnalité: Création des news
  En tant qu’ utilisateur
  Je veux créer des news
  Afin de les partager avec mes collaborateur

  Scénario: CAP04 - [US-NewsCreation-01]Check the display of the "write an article" Link under the activity composer box
    Etant donné Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    Et l'espace 'CAP04' est crée
    Quand je clique sur poster dans l'espace
    Alors le lien 'écrire un article' est affiché dans le drawer

  Scénario: CAP05 - [US-NewsCreation-03]Check the article in the space’s activity stream after post
    Etant donné Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    Et l'espace 'CAP05' est crée
    Quand je clique sur poster dans l'espace
    Et je clique sur 'écrire un article'
    Et j'ajoute un article avec les données suivants
      | Titre   | ArticleTitreCap05   |
      | Contenu | ArticleContenuCap05 |
    Alors L'article est affiché dans l'activity stream de l'espace

  Scénario: CAP02 - [US-NewsCreation-05] : Post an article from complete form "Write an article "
    Etant donné Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    Et l'espace 'CAP02' est crée
    Quand je clique sur poster dans l'espace
    Et je clique sur 'écrire un article'
    Et j'ajoute un article contenant une image <cap02.png>
      | Titre  | ArticleTitreCap05  |
      | Résumé | ArticleRésuméCap05 |
      | Contenu | ArticleContenuCap05 |
    Alors l'article est affiché avec l'image ajoutée

  Scénario: CAP03 - [US-NewsDetails-01] show the details of the article in the activity stream of the space when user click on the title
    Etant donné Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    Et l'espace 'CAP03' est crée
    Quand je clique sur poster dans l'espace
    Et je clique sur 'écrire un article'
    Et j'ajoute un article contenant une image <cap02.png>
      | Titre  | ArticleTitreCAP03  |
      | Résumé | ArticleRésuméCAP03 |
      | Contenu | ArticleContenuCAP03 |
    Et je clique sur le titre de l'article dans l'activity stream
    Alors l'article est affiché avec l'image ajoutée dans l'activity stream de l'espace

  Scénario: CAP08 - [US-NewsDetails-01] Click on "Read more" to show the details
    Etant donné Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    Et l'espace 'CAP08' est crée
    Quand je clique sur poster dans l'espace
    Et je clique sur 'écrire un article'
    Et j'ajoute un article contenant une image <cap02.png>
      | Titre  | ArticleTitreCAP08  |
      | Résumé | ArticleRésuméCAP08 |
      | Contenu | ArticleContenuCAP08 |
    Et je clique sur 'lire la suite' de l'article dans l'activity stream
    Alors l'article est affiché avec l'image ajoutée dans l'activity stream de l'espace