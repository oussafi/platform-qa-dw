# language: fr
Fonctionnalité: New composer général
  En tant qu’ utilisateur
  Je veux manipuler des activités via le new composer
  Afin de les partager avec mes collaborateur

  Scénario: CAP97-[US-General-04]:update posts - text update (space case)
    Etant donné Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    Et l'espace 'ShortMessageCAP97' est crée
    Quand je clique sur poster dans l'espace
    Et je saisie une activité 'activité CAP97'
    Et je publie l'activité
    Et je clique sur modifier l'activité
    Et je saisie une activité 'activité CAP97 edited'
    Et je publie l'activité
    Alors l'activité 'activité CAP97 edited' est affiché dans l'activity stream

  @Pending @Wait_Until_fixing_Bug
  Scénario: CAP109-[US-General-07]:update posts - text update with normal Link (space case)
    Etant donné Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    Et l'espace 'US-General-07' est crée
    Quand je clique sur poster dans l'espace
    Et je saisie une activité 'activité CAP109'
    Et je saisie une activité 'https://www.exoplatform.com/'
    Et je publie l'activité
    Et je clique sur modifier l'activité
    Et je saisie une activité 'modifier le lien'
    Et je publie l'activité
    Alors l'activité 'modifier le lien' est affiché dans l'activity stream
    Et Le lien est affiché avec le preview
  @Pending @Wait_Until_fixing_Bug
  Scénario: CAP110 - [US-General-07] : update posts - text update with video Link (space case)
    Etant donné Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    Et l'espace 'US-General-07-CAP110' est crée
    Quand je clique sur poster dans l'espace
    Et je saisie une activité 'activité CAP110'
    Et je saisie une activité 'https://www.youtube.com/embed/wgpduVyZT50?enablejsapi=1'
    Et je publie l'activité
    Et je clique sur modifier l'activité
    Et je saisie une activité 'modifier le lien'
    Et je publie l'activité
    Alors l'activité 'modifier le lien' est affiché dans l'activity stream
    Et le video 'https://www.youtube.com/embed/wgpduVyZT50?enablejsapi=1' est affiché dans l'activity stream
