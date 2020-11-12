# language: fr
Fonctionnalité: Modification des news
  En tant qu’ utilisateur
  Je veux modifier des news
  Afin de les partager avec mes collaborateur


  Scénario: CAP26 - [US-EditNews-01]: check that the button "update" disabled by default
    Etant donné Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    Et l'espace 'CAP26' est crée
    Et je clique sur poster dans l'espace
    Et je clique sur 'écrire un article'
    Et j'ajoute un article avec les données suivants
      | Titre   | ArticleTitreCAP26   |
      | Contenu | ArticleContenuCAP26 |
    Et L'article est affiché dans l'activity stream de l'espace
    Quand je clique sur le titre de l'article dans l'activity stream
    Et je clique sur 'edit'
    Alors La page 'modifier un article' est affichée
    Et le button est désactivé par défaut

  Scénario: CAP27 - [US-EditNews-01]: update News
    Etant donné Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    Et l'espace 'CAP27' est crée
    Et je clique sur poster dans l'espace
    Et je clique sur 'écrire un article'
    Et j'ajoute un article avec les données suivants
      | Titre   | ArticleTitreCAP27   |
      | Contenu | ArticleContenuCAP27 |
    Et L'article est affiché dans l'activity stream de l'espace
    Quand je clique sur le titre de l'article dans l'activity stream
    Et je clique sur 'edit'
    Et je modifie l'article contenant une image <cap02.png>
      | Contenu | ArticleContenuCAP27Edit |
      | Titre   | ArticleTitreCAP27Edit   |
    Alors l'article modifié est affiché avec l'image ajoutée