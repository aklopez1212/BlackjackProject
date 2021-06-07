### Blackjack Project

### Overview
This program is intended to function as a basic commandline Blackjack game with
no betting, a dealer and a player, and a deck of cards.

### How To Run
Begin this program as a java application. You will be greeted with the main menu
which will have options to begin the game, see a shuffled deck, and quit game.
If you select begin game you will be given two cards and the total value of the
cards you have. The dealer will also show one card of his two. Once this phase is
complete you will have the option to 'Hit' or 'Stay'. If the user opts to stay
the dealer will begin his turn. Upon completion of the dealers turn a winner will
be decided.

### Tech Used
* Java
* Enums
* Object-Oriented Design

### Lessons Learned
This past week has started to make me feel more comfortable with utilizing multiple
classes, enums and more for a single application. That being said I still have
a long way to go, but when I consider that I am just a few weeks into this coding
program it gives me hope that the only way I go from here is up. My program at
this point in time nearly runs as intended with one fatal flaw in my game logic.
If a player or dealer bust, my code gets terminated without continuing to my
winCheck method. Now, as you may notice when reviewing my code I have somewhat
travelled down a rabbit hole of adding more code/conditionals with hopes to
correct this bug but so far to no avail. Another annoyance I have in this program
is my card output. I tried several ways to display the hand to the console and
the working way I found displays the hand in square brackets. 
