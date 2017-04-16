FSU Mobile Programming (COP4656) Group Project 2: Grab Bag
===========================================================================
The game is heavily inspired by "Grab Bag", a mini-game from the original Mario Party. In the original
game, you can steal a set amount of coins from an opponent to add to your own stash by getting up
behind them. https://www.youtube.com/watch?v=c-HBQpW41EA

The primary difference between the Mario Party mini-game and this game is that this version of Grab
Bag is an Augmented Reality Game, in the loosest sense of the term. Like Pokemon Go, this game involves
interacting with other players in the real world, and you have to be within a certain distance to
attempt a steal from another player. With the two traits combined, the game is somewhat reminiscient
of live-action games such as Humans vs. Zombies where gameplay is over a week, with players trying
to subvert and defeat each other while going about their normal activities. https://humansvszombies.org/

This gives a new angle to the party game, transforming a game designed to be a short, quick blast
into a game that spans dozens of hours where your goal is to outthink and outlast your enemies.

# Contributing
All your work should be done on your own fork of this repository. When you are done with something and have pushed it to your fork, you make a pull request to update the upstream repository. Do not work on your master branch, but a side branch. Your master branch is for pulling the latest version from upstream and for making branches off of it.


## Initial setup

### Creating the fork 
Go to the main upstream repository on GitHub and click 'Fork' to create your fork. This will create a 'copy' of the repository tied to your account. This fork will be the only repo that you PUSH to. 

### Clone fork
Clone the project onto your computer to get a local copy that you can work with. There are two ways to do this:
1. Use Android Studio. Go to `Checkout from Version Control` (may be in `VCS`). Select GitHub. Pick your fork.
2. Command line clone then open project with android studio based on file location. The URL can be found on your fork's page on GitHub when you click 'Clone or download'.
```
$ git clone https://yourusername@github.com/yourusername/GrabBag.git
```

### Correcting remotes
To make it easier when doing command line git, set up some useful remotes. Set `origin` to be your fork and `upstream` to be the main repository.

```
GrabBag$ git remote set-url origin https://yourusername@github.com/yourusername/GrabBag.git
GrabBag$ git remote add upstream https://yourusername@github.com/jrdbnntt-com/GrabBag.git
```

Example Result:
```
jbennett@ubuntu:/home/extra/jbennett/dev/AndroidStudioProjects/GrabBag$ git remote -v
origin  https://jrdbnntt@github.com/jrdbnntt/GrabBag.git (fetch)
origin  https://jrdbnntt@github.com/jrdbnntt/GrabBag.git (push)
upstream        https://jrdbnntt@github.com/jrdbnntt-com/GrabBag.git (fetch)
upstream        https://jrdbnntt@github.com/jrdbnntt-com/GrabBag.git (push)
```

## How to make a change
1. Checkout your master branch
2. Update your master branch with latest from upstream
3. Make a new branch off of master branch (name should be like GH-23 for issue #23 or the name of what you are doing)
4. Checkout new branch
5. Change files while on new branch
6. Add & Commit changes
7. Repeat 5+6 until your feature/change is done
8. Push branch & commits to your FORK
9. Make a pull request to merge your branch into upstream master 
10. Resolve any conflicts if necessary
11. Complete pull request via Squash & merge (will condense all your changes to 1 commit on upstream)
12. Checkout master branch and NEVER go back to the branch you used again

See `example-pull-request.txt` for a complete example with the git commands.

