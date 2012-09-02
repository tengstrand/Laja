
How to change the sidebar logo
==============================
Also add the following line to the page http://laja.wikinet.org/wiki/MediaWiki:Sidebar-logo:
http://laja.wikinet.org/w/images/laja/uploads/e/e1/Laja-logo.png

How to redirect from SourceForge to the wiki start page
=======================================================
This is described here: https://sourceforge.net/apps/trac/sourceforge/wiki/SFTP

Example:
  Download and install FileZilla.
  Add the connection 'Laja':
    Host:  web.sourceforge.net
    Port (kan be left empty): 22
    Protocol: SFTP
    Login type: Normal
    Username: tengstrand
    Password: (same as for SourceForge)
      Under the tab Advanced, directory: /home/project-web/laja/htdocs
    Add/replace the file index.php:
        <?php
        /* Redirect browser */
        header("Location: http://laja.wikinet.org");
        /* Make sure that code below does not get executed when we redirect. */
        exit;
        ?>
