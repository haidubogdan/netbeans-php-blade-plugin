# netbeans-blade-plugin
Blade syntax highlighting for Netbeans.
Experimental version.
Inspired by :
- https://github.com/ravijajal/netbeans_blade
- https://github.com/sebhoerl/Twig-netbeans

Installation
============

Required Netbeans version **12.3**


Installing from package
----------------------

The plugin is not uploaded on netbeans site as it is still in experimental version.
There are two export nbm files available in the folder **nbm** 

1. In Netbeans open Tools -> Plugins, select Downloaded tab.
2. Click "Add plugins" and select the file from the nbm folder coresponding to the netbeans version (12.3, 12.5).
3. Select the checkbox next to the "Blade for Netbeans" plugin and click Install.
4. Restart the IDE when demanded and enjoy your new plugin.


Installing from source
----------------------

1. Clone the git repository.
2. Start a new Netbeans project, choose NetBeans module as project type.
3. Setup your project.
4. Right-click on project name and choose Create NBM.
5. Install the NBM file as described in "Installing from package".

For more information refer yourself to: http://platform.netbeans.org/tutorials/nbm-google.html


Syntax Highlighting
===================

Document scanner
----------------

To generate Lexer Scanner jflex 1.61 was used.
The flex files are in tools folder.
Still, after using the existing jflex software and the skeleton to generate the java lexer files it will require some final touches for it to work.

> jflex 1.61 can be found on https://sourceforge.net/projects/jflex/


Additional plugins

